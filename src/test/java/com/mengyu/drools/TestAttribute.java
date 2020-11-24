package com.mengyu.drools;

import com.mengyu.drools.pojo.example.Apple;
import com.mengyu.drools.pojo.example.Ticket;
import com.mengyu.drools.util.BaseTest;
import com.mengyu.drools.util.OutputDisplay;
import org.junit.Test;
import org.kie.api.runtime.KieSession;

/**
 * @author zoumengyu
 */
public class TestAttribute extends BaseTest {


    @Test
    public void testGlobalVariable(){
        KieSession kieSession = getKieSessionBySessionName("attribute-rules");
        kieSession.setGlobal("display", new OutputDisplay());
        kieSession.fireAllRules();
        kieSession.dispose();
    }

    @Test
    public void testAgendaGroup(){
        KieSession kieSession = getKieSessionByAgendaGroupAndSessionName("Apple group", "attribute-rules");
        kieSession.setGlobal("display", new OutputDisplay());
        Apple apple = new Apple();
        kieSession.insert(apple);
        kieSession.fireAllRules();
        kieSession.dispose();
    }

    @Test
    public void testSalience(){
        KieSession kieSession = getKieSessionBySessionName("attribute-rules");
        kieSession.setGlobal("display", new OutputDisplay());
        Apple apple = new Apple();
        kieSession.insert(apple);
        kieSession.fireAllRules();
        kieSession.dispose();
    }

    @Test
    public void testNoLoop1(){
        KieSession kieSession = getKieSessionBySessionName("attribute-rules");
        kieSession.setGlobal("display", new OutputDisplay());
        Ticket ticket = new Ticket();
        ticket.setAmount(100);
        kieSession.insert(ticket);
        kieSession.fireAllRules();
        kieSession.dispose();
    }

    @Test
    public void testDateEffectiveAndExpire1(){
        //setProperties()
        KieSession kieSession = getKieSessionBySessionName("attribute-rules");
        kieSession.setGlobal("display", new OutputDisplay());
        kieSession.fireAllRules();
        kieSession.dispose();
    }

    public void setProperties(){
        System.setProperty("drools.dateformat", "yyyy-MM-dd HH:mm:ss");
    }



}
