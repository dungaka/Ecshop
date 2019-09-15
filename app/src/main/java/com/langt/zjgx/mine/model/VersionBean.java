package com.langt.zjgx.mine.model;

import com.langt.zjgx.base.BaseBean;

/**
 * @author SongQinDong
 * @description:5.3 设置-版本更新
 * @date :2019/7/8 0008 17:54
 */
public class VersionBean extends BaseBean {
    private String versionNumber;//版本号（移动端提供）
    private String versionName; //版本名字（移动端提供）
    private String updataAddress;//下载地址
    private String descc; //简介

    public String getVersionNumber() {
        return versionNumber;
    }

    public void setVersionNumber(String versionNumber) {
        this.versionNumber = versionNumber;
    }

    public String getVersionName() {
        return versionName;
    }

    public void setVersionName(String versionName) {
        this.versionName = versionName;
    }

    public String getUpdataAddress() {
        return updataAddress;
    }

    public void setUpdataAddress(String updataAddress) {
        this.updataAddress = updataAddress;
    }

    public String getDescc() {
        return descc;
    }

    public void setDescc(String descc) {
        this.descc = descc;
    }
}
