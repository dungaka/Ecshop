package com.langt.zjgx.message.bean;

import android.text.TextUtils;

import java.io.Serializable;
import java.util.List;

/**
 * 申诉bean
 */
public class AppealBean implements Serializable {
    private String appealId; //申诉id
    private String appealType; //申诉类型
    private String appealTitle; //申诉主题
    private String appealTime; //申诉时间
    private String appealContent; //申诉内容
    private List<String> imgList;  // 申诉图片
    private String state;  // 0-待处理 1-已处理
    private String handleTime;  // 处理时间
    private String advice;  // 处理意见

    public AppealBean() {
    }

    public AppealBean(String state, String appealTitle, String appealContent) {
        this.state = state;
        this.appealTitle = appealTitle;
        this.appealContent = appealContent;
    }

    public String getAppealId() {
        return TextUtils.isEmpty(appealId)?"":appealId;
    }

    public void setAppealId(String appealId) {
        this.appealId = appealId;
    }

    public String getAppealType() {
        return appealType;
    }

    public void setAppealType(String appealType) {
        this.appealType = appealType;
    }

    public String getAppealTitle() {
        return appealTitle;
    }

    public void setAppealTitle(String appealTitle) {
        this.appealTitle = appealTitle;
    }

    public String getAppealTime() {
        return appealTime;
    }

    public void setAppealTime(String appealTime) {
        this.appealTime = appealTime;
    }

    public String getAppealContent() {
        return appealContent;
    }

    public void setAppealContent(String appealContent) {
        this.appealContent = appealContent;
    }

    public List<String> getImgList() {
        return imgList;
    }

    public void setImgList(List<String> imgList) {
        this.imgList = imgList;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getHandleTime() {
        return handleTime;
    }

    public void setHandleTime(String handleTime) {
        this.handleTime = handleTime;
    }

    public String getAdvice() {
        return advice;
    }

    public void setAdvice(String advice) {
        this.advice = advice;
    }
}
