package com.langt.zjgx.login.model;


import com.langt.zjgx.base.BaseBean;

public class MineInfoBean extends BaseBean {

    /**
     * result:"0" //0成功1失败
     * resultNote:"失败原因"
     * userIcon:"" //用户头像
     * nickName:"" //用户昵称
     * sex:””         //1-男 0-女
     * userBirthday:""  //用户生日
     * userPhone:"18337125295" //手机号
     * custSerPhone:””       //10086 客服电话
     * custSerRcToken:""   //在线客服 云通信服务器的唯一标识token，根据要求传用户id
     * userType:""            //0-普通用户 1-零售商 2-批发商 3-审核中
     * // 订单数量
     * cst0Num:""	//传统批发-待付款
     * cst1Num:""  //传统批发-拼团中
     * cst2Num:""	//传统批发-待收货
     * cst3Num:""	//传统批发-待评价
     * cst4Num:""	//传统批发-退款售后
     * <p>
     * cstrNum:""	//代销批发-待审核
     * wscNum:""	//代销批发-待收货
     * codNum:""	//代销批发-待结算
     * asNum:""	//代销批发-待处理
     * pbNum:""	//代销批发-待评价
     */

    private String userIcon;
    private String nickName;
    private int sex;
    private String userBirthday;
    private String userPhone;
    private String custSerPhone;
    private String custSerRcToken;
    private int userType;
    private int cst0Num;
    private int cst1Num;
    private int cst2Num;
    private int cst3Num;
    private int cst4Num;
    private int cstrNum;
    private int wscNum;
    private int codNum;
    private int asNum;
    private int pbNum;

    public int getCst1Num() {
        return cst1Num;
    }

    public void setCst1Num(int cst1Num) {
        this.cst1Num = cst1Num;
    }

    public int getCst2Num() {
        return cst2Num;
    }

    public void setCst2Num(int cst2Num) {
        this.cst2Num = cst2Num;
    }

    public int getCst3Num() {
        return cst3Num;
    }

    public void setCst3Num(int cst3Num) {
        this.cst3Num = cst3Num;
    }

    public int getCst4Num() {
        return cst4Num;
    }

    public void setCst4Num(int cst4Num) {
        this.cst4Num = cst4Num;
    }

    public int getCstrNum() {
        return cstrNum;
    }

    public void setCstrNum(int cstrNum) {
        this.cstrNum = cstrNum;
    }

    public int getWscNum() {
        return wscNum;
    }

    public void setWscNum(int wscNum) {
        this.wscNum = wscNum;
    }

    public int getCodNum() {
        return codNum;
    }

    public void setCodNum(int codNum) {
        this.codNum = codNum;
    }

    public int getAsNum() {
        return asNum;
    }

    public void setAsNum(int asNum) {
        this.asNum = asNum;
    }

    public int getPbNum() {
        return pbNum;
    }

    public void setPbNum(int pbNum) {
        this.pbNum = pbNum;
    }

    public int getCst0Num() {
        return cst0Num;
    }

    public void setCst0Num(int cst0Num) {
        this.cst0Num = cst0Num;
    }

    public String getUserIcon() {
        return userIcon;
    }

    public void setUserIcon(String userIcon) {
        this.userIcon = userIcon;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getUserBirthday() {
        return userBirthday;
    }

    public void setUserBirthday(String userBirthday) {
        this.userBirthday = userBirthday;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getCustSerPhone() {
        return custSerPhone;
    }

    public void setCustSerPhone(String custSerPhone) {
        this.custSerPhone = custSerPhone;
    }

    public String getCustSerRcToken() {
        return custSerRcToken;
    }

    public void setCustSerRcToken(String custSerRcToken) {
        this.custSerRcToken = custSerRcToken;
    }

    public int getUserType() {
        return userType;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }


}
