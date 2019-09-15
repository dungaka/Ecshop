package com.langt.zjgx.server;

import android.util.Log;

import com.langt.zjgx.base.BaseBean;
import com.langt.zjgx.goods.bean.MyGoodsListBean;
import com.langt.zjgx.location.bean.CityIdBean;
import com.langt.zjgx.login.model.UserLoginBean;
import com.langt.zjgx.message.bean.AppealDetailBean;
import com.langt.zjgx.message.bean.AppealListBean;
import com.langt.zjgx.message.bean.SystemMessageListBean;
import com.langt.zjgx.message.bean.UnReadMessageCountBean;
import com.langt.zjgx.mine.model.MyAddrListBean;
import com.langt.zjgx.mine.model.MyCollectListBean;
import com.langt.zjgx.model.CityListBean;
import com.langt.zjgx.model.GoodsBean;
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

    /**
     * 1.0 发送验证码
     */
    public Observable<BaseBean> sendSmsCode(String userPhone, String type) {
        Map<String, Object> params = getCommonMap("sendSmsCode");
        params.put("userPhone", userPhone);
        params.put("type", type);
        return getApi().sendSmsCode(toJson(params));
    }

    /**
     * 1.1 用户注册
     */
    public Observable<BaseBean> userRegister(String userPhone, String password, String smsCode) {
        Map<String, Object> params = getCommonMap("userRegister");
        params.put("userPhone", userPhone);
        params.put("password", password);
        params.put("smsCode", smsCode);
        return getApi().userRegister(toJson(params));
    }

    /**
     * 1.2 服务器登录
     */
    public Observable<UserLoginBean> userLogin(String userPhone, String password) {
        Map<String, Object> params = getCommonMap("userLogin");
        params.put("userPhone", userPhone);
        params.put("password", password);
        return getApi().userLogin(toJson(params));
    }

    /**
     * 1.3忘记密码
     */
    public Observable<BaseBean> forgetPassword(String userPhone, String password, String smsCode) {
        Map<String, Object> params = getCommonMap("forgetPassword");
        params.put("userPhone", userPhone);
        params.put("password", password);
        params.put("smsCode", smsCode);
        return getApi().forgetPassword(toJson(params));
    }

    /**
     * 1.4 第三方登录
     */
    public Observable<UserLoginBean> thirdLogin(String thirdUid, String nickName, String userIcon) {
        Map<String, Object> params = getCommonMap("thirdLogin");
        params.put("thirdUid", thirdUid);
        params.put("nickName", nickName);
        params.put("userIcon", userIcon);
        return getApi().thirdLogin(toJson(params));
    }

    /**
     * 2.0 获取热门搜索列表
     */
    public Observable<CityIdBean> getLocationCity(String province, String city) {
        Map<String, Object> params = getCommonMap("getRecomSkeyList");
        params.put("province", province);
        params.put("city", city);
        return getApi().getLocationCityId(toJson(params));
    }

    /**
     * 2.1 获取所有城市
     */
    public Observable<CityListBean> getAllCityList() {
        Map<String, Object> params = getCommonMap("getCityList");
        return getApi().getAllCityList(toJson(params));
    }

    /**
     * 2.2 获取热门搜索列表
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
     * flag 0-下单量 1-距离 2-店铺星级 3-商品好评率
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
     */
    public Observable<MyGoodsListBean> searchGoodsList(String searchKey, int nowPage) {
        Map<String, Object> params = getCommonMap("searchGoodsList");
        params.put("cityId", CoreLib.getCityId());
        params.put("lng", CoreLib.getLongitude());
        params.put("lat", CoreLib.getLatitude());
        params.put("searchKey", searchKey);
        params.put("nowPage", nowPage);
        return getApi().searchGoodsList(toJson(params));
    }

    /**
     * 2.6 通知列表
     */
    public Observable<SystemMessageListBean> getSystemMsgList(int nowPage) {
        Map<String, Object> params = getCommonMap("getSystemMsgList");
        params.put("nowPage", nowPage);
        return getApi().getSystemMsgList(toJson(params));
    }

    /**
     * 2.7 删除通知
     *
     * @param messageIds 通知id，删除多条，逗号分隔，例如1,2,3
     */
    public Observable<BaseBean> delSystemMsgList(String messageIds) {
        Map<String, Object> params = getCommonMap("deleteSystemMsg");
        params.put("messageIds", messageIds);
        return getApi().method(toJson(params));
    }

    /**
     * 2.8 通知消息提醒状态
     */
    public Observable<UnReadMessageCountBean> getMessageUnReadCount() {
        Map<String, Object> params = getCommonMap("getMsgState");
        return getApi().getMessageUnReadCount(toJson(params));
    }

    /**
     * 2.9 点击未读消息-状态修改
     *
     * @param messageId 消息ID（仅处理未读消息）
     */
    public Observable<BaseBean> setMessageRead(String messageId) {
        Map<String, Object> params = getCommonMap("upMsgState");
        params.put("messageId", messageId);
        params.put("state", "1");
        return getApi().method(toJson(params));
    }

    /**
     * 2.10 申诉列表
     *
     * @param state   0-待处理 1-已处理
     * @param nowPage 当前页面
     */
    public Observable<AppealListBean> getAppealMsgList(String state, int nowPage) {
        Map<String, Object> params = getCommonMap("getAppealMsgList");
        params.put("state", state);
        params.put("nowPage", nowPage);
        return getApi().getAppealMsgList(toJson(params));
    }

    /**
     * 2.11 申诉详情
     *
     * @param appealId 申诉id
     */
    public Observable<AppealDetailBean> getAppealMsgDetail(String appealId) {
        Map<String, Object> params = getCommonMap("getAppealMsgDetail");
        params.put("appealId", appealId);
        return getApi().getAppealMsgDetail(toJson(params));
    }

    /**
     * 2.12 意见反馈
     *
     * @param fdTitle   反馈主题
     * @param fdContent 反馈内容
     */
    public Observable<BaseBean> feedBack(String fdTitle, String fdContent) {
        Map<String, Object> params = getCommonMap("feedBack");
        params.put("fdTitle", fdTitle);
        params.put("fdContent", fdContent);
        return getApi().method(toJson(params));
    }

    /**
     * 2.17 附近好店 更多 店铺列表搜索
     *
     * @param shopTypeId 店铺分类id        传空默认全部
     */
    public Observable<ShopListResultBean> searchNearShopList(String shopTypeId, String key, int nowPage) {
        Map<String, Object> params = getCommonMap("getNearShopList");
        params.put("cityId", CoreLib.getCityId());
        params.put("lng", CoreLib.getLongitude());
        params.put("lat", CoreLib.getLatitude());
        params.put("shopTypeId", shopTypeId);
        params.put("searchKey", key);
        params.put("nowPage", nowPage);
        return getApi().searchNearShopList(toJson(params));
    }

    /**
     * 3.8 ---商品详情---
     *
     * @param shopId  店铺id
     * @param goodsId 商品id
     * @param flag    0-普通购物 1-团购 2-批发专场
     */
    public Observable<GoodsBean> getGoodsDetailInfo(String shopId, String goodsId, String flag) {
        Map<String, Object> params = getCommonMap("getGoodsDetail");
        params.put("shopId", shopId);
        params.put("goodsId", goodsId);
        params.put("flag", flag);
        return getApi().getGoodsDetailInfo(toJson(params));
    }

    /**
     * 6.8 我的收藏列表
     *
     * @param type    类型    0-零售商品收藏 1-店铺收藏 2-批发商品收藏 3-厂家收藏
     * @param nowPage 页码
     */
    public Observable<MyCollectListBean> getMyCollectList(int type, int nowPage) {
        Map<String, Object> params = getCommonMap("getMyCollectList");
        params.put("type", type);
        params.put("nowPage", nowPage);
        return getApi().getMyCollectList(toJson(params));
    }

    /**
     * 6.11 我的地址管理
     */
    public Observable<MyAddrListBean> getMyAddrList(int nowPage) {
        Map<String, Object> params = getCommonMap("getMyAddrList");
        params.put("nowPage", nowPage);
        return getApi().getMyAddrList(toJson(params));
    }


    /**
     * 6.12 设置默认地址
     */
    public Observable<BaseBean> setDefaultAddr(String addrId) {
        Map<String, Object> params = getCommonMap("setDefaultAddr");
        params.put("addrId", addrId);
        return getApi().setDefaultAddr(toJson(params));
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
