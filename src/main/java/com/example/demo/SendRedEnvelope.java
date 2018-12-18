package com.example.demo;

import java.util.*;

/**
 * 发红包
 */
public class SendRedEnvelope {

    private static List<Double> set=new LinkedList<>();
    public void addProportion(){
        set.add(0.6);
        set.add(0.2);
        set.add(0.1);
        set.add(0.1);
    }
    /**
     * 计算用户 钱 身份 红包id 红包数量
     * @param money
     * @param identity
     * @param envelopeId
     *
     */
    public User sendRedEnvelope(int money, int identity, List<Integer> envelopeId, User user){
        Integer index = IdentityEnum.getIdentity(identity);
        if (index==null||index<1){
            return user;
        }
        addProportion();
        int  scale=0;
        for (int i=index;i>0;i--){
            Double allot = set.get(scale);
            getSendResult(money,i,envelopeId,allot,user);
            scale=scale+1;
        }
        return user;
    }



    /**
     * 计算发红包积分 钱 和身份
     * @param money
     * @param index
     * @return
     */
    public void   getSendResult(int money, int index, List<Integer> envelopeId, double allot, User user){

        switch (IdentityEnum.get(index)){
            case "NEW_USER":
                user.setNewUser(money*ConfigNumberEnum.SENDPROPORTION.getIndex()*ConfigNumberEnum.INTEGRAL.getIndex()*(allot));
                break;
            case "NONMAL":
                user.setNormal(money*ConfigNumberEnum.SENDPROPORTION.getIndex()*ConfigNumberEnum.INTEGRAL.getIndex()*(allot));
                break;
            case "VIP":
                user.setVip(money*ConfigNumberEnum.SENDPROPORTION.getIndex()*ConfigNumberEnum.INTEGRAL.getIndex()*(allot));
                break;
            case "AGENT":
                if (envelopeId!=null&&envelopeId.size()>1){
                    double total=0;
                    for (int en:envelopeId){
                        total+=en*ConfigNumberEnum.SENDPROPORTION.getIndex()*ConfigNumberEnum.INTEGRAL.getIndex()*(allot);
                    }
                    user.setMaster(total);
                    break;
                }
                user.setMaster(money*ConfigNumberEnum.SENDPROPORTION.getIndex()*ConfigNumberEnum.INTEGRAL.getIndex()*(allot));
                break;
            default:
                break;
        }
    }


}
