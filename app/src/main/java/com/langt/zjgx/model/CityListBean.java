package com.langt.zjgx.model;

import com.langt.zjgx.base.BaseBean;

import java.util.List;

/**
 *
 * {
 *     result:"0" //0成功1失败
 *     resultNote:"失败原因"
 *     cityList:[{
 *      cityId:""           //城市id
 *      city:"郑州市"    //城市
 *     }]
 * }
 */
public class CityListBean extends BaseBean {
    private List<CityBean> cityList;

    public List<CityBean> getCityList() {
        return cityList;
    }

    public void setCityList(List<CityBean> cityList) {
        this.cityList = cityList;
    }

    public class CityBean{
        private String cityId;
        private String city;

        public String getCityId() {
            return cityId;
        }

        public void setCityId(String cityId) {
            this.cityId = cityId;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }
    }
}
