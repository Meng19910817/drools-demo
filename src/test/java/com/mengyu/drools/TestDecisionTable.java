package com.mengyu.drools;

import com.mengyu.drools.util.BaseTest;
import org.drools.decisiontable.InputType;
import org.drools.decisiontable.SpreadsheetCompiler;
import org.junit.Test;
import org.kie.api.runtime.KieSession;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 * @author zoumengyu
 */
public class TestDecisionTable extends BaseTest {

    @Test
    public void testDecision1() throws Exception {
        File file = new File("/Users/zoumengyu/Desktop/UbrDroolsDemo/src/main/resources/com.mengyu.drools/decision/decision.xls");
        InputStream is = new FileInputStream(file);
        SpreadsheetCompiler compiler = new SpreadsheetCompiler();
        String drl = compiler.compile(is, InputType.XLS);
        System.out.println(drl);

    }

    @Test
    public void testDecisionTableRules1() {
        KieSession kieSession = getKieSessionBySessionName("decision-rules");
        kieSession.fireAllRules();
        kieSession.dispose();
    }
}
