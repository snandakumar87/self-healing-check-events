package com.redhat.riskvalidationservice.beans;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.redhat.riskvalidationservice.datamodels.ApbRuns;
import com.redhat.riskvalidationservice.datamodels.Example;
import com.redhat.riskvalidationservice.datamodels.SensuEvents;
import org.apache.camel.Exchange;
import org.apache.camel.processor.aggregate.AggregationStrategy;
import org.kie.dmn.api.core.*;
import org.kie.server.api.marshalling.MarshallingFormat;
import org.kie.server.api.model.ServiceResponse;
import org.kie.server.client.*;
import org.kie.server.client.credentials.EnteredCredentialsProvider;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.*;

public class FilterStrategy implements AggregationStrategy {

    static Map<String,List<ApbRuns>> runs = new HashMap<>();
    @Override
    public Exchange aggregate(Exchange oldExchange, Exchange newExchange) {
        try {

            RestTemplate restTemplate = new RestTemplate();
            String baseUri = "http://rhpam-trial-kieserver:8080/services/rest/server/containers/DMNListExample/dmn/models/ProcessFailureDMN/dmnresult";

            org.springframework.http.HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.set("accept","application/json");
            httpHeaders.set("content-type","application/json");
            httpHeaders.set("Authorization","Basic YWRtaW5Vc2VyOmM3bHB4WExh");



            CredentialsProvider credentialsProvider = new EnteredCredentialsProvider("adminUser", "RedHat");

            KieServicesConfiguration kieServicesConfig = KieServicesFactory.newRestConfiguration("http://rhpam-trial-kieserver:8080/services/rest/server", credentialsProvider);




            KieServicesClient kieServicesClient = KieServicesFactory.newKieServicesClient(kieServicesConfig);

            DMNServicesClient dmnClient = kieServicesClient.getServicesClient(DMNServicesClient.class);

            if (newExchange.getFromRouteId().equals("readSensu")) {

                System.out.println("inside validate");
//            DMNRuntime dmnRuntime = RuleSessionFactory.createDMNRuntime();
                Example example = new Gson().fromJson(newExchange.getIn().getBody().toString(), Example.class);

                String namespace = "https://kiegroup.org/dmn/_C57E89DD-6F36-4590-809A-0B8E742F2676";
                String modelName = "ProcessFailureDMN";
//            DMNModel dmnModel = dmnClient.getModel(namespace, modelName);


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
                dmnContext.set("SensuEvents", new ObjectMapper().writeValueAsString(sensuEvents));
                if (null != runs && runs.get(example.getEntity().getSystem().getHostname()) != null) {
                    dmnContext.set("ApbRuns", runs.get(example.getEntity().getSystem().getHostname()));
                    System.out.println(runs.get(example.getEntity().getSystem().getHostname()));
                } else {
                    dmnContext.set("ApbRuns", new ArrayList<>());
                }


                dmnContext.set("Frequency", 2);
                dmnContext.set("Interval", 1);

                String json = "{\"SensuEvents\":"+dmnContext.get("SensuEvents")+",\"ApbRuns\":"+new ObjectMapper().writeValueAsString(dmnContext.get("ApbRuns"))+",\"Frequency\":"+dmnContext.get("Frequency")+",\"Interval\":"+dmnContext.get("Interval")+"}";
                System.out.println(json);

                System.out.println("dmn context"+dmnContext.get("SensuEvents")+","+dmnContext.get("ApbRuns")+","+dmnContext.get("Frequency")+","+
                        dmnContext.get("Interval"));

                HttpEntity request = new HttpEntity(json,httpHeaders);

                ResponseEntity<String> result = restTemplate.postForEntity(baseUri,request,String.class);

                String respString = result.getBody();

                Map map = new ObjectMapper().readValue(respString,HashMap.class);
                List<Map> decisionResults = (ArrayList)map.get("decisionResults");
                System.out.println(decisionResults);
                String playbook = null;
                for(Map resultMap: decisionResults) {
                    if(resultMap.get("decisionName").equals("Playbook")){
                        System.out.println(resultMap.get("result"));
                        if(playbook != null) {
                            playbook = (String) resultMap.get("result");
                        }
                    }
                }


                if (playbook!= null) {
                    ApbRuns apb = new ApbRuns();
                    apb.setApbName(playbook);
                    apb.setCheckName(sensuEvents.getCheckType());
                    apb.setHostName(sensuEvents.getHostName());
                    apb.setRunDate(new Date().getTime());


                    newExchange.getIn().setBody(new Gson().toJson(apb));

                } else {
                    newExchange.getIn().setBody(null);
                }


            } else {

                System.out.println("came here");
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
