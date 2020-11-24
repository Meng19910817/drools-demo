package com.mengyu.drools;

import com.mengyu.drools.pojo.example.Apple;
import com.mengyu.drools.util.BaseTest;
import org.junit.Before;
import org.junit.Test;
import org.kie.api.runtime.KieSession;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zoumengyu
 */
public class TestApple extends BaseTest {

    @Before
    public void setSystemProperties(){
        System.setProperty("drools.dateformat","yyyy-MM-dd HH:mm");
    }

    @Test
    public void testCreateAnApple1(){
        KieSession kieSession = getKieSessionBySessionName("apple-rules");
        kieSession.fireAllRules();
        kieSession.dispose();
    }

    @Test
    public void testCreateAnApple2(){
        KieSession kieSession = getKieSessionBySessionName("apple-rules");
        // set a global variable
        Apple apple = new Apple();

        kieSession.insert(apple);
        kieSession.fireAllRules();
        kieSession.dispose();
    }

    @Test
    public void testFilterRedApples1(){
        KieSession kieSession = getKieSessionBySessionName("apple-rules");
        Apple apple = new Apple();
        apple.setColor("red");
        kieSession.insert(apple);
        kieSession.fireAllRules();
        kieSession.dispose();
    }

    @Test
    public void testFilterRedApples2(){
        KieSession kieSession = getKieSessionBySessionName("apple-rules");
        Apple apple = new Apple();
        apple.setColor("green");
        kieSession.insert(apple);
        kieSession.fireAllRules();
        kieSession.dispose();
    }

    @Test
    public void testRedAndGreaterThan50(){
        KieSession kieSession = getKieSessionBySessionName("apple-rules");
        Apple apple = new Apple();
        apple.setColor("green");
        apple.setWeight(Double.valueOf(88));
        kieSession.insert(apple);
        kieSession.fireAllRules();
        kieSession.dispose();
    }

    @Test
    public void testFindYellowApple(){
        KieSession kieSession = getKieSessionBySessionName("apple-rules");
        List<Apple> blanket = new ArrayList<>();
        Apple redApple = new Apple("red", 58);
        Apple greenApple = new Apple("green", 55);
        Apple yellowApple = new Apple("yellow", 50);
        blanket.add(redApple);
        blanket.add(greenApple);
        blanket.add(yellowApple);
        kieSession.insert(blanket);
        kieSession.insert(redApple);
        kieSession.insert(greenApple);
        kieSession.insert(yellowApple);
        kieSession.fireAllRules();
        kieSession.dispose();
    }
}
