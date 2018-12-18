package com.example.demo;

/**
 * 抢红包
 */
public class RodRedEnvelope {

    /**
     * 抢红包积分规则
     * @param money
     * @param identity
     * @param envelopeId
     * @param envelopeNumber
     * @param user
     */
    public User  robRedEnvelope(int money,int identity,int envelopeId,int envelopeNumber,User user){
        synchronized (RodRedEnvelope.class) {
            Integer index = IdentityEnum.getIdentity(identity);
            if (index == null||index<1) {
                return user;
            }
            if (index != null) {
                getRobResult(money, index, user);
            }
            index = index - 1;
            return robRedEnvelope(money, index, envelopeId, envelopeNumber, user);
        }
    }

    /**
     * 抢红包得到积分
     * @param money
     * @param identity
     * @param user
     */
    public void  getRobResult(int money,int identity,User user){
        switch (IdentityEnum.get(identity)){
            case "NEW_USER":
                user.setNewUser(getRobMoney(money,ConfigNumberEnum.ROBPROPORTION.getIndex(),ConfigNumberEnum.INTEGRAL.getIndex(),ConfigNumberEnum.SIXTY.getIndex()));
                break;
            case "NONMAL":
                user.setNormal(getRobMoney(money,ConfigNumberEnum.ROBPROPORTION.getIndex(),ConfigNumberEnum.INTEGRAL.getIndex(),ConfigNumberEnum.TWENTY.getIndex()));
                break;
            case "VIP":
                user.setVip(getRobMoney(money,ConfigNumberEnum.ROBPROPORTION.getIndex(),ConfigNumberEnum.INTEGRAL.getIndex(),ConfigNumberEnum.TEN.getIndex()));
                break;
            case "AGENT":
                user.setMaster(getRobMoney(money,ConfigNumberEnum.ROBPROPORTION.getIndex(),ConfigNumberEnum.INTEGRAL.getIndex(),ConfigNumberEnum.TEN.getIndex()));
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
