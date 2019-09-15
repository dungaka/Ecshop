package com.langt.zjgx.message.bean;

import java.util.List;

/**
 * 消息-通知bean
 */
public class SystemMessageBean {

    /**
     * messageContent : 订单[201901272102450001]支付成功
     * messageId : a1f545a73b034d29b2dbdee2d9fadecc
     * messageTime : 2019-01-27 21:02:54
     * messageTitle : 订单通知
     * orderNo : 201901272102450001
     * state : 0
     * titleState : 1
     * orderState :
     * orderGoods : [{"goodsname":"","goodsimg":""}]
     */

    private String messageContent;
    private String messageId;
    private String messageTime;
    private String messageTitle;
    private String orderNo;
    //通知状态 0未读 1已读
    private int state;
    //通知信息类型 0系统信息，1订单信息，2店铺审核信息 订单信息链接至订单界面  其余信息链接至通知信息界面
    private int titleState;
    //titleState为1时返回  0-通用订单 1-退款订单
    private String orderState;
    private List<OrderGoodsBean> orderGoods;

    public boolean isRead(){
        return 1== state;
    }

    public String getMessageContent() {
        return messageContent;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
    }

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public String getMessageTime() {
        return messageTime;
    }

    public void setMessageTime(String messageTime) {
        this.messageTime = messageTime;
    }

    public String getMessageTitle() {
        return messageTitle;
    }

    public void setMessageTitle(String messageTitle) {
        this.messageTitle = messageTitle;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getTitleState() {
        return titleState;
    }

    public void setTitleState(int titleState) {
        this.titleState = titleState;
    }

    public String getOrderState() {
        return orderState;
    }

    public void setOrderState(String orderState) {
        this.orderState = orderState;
    }

    public List<OrderGoodsBean> getOrderGoods() {
        return orderGoods;
    }

    public void setOrderGoods(List<OrderGoodsBean> orderGoods) {
        this.orderGoods = orderGoods;
    }

    public static class OrderGoodsBean {
        /**
         * goodsname :
         * goodsimg :
         */

        private String goodsname;
        private String goodsimg;

        public String getGoodsname() {
            return goodsname;
        }

        public void setGoodsname(String goodsname) {
            this.goodsname = goodsname;
        }

        public String getGoodsimg() {
            return goodsimg;
        }

        public void setGoodsimg(String goodsimg) {
            this.goodsimg = goodsimg;
        }
    }
}
