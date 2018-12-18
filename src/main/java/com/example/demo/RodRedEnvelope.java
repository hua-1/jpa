package com.example.demo;

import java.util.LinkedList;
import java.util.List;

/**
 * 抢红包
 */
public class RodRedEnvelope {

    private static List<Double> set=new LinkedList<>();
    public void addProportion(){
        set.add(0.6);
        set.add(0.2);
        set.add(0.1);
        set.add(0.1);
    }

    /**
     * 抢红包积分规则
     * @param money
     * @param identity
     * @param envelopeId
     * @param
     * @param user
     */
    public User  robRedEnvelope(int money,int identity,int envelopeId,User user){
        synchronized (RodRedEnvelope.class) {
            Integer index = IdentityEnum.getIdentity(identity);
            if (index == null||index<1) {
                return user;
            }
            addProportion();
            int  scale=0;
            for (int i=index;i>0;i--){
                Double allot = set.get(scale);
                getRobResult(money,i,allot,user);
                scale=scale+1;
            }
            return user;
        }
    }

    /**
     * 抢红包得到积分
     * @param money
     * @param identity
     * @param user
     */
    public void  getRobResult(int money,int identity,double allot,User user){
        switch (IdentityEnum.get(identity)){
            case "NEW_USER":
                user.setNewUser(getRobMoney(money,ConfigNumberEnum.ROBPROPORTION.getIndex(),ConfigNumberEnum.INTEGRAL.getIndex(),allot));
                break;
            case "NONMAL":
                user.setNormal(getRobMoney(money,ConfigNumberEnum.ROBPROPORTION.getIndex(),ConfigNumberEnum.INTEGRAL.getIndex(),allot));
                break;
            case "VIP":
                user.setVip(getRobMoney(money,ConfigNumberEnum.ROBPROPORTION.getIndex(),ConfigNumberEnum.INTEGRAL.getIndex(),allot));
                break;
            case "AGENT":
                user.setMaster(getRobMoney(money,ConfigNumberEnum.ROBPROPORTION.getIndex(),ConfigNumberEnum.INTEGRAL.getIndex(),allot));
                break;
            default:
            break;
        }
    }

    /**
     * 抢红包可用
     * @param money
     * @param robProportion
     * @param integral
     * @param ten
     * @return
     */
    public double getRobMoney(int money,double robProportion,double integral,double ten ){
        double four = ((money * robProportion *integral) / getRedNumber(money)) * (ten);
       return  (double) Math.round(four* 100) / 100;
    }
    /**
     * 可用金额 得到红包个数
     * @param money
     * @return
     */
    public int getRedNumber(int money){
        Double moneyNumber = (money * ConfigNumberEnum.ENDPROPORTION.getIndex()) / ConfigNumberEnum.MONEY_MIX.getIndex();
        if (moneyNumber!=null){
            return     moneyNumber.intValue();
        }
        return 0;
    }


}
