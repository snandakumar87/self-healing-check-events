package com.redhat.riskvalidationservice.routes;

import com.google.gson.Gson;
import com.redhat.riskvalidationservice.beans.CollectEventsStrategy;
import com.redhat.riskvalidationservice.beans.FilterStrategy;
import com.redhat.riskvalidationservice.beans.RiskValidationBean;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.kafka.KafkaComponent;

import java.util.logging.Logger;

public class RiskValidationRouteBuilder extends RouteBuilder {

	private static final Logger LOG = Logger.getLogger(RiskValidationRouteBuilder.class.getName());

	private String kafkaBootstrap = "localhost:9092";
	private String kafkaCreditTransferCreditorTopic = "sensu";
	private String consumerMaxPollRecords ="50000";
	private String consumerCount = "3";
	private String consumerSeekTo = "beginning";
	private String consumerGroup = "riskvalidationservice";
	private String consumerGroup2 = "risk";




	@Override
	public void configure() throws Exception {
		try {
			System.out.println("starting account validation service");


			KafkaComponent kafka = new KafkaComponent();
			kafka.setBrokers(kafkaBootstrap);
			this.getContext().addComponent("kafka", kafka);

			from("kafka:" + "event-decision" + "?brokers=" + kafkaBootstrap + "&maxPollRecords="
					+ consumerMaxPollRecords + "&seekTo=" + "beginning"
					+ "&groupId=" + consumerGroup).id("apbEvents")
					.aggregate(body().tokenize(), new CollectEventsStrategy()).completionInterval(2000)
					.bean(RiskValidationBean.class,"fireRule")
					.to("direct:sensuevents");

			from("kafka:" + "sensu-failure" + "?brokers=" + kafkaBootstrap + "&maxPollRecords="
					+ consumerMaxPollRecords + "&seekTo=" + "end"
					+ "&groupId=" + consumerGroup).routeId("readSensu")
					.log("${body}")
					.to("direct:sensuevents");
			from("direct:sensuevents")
					.aggregate(body().tokenize(), new FilterStrategy()).completionInterval(2000)
					.log("${body}")
					.bean(RiskValidationBean.class,"addReferenceData")
					.choice()
					.when(body().isNotEqualTo("Rule Check Failed"))
					.to("kafka:"+"event-decision"+ "?brokers=" + kafkaBootstrap)
					.otherwise()
					.bean(RiskValidationBean.class,"setEventDecisionHeader")
					.to("kafka:"+"failed-decision"+ "?brokers=" + kafkaBootstrap);




		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
