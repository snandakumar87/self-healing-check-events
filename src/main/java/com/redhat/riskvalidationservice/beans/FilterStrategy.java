package com.redhat.riskvalidationservice.beans;

import com.google.gson.Gson;
import com.redhat.riskvalidationservice.datamodels.ApbRuns;
import com.redhat.riskvalidationservice.datamodels.Example;
import com.redhat.riskvalidationservice.datamodels.SensuEvents;
import org.apache.camel.Exchange;
import org.apache.camel.processor.aggregate.AggregationStrategy;
import org.kie.dmn.api.core.*;
import org.kie.server.api.marshalling.MarshallingFormat;
import org.kie.server.api.model.ServiceResponse;
import org.kie.server.client.DMNServicesClient;
import org.kie.server.client.KieServicesClient;
import org.kie.server.client.KieServicesConfiguration;
import org.kie.server.client.KieServicesFactory;

import java.util.*;

public class FilterStrategy implements AggregationStrategy {

    static Map<String,List<ApbRuns>> runs = new HashMap<>();
    @Override
    public Exchange aggregate(Exchange oldExchange, Exchange newExchange) {
        try {

            System.out.println("hello");

            KieServicesConfiguration conf =
                    KieServicesFactory.newRestConfiguration("http://rhpam-trial-kieserver:8080/services/rest/server", "adminUser", "RedHat");

            conf.setMarshallingFormat(MarshallingFormat.JSON);

            KieServicesClient kieServicesClient = KieServicesFactory.newKieServicesClient(conf);

            DMNServicesClient dmnClient = kieServicesClient.getServicesClient(DMNServicesClient.class);
            if (newExchange.getFromRouteId().equals("readSensu")) {

                System.out.println("inside validate");
//            DMNRuntime dmnRuntime = RuleSessionFactory.createDMNRuntime();
                Example example = new Gson().fromJson(newExchange.getIn().getBody().toString(), Example.class);

                String namespace = "https://kiegroup.org/dmn/_C57E89DD-6F36-4590-809A-0B8E742F2676";
                String modelName = "ProcessFailureDMN";
//            DMNModel dmnModel = dmnRuntime.getModel(namespace, modelName);


                SensuEvents sensuEvents = new SensuEvents();

                newExchange.setProperty("sensuId", example.getId());

                sensuEvents.setCheckType(example.getCheck().getMetadata().getName());
                sensuEvents.setEventDate(example.getCheck().getExecuted());
                sensuEvents.setHostName(example.getEntity().getSystem().getHostname());
                sensuEvents.setStatus(String.valueOf(example.getCheck().getStatus()));

                System.out.println(example.getCheck().getMetadata().getName());

                System.out.println("sensuevent"+new Gson().toJson(sensuEvents));
                HashMap<String, List<ApbRuns>> aggregateMap = null;

                DMNContext dmnContext = dmnClient.newContext();
                dmnContext.set("SensuEvents", sensuEvents);
                if (null != runs && runs.get(example.getEntity().getSystem().getHostname()) != null) {
                    dmnContext.set("ApbRuns", runs.get(example.getEntity().getSystem().getHostname()));
                    System.out.println(runs.get(example.getEntity().getSystem().getHostname()));
                } else {
                    dmnContext.set("ApbRuns", new ArrayList<>());
                }


                dmnContext.set("Frequency", 2);
                dmnContext.set("Interval", 1);

                System.out.println("dmn context"+dmnContext.get("SensuEvents")+","+dmnContext.get("ApbRuns")+","+dmnContext.get("Frequency")+","+
                        dmnContext.get("Interval"));

                ServiceResponse<DMNResult> serverResp =
                        dmnClient.evaluateAll("DMNListExample_1.0.0",
                                namespace,
                                modelName,
                                dmnContext);

                DMNResult dmnResult = serverResp.getResult();

                DMNDecisionResult resultOffer = dmnResult.getDecisionResultByName("Invoke?");
                DMNDecisionResult playbook = dmnResult.getDecisionResultByName("Playbook");

                System.out.println("invoke" + resultOffer.getResult());
                System.out.println("playbook" + playbook.getResult());


                if (playbook.getResult() != null) {
                    ApbRuns apb = new ApbRuns();
                    apb.setApbName(playbook.getResult().toString());
                    apb.setCheckName(sensuEvents.getCheckType());
                    apb.setHostName(sensuEvents.getHostName());
                    apb.setRunDate(new Date().getTime());


                    newExchange.getIn().setBody(new Gson().toJson(apb));

                } else {
                    newExchange.getIn().setBody(null);
                }


            } else {
                Map<String, List<ApbRuns>> map = newExchange.getIn().getBody(Map.class);

                for (String key : map.keySet()) {
                    if (null != runs.get(key)) {
                        runs.get(key).addAll(map.get(key));
                    } else {
                        runs.put(key, map.get(key));
                    }
                }
                return null;
            }
            return newExchange;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
