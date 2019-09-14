package com.langt.zjgx.server;

import android.text.TextUtils;
import android.util.Log;

import com.langt.zjgx.base.BaseBean;
import com.langt.zjgx.goods.bean.MyGoodsListBean;
import com.langt.zjgx.location.bean.CityIdBean;
import com.langt.zjgx.login.model.UserLoginBean;
import com.langt.zjgx.mine.model.MyAddrListBean;
import com.langt.zjgx.mine.model.MyCollectListBean;
import com.langt.zjgx.model.HomePageBean;
import com.langt.zjgx.model.HomeRecommendGoodsBean;
import com.langt.zjgx.model.ShopListResultBean;
import com.langt.zjgx.search.model.HotSearchListResultModel;
import com.langt.zjgx.utils.CoreLib;
import com.langt.zjgx.utils.GsonUtils;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observable;

public class HttpClient {


    public Observable<BaseBean> sendSmsCode(String userId, String userPhone, String type) {
        Map<String, Object> params = new HashMap<>();
        params.put("cmd", "sendSmsCode");
        if (!TextUtils.isEmpty(userId)) {
            params.put("userId", userId);
        }
        params.put("userPhone", userPhone);
        params.put("type", type);
        return getApi().sendSmsCode(toJson(params));
    }

    public Observable<UserLoginBean> userLogin(String userPhone, String password) {
        Map<String, Object> params = new HashMap<>();
        params.put("cmd", "userLogin");
        params.put("userPhone", userPhone);
        params.put("password", password);
        return getApi().userLogin(toJson(params));
    }

    public Observable<UserLoginBean> thirdLogin(String thirdUid, String nickName, String userIcon) {
        Map<String, Object> params = new HashMap<>();
        params.put("cmd", "thirdLogin");
        params.put("thirdUid", thirdUid);
        params.put("nickName", nickName);
        params.put("userIcon", userIcon);
        return getApi().thirdLogin(toJson(params));
    }

    public Observable<BaseBean> forgetPassword(String userPhone, String password, String smsCode) {
        Map<String, Object> params = new HashMap<>();
        params.put("cmd", "forgetPassword");
        params.put("userPhone", userPhone);
        params.put("password", password);
        params.put("smsCode", smsCode);
        return getApi().forgetPassword(toJson(params));
    }


    public Observable<BaseBean> userRegister(String userPhone, String password, String smsCode) {
        Map<String, Object> params = new HashMap<>();
        params.put("cmd", "userRegister");
        params.put("userPhone", userPhone);
        params.put("password", password);
        params.put("smsCode", smsCode);
        return getApi().userRegister(toJson(params));
    }


    /**
     * 设置默认地址
     *
     * @param userId
     * @param addrId
     * @return
     */
    public Observable<BaseBean> setDefaultAddr(String userId, String addrId) {
        Map<String, Object> params = new HashMap<>();
        params.put("cmd", "setDefaultAddr");
        params.put("userId", userId);
        params.put("addrId", addrId);
        return getApi().setDefaultAddr(toJson(params));
    }

    /**
     * 我的地址管理
     *
     * @param userId
     * @param nowPage
     * @return
     */
    public Observable<MyAddrListBean> getMyAddrList(String userId, int nowPage) {
        Map<String, Object> params = new HashMap<>();
        params.put("cmd", "getMyAddrList");
        params.put("userId", userId);
        params.put("nowPage", nowPage);
        return getApi().getMyAddrList(toJson(params));
    }

    /**
     * 我的收藏
     *
     * @param userId
     * @param type
     * @param nowPage
     * @return
     */
    public Observable<MyCollectListBean> getMyCollectList(String userId, int type, int nowPage) {
        Map<String, Object> params = new HashMap<>();
        params.put("cmd", "getMyCollectList");
        params.put("userId", userId);
        params.put("type", type);
        params.put("nowPage", nowPage);
        return getApi().getMyCollectList(toJson(params));
    }

    /**
     * 意见反馈
     *
     * @param userId
     * @param fdTitle
     * @param fdContent
     * @return
     */
    public Observable<BaseBean> feedBack(String userId, String fdTitle, String fdContent) {
        Map<String, Object> params = new HashMap<>();
        params.put("cmd", "feedBack");
        params.put("userId", userId);
        params.put("fdTitle", fdTitle);
        params.put("fdContent", fdContent);
        return getApi().feedBack(toJson(params));
    }

    /**
     * 2.0 获取热门搜索列表
     *
     * @return
     */
    public Observable<CityIdBean> getLocationCity(String province, String city) {
        Map<String, Object> params = new HashMap<>();
        params.put("cmd", "getRecomSkeyList");
        params.put("province", province);
        params.put("city", city);
        return getApi().getLocationCityId(toJson(params));
    }

    /**
     * 2.2 获取热门搜索列表
     *
     * @return
     */
    public Observable<HomePageBean> getHomePageInfo() {
        Map<String, Object> params = getCommonMap("getMainInfo");
        params.put("cityId", CoreLib.getCityId());
        params.put("lng", CoreLib.getLongitude());
        params.put("lat", CoreLib.getLatitude());
        return getApi().getHomePageInfo(toJson(params));
    }

    /**
     * 2.3 首页推荐商品
     */
    public Observable<HomeRecommendGoodsBean> getHomeRecommendGoodsList(String flag, int nowPage) {
        Map<String, Object> params = getCommonMap("getRecomGoodsList");
        params.put("flag", flag);
        params.put("lng", CoreLib.getLongitude());
        params.put("lat", CoreLib.getLatitude());
        params.put("nowPage", nowPage);
        return getApi().getHomeRecommendGoodsList(toJson(params));
    }

    /**
     * 2.4 获取热门搜索列表
     */
    public Observable<HotSearchListResultModel> getHotSearchList() {
        Map<String, Object> params = getCommonMap("getRecomSkeyList");
        return getApi().getHotSearchList(toJson(params));
    }

    /**
     * 2.5 获取商品列表
     * {
     * cmd:"searchGoodsList"
     * userId:"5"   //用户id
     * cityId:""       //城市id
     * lng:""          //地理经度
     * lat:""          //地理纬度
     * searchKey:""    //搜索关键字
     * nowPage:””
     * }
     */
    public Observable<MyGoodsListBean> searchGoodsList(String key, int nowPage) {
        Map<String, Object> params = getCommonMap("searchGoodsList");
        params.put("cityId", CoreLib.getCityId());
        params.put("lng", CoreLib.getLongitude());
        params.put("lat", CoreLib.getLatitude());
        params.put("key", key);
        params.put("nowPage", nowPage);
        return getApi().searchGoodsList(toJson(params));
    }

    /**
     * 2.17 附近好店 更多 店铺列表搜索
     {
     shopTypeId:""      //店铺分类id        传空默认全部
     searchKey:""    //搜索关键字
     nowPage:"1"     //页数
     }
     */
    public Observable<ShopListResultBean> searchNearShopList(String key, int nowPage) {
        Map<String, Object> params = getCommonMap("getNearShopList");
        params.put("cityId", CoreLib.getCityId());
        params.put("lng", CoreLib.getLongitude());
        params.put("lat", CoreLib.getLatitude());
        params.put("shopTypeId", "");
        params.put("searchKey", key);
        params.put("nowPage", nowPage);
        return getApi().searchNearShopList(toJson(params));
    }

    /**
     * 获取通用map，包含用户id
     *
     * @param cmdMethod 接口名称
     */
    private static Map<String, Object> getCommonMap(String cmdMethod) {
        Map<String, Object> params = new HashMap<>();
        params.put("cmd", cmdMethod);
        params.put("userId", CoreLib.getUserId());
        return params;
    }

    private static ApiServer getApi() {
        return ApiRetrofit.getInstance().getApiServer();
    }


    private String toJson(Map<String, Object> params) {
        String json = GsonUtils.toJson(params);
        Log.i("OkHttp", "request======>> " + json);
        return json;
    }
}
