package com.example.demo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 发红包
 */
public class SendRedEnvelope {

    private static Map<Integer,String> map=new HashMap<>();

    public SendRedEnvelope(){
        map.put(IdentityEnum.NEW_USER.getIndex(),IdentityEnum.NEW_USER.getName());
        map.put(IdentityEnum.VIP.getIndex(),IdentityEnum.VIP.getName());
        map.put(IdentityEnum.NONMAL.getIndex(),IdentityEnum.NONMAL.getName());
        map.put(IdentityEnum.NEW_USER.getIndex(),IdentityEnum.NEW_USER.getName());
    }

    /**
     * 计算用户 钱 身份 红包id 红包数量
     * @param money
     * @param identity
     * @param envelopeId
     * @param envelopeNumber
     */
    public User sendRedEnvelope(int money, int identity, List<Integer> envelopeId, int envelopeNumber, User user){
        Integer index = IdentityEnum.getIdentity(identity);
        if (index==null||index<1){
            return user;
        }
        if (index!=null){
            getSendResult(money,identity,envelopeId,envelopeNumber,user);
        }
        index=index-1;
        return sendRedEnvelope(money,index,envelopeId,envelopeNumber,user);
    }



    /**
     * 计算发红包积分 钱 和身份
     * @param money
     * @param index
     * @return
     */
    public void   getSendResult(int money, int index, List<Integer> envelopeId, int envelopeNumber, User user){

        switch (IdentityEnum.get(index)){
            case "NEW_USER":
                user.setNewUser(money*ConfigNumberEnum.SENDPROPORTION.getIndex()*ConfigNumberEnum.INTEGRAL.getIndex()*(ConfigNumberEnum.SIXTY.getIndex()));
                break;
            case "NONMAL":
                user.setNormal(money*ConfigNumberEnum.SENDPROPORTION.getIndex()*ConfigNumberEnum.INTEGRAL.getIndex()*(ConfigNumberEnum.TWENTY.getIndex()));
                break;
            case "VIP":
                user.setVip(money*ConfigNumberEnum.SENDPROPORTION.getIndex()*ConfigNumberEnum.INTEGRAL.getIndex()*(ConfigNumberEnum.TEN.getIndex()));
                break;
            case "AGENT":
                if (envelopeId!=null&&envelopeId.size()>1){
                    double total=0;
                    for (int en:envelopeId){
                        total+=en*ConfigNumberEnum.SENDPROPORTION.getIndex()*ConfigNumberEnum.INTEGRAL.getIndex()*(ConfigNumberEnum.TEN.getIndex());
                    }
                    user.setMaster(total);
                    break;
                }
                user.setMaster(money*ConfigNumberEnum.SENDPROPORTION.getIndex()*ConfigNumberEnum.INTEGRAL.getIndex()*(ConfigNumberEnum.TEN.getIndex()));
                break;
            default:
                break;
        }
    }


}
