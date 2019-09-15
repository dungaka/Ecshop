package com.langt.zjgx.mine.model;

import com.langt.zjgx.base.BaseBean;

import java.io.Serializable;
import java.util.List;

/**
 * @author SongQinDong
 * @description:我的地址
 * @date :2019/7/10 0010 17:59
 */
public class MyAddrListBean extends BaseBean implements Serializable {


    /**
     * result:"0" //0成功1失败
     * resultNote:"失败原因"
     * totalPage:5//总页数
     * addrList:[{
     * addrId:""            //地址id
     * addrName:""            //联系人姓名
     * addrPhone:""        //联系电话
     * province:"河南省"   //省
     * city:"郑州市"       //城市
     * town:"金水区"       //区县
     * provinceId:""      //省份id
     * cityId:""     //城市id
     * townId:""     //区县id
     * detailedAddr:""        //详细地址
     * isDefault:""        //0.是默认  1.不是
     * }]
     */

    private int totalPage;
    private List<AddrListBean> addrList;

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public List<AddrListBean> getAddrList() {
        return addrList;
    }

    public void setAddrList(List<AddrListBean> addrList) {
        this.addrList = addrList;
    }

    public static class  AddrListBean implements Serializable {
        /**
         * addrId :
         * addrName :
         * addrPhone :
         * province : 河南省
         * city : 郑州市
         * town : 金水区
         * provinceId :
         * cityId :
         * townId :
         * detailedAddr :
         * isDefault :
         */

        private String addrId;
        private String addrName;
        private String addrPhone;
        private String province;
        private String city;
        private String town;
        private String provinceId;
        private String cityId;
        private String townId;
        private String detailedAddr;
        private int isDefault;

        public String getAddrId() {
            return addrId;
        }

        public void setAddrId(String addrId) {
            this.addrId = addrId;
        }

        public String getAddrName() {
            return addrName;
        }

        public void setAddrName(String addrName) {
            this.addrName = addrName;
        }

        public String getAddrPhone() {
            return addrPhone;
        }

        public void setAddrPhone(String addrPhone) {
            this.addrPhone = addrPhone;
        }

        public String getProvince() {
            return province;
        }

        public void setProvince(String province) {
            this.province = province;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getTown() {
            return town;
        }

        public void setTown(String town) {
            this.town = town;
        }

        public String getProvinceId() {
            return provinceId;
        }

        public void setProvinceId(String provinceId) {
            this.provinceId = provinceId;
        }

        public String getCityId() {
            return cityId;
        }

        public void setCityId(String cityId) {
            this.cityId = cityId;
        }

        public String getTownId() {
            return townId;
        }

        public void setTownId(String townId) {
            this.townId = townId;
        }

        public String getDetailedAddr() {
            return detailedAddr;
        }

        public void setDetailedAddr(String detailedAddr) {
            this.detailedAddr = detailedAddr;
        }

        public int getIsDefault() {
            return isDefault;
        }

        public void setIsDefault(int isDefault) {
            this.isDefault = isDefault;
        }
    }
}
