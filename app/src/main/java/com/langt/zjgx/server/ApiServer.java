package com.langt.zjgx.server;

import com.langt.zjgx.base.BaseBean;
import com.langt.zjgx.goods.bean.MyGoodsListBean;
import com.langt.zjgx.login.model.UserLoginBean;
import com.langt.zjgx.mine.model.MyAddrListBean;
import com.langt.zjgx.mine.model.MyCollectListBean;
import com.langt.zjgx.search.model.HotSearchListResultModel;

import io.reactivex.Observable;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiServer {


    @POST("service")
    Observable<BaseBean> method(@Query("json") String json);


    /*
     * 发送验证码
     * */
    @POST("service")
    Observable<BaseBean> sendSmsCode(@Query("json") String json);

    /*
     * 用户注册
     * */
    @POST("service")
    Observable<BaseBean> userRegister(@Query("json") String json);

    /*
     * 服务器登录
     * */
    @POST("service")
    Observable<UserLoginBean> userLogin(@Query("json") String json);

    /*
     * 忘记密码
     * */
    @POST("service")
    Observable<BaseBean> forgetPassword(@Query("json") String json);

    /*
     * 第三方登录
     * */
    @POST("service")
    Observable<UserLoginBean> thirdLogin(@Query("json") String json);

    /*
     * 首页
     * */
    @POST("service")
    Observable<UserLoginBean> getMainInfo(@Query("json") String json);

    /*
     * 推荐商品
     * */
    @POST("service")
    Observable<UserLoginBean> getRecomGoodsList(@Query("json") String json);

    /*
     * 搜索商品
     * */
    @POST("service")
    Observable<MyGoodsListBean> searchGoodsList(@Query("json") String json);

    /*
     * 通知列表
     * */
    @POST("service")
    Observable<UserLoginBean> getSystemMsgList(@Query("json") String json);

    /*
     * 申诉列表
     * */
    @POST("service")
    Observable<UserLoginBean> getAppealMsgList(@Query("json") String json);

    /*
     * 申诉详情
     * */
    @POST("service")
    Observable<UserLoginBean> getAppealMsgDetail(@Query("json") String json);

    /*
     * 意见反馈
     * */
    @POST("service")
    Observable<BaseBean> feedBack(@Query("json") String json);

    /*
     * 附近好店 更多 店铺列表搜索
     * */
    @POST("service")
    Observable<UserLoginBean> getNearShopList(@Query("json") String json);

    /*
     * 厂家直销商品列表
     * */
    @POST("service")
    Observable<UserLoginBean> getDirectDealGoods(@Query("json") String json);

    /*
     * 获取所有的店铺分类
     * */
    @POST("service")
    Observable<UserLoginBean> getShopTypeList(@Query("json") String json);

    /*
     * 店铺列表
     * */
    @POST("service")
    Observable<UserLoginBean> getShopList(@Query("json") String json);

    /*
     * 店铺详情
     * */
    @POST("service")
    Observable<UserLoginBean> getShopDetail(@Query("json") String json);

    /*
     * 店铺折扣券
     * */
    @POST("service")
    Observable<UserLoginBean> getDisctCouponList(@Query("json") String json);

    /*
     * 领取折扣券
     * */
    @POST("service")
    Observable<UserLoginBean> takeDisctCoupon(@Query("json") String json);

    /*
     * 商品列表
     * */
    @POST("service")
    Observable<UserLoginBean> getGoodsList(@Query("json") String json);

    /*
     * 零售店铺内商品的搜索
     * */
    @POST("service")
    Observable<UserLoginBean> searchGoodsList2(@Query("json") String json);

    /*
     * 商品详情
     * */
    @POST("service")
    Observable<UserLoginBean> getGoodsDetail(@Query("json") String json);

    /*
     * 申诉类型
     * */
    @POST("service")
    Observable<UserLoginBean> getAppealTypeList(@Query("json") String json);

    /*
     * 提交申诉
     * */
    @POST("service")
    Observable<UserLoginBean> submitAppealMsg(@Query("json") String json);

    /*
     * 收藏
     * */
    @POST("service")
    Observable<UserLoginBean> collect(@Query("json") String json);

    /*
     * 商品评价列表
     * */
    @POST("service")
    Observable<UserLoginBean> getGoodsCmtList(@Query("json") String json);

    /*
     * 购物车列表
     * */
    @POST("service")
    Observable<UserLoginBean> getShopCartList(@Query("json") String json);

    /*
     * 为你推荐/猜你喜欢
     * */
    @POST("service")
    Observable<UserLoginBean> getFavoGoodsList(@Query("json") String json);


    @POST("ZJservice")
    Observable<BaseBean> setDefaultAddr(@Query("json") String json);

    @POST("ZJservice")
    Observable<MyAddrListBean> getMyAddrList(@Query("json") String json);

    @POST("ZJservice")
    Observable<MyCollectListBean> getMyCollectList(@Query("json") String json);

    @POST("service")
    Observable<HotSearchListResultModel> getHotSearchList(@Query("json") String json);


}
