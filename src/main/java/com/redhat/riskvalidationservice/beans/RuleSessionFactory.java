package com.redhat.riskvalidationservice.beans;

import org.kie.api.KieServices;
import org.kie.api.builder.ReleaseId;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieRuntimeFactory;
import org.kie.api.runtime.KieSession;
import org.kie.dmn.api.core.DMNRuntime;

public class RuleSessionFactory {


    protected static DMNRuntime createDMNRuntime() {
        KieServices kieServices = KieServices.Factory.get();

        ReleaseId releaseId = kieServices.newReleaseId( "com.myspace", "DMNListExample", "15.0.0" );
        KieContainer kieContainer = kieServices.newKieContainer(releaseId  );
        DMNRuntime dmnRuntime = KieRuntimeFactory.of(kieContainer.getKieBase()).get(DMNRuntime.class);

        return dmnRuntime;
    }




}