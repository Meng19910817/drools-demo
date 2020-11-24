package com.mengyu.drools.util;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

/**
 * @author zoumengyu
 */
public class BaseTest {

    protected KieSession getKieSessionBySessionName(String sessionName){
        KieServices kieServices = KieServices.get();
        KieContainer kieContainer = kieServices.getKieClasspathContainer();
        KieSession kieSession = kieContainer.newKieSession(sessionName);
        return kieSession;
    }

    protected KieSession getKieSessionByAgendaGroupAndSessionName(String agendaGroup, String sessionName){
        KieSession kieSession = getKieSessionBySessionName(sessionName);
        kieSession.getAgenda().getAgendaGroup(agendaGroup).setFocus();
        return kieSession;
    }

}