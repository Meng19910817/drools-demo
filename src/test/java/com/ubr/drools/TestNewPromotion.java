package com.ubr.drools;

import com.ubr.drools.pojo.Check;
import com.ubr.drools.pojo.Product;
import com.ubr.drools.pojo.ProductLine;
import com.ubr.drools.util.BaseTest;
import org.junit.Test;
import org.kie.api.runtime.KieSession;

import java.util.ArrayList;
import java.util.List;

public class TestNewPromotion extends BaseTest {

    private double buyAccount;
    private double lessBuyAccount;

    private void test1() {
        KieSession kieSession = getKieSessionBySessionName("buy-and-refund-rules");

        Check Check = new Check();
        ProductLine productLine1 = new ProductLine(new Product("A", 20), 4);
        ProductLine productLine2 = new ProductLine(new Product("B", 30), 2);
        ProductLine productLine3 = new ProductLine(new Product("C", 10), 2);
        List<ProductLine> lines = new ArrayList<>();
        lines.add(productLine1);
        lines.add(productLine2);
        lines.add(productLine3);
        Check.setProductLines(lines);
        this.insertIntoSession(kieSession, Check);
        kieSession.fireAllRules();
        System.out.println("DiscountAmount is " + Check.getDiscountAmount());
        this.setBuyAccount(Check.getDiscountAmount());
        kieSession.dispose();
        System.out.println("================================================");
    }


    private void test2(){
        KieSession kieSession = getKieSessionBySessionName("buy-and-refund-rules");
        Check Check = new Check();
        ProductLine productLine1 = new ProductLine(new Product("A", 20), 2);
        ProductLine productLine2 = new ProductLine(new Product("B", 30), 2);
        ProductLine productLine3 = new ProductLine(new Product("C", 10), 2);
        List<ProductLine> lines = new ArrayList<>();
        lines.add(productLine1);
        lines.add(productLine2);
        lines.add(productLine3);
        Check.setProductLines(lines);
        this.insertIntoSession(kieSession, Check);
        kieSession.fireAllRules();
        this.setLessBuyAccount(Check.getDiscountAmount());
        System.out.println("Less DiscountAmount is " + Check.getDiscountAmount());
        kieSession.dispose();
        System.out.println("================================================");
    }

    @Test
    public void test3() {
        test1();
        test2();
        double refundAmount = this.getBuyAccount() - this.getLessBuyAccount();
        System.out.println("The refund amount is " + refundAmount);

    }

    private void insertIntoSession(KieSession kieSession, Check Check) {
        kieSession.insert(Check);
        if(Check.getProductLines() != null){
           kieSession.insert(Check.getProductLines());
           for(ProductLine productLine : Check.getProductLines()){
               kieSession.insert(productLine);
               kieSession.insert(productLine.getProduct());
           }
        }
    }

    private void setBuyAccount(double buyAccount) {
        this.buyAccount = buyAccount;
    }

    private void setLessBuyAccount(double lessBuyAccount) {
        this.lessBuyAccount = lessBuyAccount;
    }

    private double getBuyAccount() {
        return buyAccount;
    }

    private double getLessBuyAccount() {
        return lessBuyAccount;
    }


}
