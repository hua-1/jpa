package com.example.demo;

public class RedEnvelope {

    /**
     * 钱和人数
     * @param money
     * @param person
     */
    public  void checkMoneyNumber(Integer money,Integer person){
        if (money==null||money==0){
            throw new RuntimeException("输入错误");
        }
        if (person==null||person==0){
            throw new RuntimeException("输入错误");
        }
        if (money<ConfigNumberEnum.MONEY_MIX.getIndex()){
            System.out.println("红包金额大于20元");
        }
        //抽成
        double commission = money * ConfigNumberEnum.PLATFORM_RATE.getIndex();
        //抽成后的金额
        double commissionLater = money - commission;
        double aDouble = commissionLater / person;
        if (aDouble<0.1){
            System.out.println("不符合红包人数0.1元的要求");
        }
    }

    /**
     * 可用金额 得到红包个数
     * @param money
     * @return
     */
    public int getRedNumber(int money){
        double v = (money * ConfigNumberEnum.ENDPROPORTION.getIndex()) / ConfigNumberEnum.MONEY_MIX.getIndex();
        return (int) v;
    }

    /**
     * 会员分销奖励
     * @param index
     * @param money
     * @param total
     */
    public void getLevelIntegral(int index,int money,int total){
        Integer level = IdentityEnum.getIdentity(index);
        if (level==null){
            return;//TODo 数据
        }
        switch (level){
            case 1:
                double one = money * ConfigNumberEnum.INTEGRAL.getIndex() * ConfigNumberEnum.SIXTY.getIndex();
                System.out.println(one);
            case 2:
                double two = money * ConfigNumberEnum.INTEGRAL.getIndex() * ConfigNumberEnum.TWENTY.getIndex();
                System.out.println(two);
            case 3:
                double three = money * ConfigNumberEnum.INTEGRAL.getIndex() * ConfigNumberEnum.TEN.getIndex();
                System.out.println(three);
            case 4:
                Double four=null;
                if (total>0){
                    four = getResult(total, money, 0.0);
                }else {
                    four = money * ConfigNumberEnum.INTEGRAL.getIndex() * ConfigNumberEnum.TEN.getIndex();
                }
                System.out.println(four);
        }
    }

    public double getResult(int total,int money,double moneyNumber){
        if(total<1){
            return moneyNumber;
        }
        moneyNumber=money*ConfigNumberEnum.INTEGRAL.getIndex() * ConfigNumberEnum.TEN.getIndex();
        total=total-1;
        return getResult(total,money,moneyNumber);
    }
}
