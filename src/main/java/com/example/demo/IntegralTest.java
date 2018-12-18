package com.example.demo;

public class IntegralTest {
    public static void main(String[] args) {
        RedEnvelope red=new RedEnvelope();
        red.checkMoneyNumber(20,23);
        SendRedEnvelope envelope=new SendRedEnvelope();
        User user=new User();
        envelope.sendRedEnvelope(20,2,null,0,user);
        System.out.println(user.getNormal());

        User user1=new User();
        RodRedEnvelope redEnvelope=new RodRedEnvelope();
        redEnvelope.robRedEnvelope(20,1,0,0,user1);

        System.out.println(user1.getNormal());
    }
}
