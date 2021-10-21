package com.redhat.riskvalidationservice.beans;

import com.google.gson.Gson;
import com.redhat.riskvalidationservice.datamodels.ApbRuns;
import com.redhat.riskvalidationservice.datamodels.Example;
import com.redhat.riskvalidationservice.datamodels.SensuEvents;
import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.processor.aggregate.AggregationStrategy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CollectEventsStrategy implements AggregationStrategy {

    @Override
    public Exchange aggregate(Exchange oldExchange, Exchange newExchange) {
        try {

            HashMap<String, List<ApbRuns>> inlineMap = null;
            List<ApbRuns> inlineRuns = null;
            Example sensuEvents = null;
            ApbRuns apbRuns = null;
            if (null != oldExchange) {
                inlineMap = (HashMap<String, List<ApbRuns>>) oldExchange.getProperty("aggregateMap");
            }
           if (newExchange.getFromRouteId().equals("apbEvents")) {
                apbRuns = new Gson().fromJson(newExchange.getIn().getBody().toString(), ApbRuns.class);

                if (null == inlineMap) {
                    inlineMap = new HashMap<>();


                }
                if(null != apbRuns) {

                    inlineRuns = inlineMap.get(apbRuns.getHostName());
                    if (null == inlineRuns) {
                        inlineRuns = new ArrayList<>();
                    }
                    inlineRuns.add(apbRuns);
                    inlineMap.put(apbRuns.getHostName(), inlineRuns);
                }



            }

            newExchange.setProperty("aggregateMap", inlineMap);


//        if (oldExchange == null) {
//            ApbRuns newItem= new Gson().fromJson(newExchange.getIn().getBody().toString(),ApbRuns.class);
//
//
//            System.out.println("Aggregate first item: " + newItem);
//
//
//
//                List currentItems = new ArrayList();
//                currentItems.add(newItem);
//
//                newItem.setRunningList(currentItems);
//
//
//            newExchange.getIn().setBody(newItem);
//
//            // the first time we aggregate we only have the new exchange,
//            // so we just return it
//            return newExchange;
//        }
//        ApbRuns item = oldExchange.getIn().getBody(ApbRuns.class);
//
//            item.getRunningList().add(item);
//
//            newExchange.getIn().setBody(item);


            // return old as this is the one that has all the orders gathered until now
        }catch(Exception e) {
            e.printStackTrace();
        }
        return newExchange;
    }


}
