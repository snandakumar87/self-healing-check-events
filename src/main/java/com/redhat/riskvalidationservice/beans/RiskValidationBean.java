package com.redhat.riskvalidationservice.beans;

import com.google.gson.Gson;

import com.redhat.riskvalidationservice.datamodels.ApbRuns;
import com.redhat.riskvalidationservice.datamodels.Example;
import com.redhat.riskvalidationservice.datamodels.SensuEvents;
import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.jboss.resteasy.client.jaxrs.BasicAuthentication;
import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;
import org.jboss.resteasy.client.jaxrs.engines.URLConnectionEngine;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.dmn.api.core.*;
import org.kie.dmn.core.util.KieHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.ws.rs.client.WebTarget;
import java.util.*;
import java.util.logging.Logger;

@Service
public class RiskValidationBean {

	private static final Logger LOG = Logger.getLogger(RiskValidationBean.class.getName());

	private static final String KSESSION = "";

	private final KieContainer kieContainer;


	@Autowired
	public RiskValidationBean(KieContainer kieContainer) {
		LOG.info("Initializing a new session.");
		this.kieContainer = kieContainer;
	}

	public String addReferenceData(Exchange exchange) {

		if (null != exchange.getIn().getBody()) {
			return String.valueOf(exchange.getIn().getBody());
		} else {

			return "Rule Check Failed";
		}
	}

		public String setEventDecisionHeader(Exchange exchange) {
			exchange.getIn().setHeader("kafka.KEY",exchange.getProperty("sensuId"));
			return "Rule Failed";
		}





	public String collectSensu(Exchange exchange){

		System.out.println("came to collectSensu");

		Map<String,String> stringMap = new HashMap<>();

		ApbRuns apbRuns = exchange.getIn().getBody(ApbRuns.class);
		List<ApbRuns> listForHost;

		for(ApbRuns apbRuns1:apbRuns.getRunningList()) {
			if(null != stringMap.get(apbRuns1.getHostName())) {
				listForHost = new Gson().fromJson(stringMap.get(apbRuns1.getHostName()),List.class);
				listForHost.add(apbRuns1);
				stringMap.put(apbRuns1.getHostName(),new Gson().toJson(listForHost));
				continue;

			}
			listForHost = new ArrayList<>();
			listForHost.add(apbRuns1);
			stringMap.put(apbRuns1.getHostName(),new Gson().toJson(listForHost));

		}

		stringMap.put("apbRuns",exchange.getIn().getBody().toString());
		exchange.getContext().setGlobalOptions(stringMap);

		return "val";
	}

	public Map fireRule(Exchange body) {

		System.out.println("came to fireRule");




		return (Map) body.getProperty("aggregateMap");
	}


	public KieContainer getKieContainer() {
		return kieContainer;
	}


	public String prepareELKCall(Exchange exchange) {
		System.out.println("inside prepare call"+exchange.getIn().getBody());
		return exchange.getIn().getBody().toString();
	}


}
