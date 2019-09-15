package com.langt.zjgx.server;

import com.langt.zjgx.base.BaseBean;
import com.langt.zjgx.goods.bean.MyGoodsListBean;
import com.langt.zjgx.location.bean.CityIdBean;
import com.langt.zjgx.login.model.UserLoginBean;
import com.langt.zjgx.message.bean.AppealListBean;
import com.langt.zjgx.mine.model.MyAddrListBean;
import com.langt.zjgx.mine.model.MyCollectListBean;
import com.langt.zjgx.model.CityListBean;
import com.langt.zjgx.model.HomePageBean;
import com.langt.zjgx.model.HomeRecommendGoodsBean;
import com.langt.zjgx.model.ShopListResultBean;
import com.langt.zjgx.search.model.HotSearchListResultModel;

import io.reactivex.Observable;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiServer {

    /**
     * 0.0 通用
     */
    @POST("service")
    Observable<BaseBean> method(@Query("json") String json);


    /**
     * 1.0 发送验证码
     */
    @POST("service")
    Observable<BaseBean> sendSmsCode(@Query("json") String json);

    /**
     * 1.1 用户注册
     */
    @POST("service")
    Observable<BaseBean> userRegister(@Query("json") String json);

    /**
     * 1.2 服务器登录
     */
    @POST("service")
    Observable<UserLoginBean> userLogin(@Query("json") String json);

    /**
     * 1.3忘记密码
     */
    @POST("service")
    Observable<BaseBean> forgetPassword(@Query("json") String json);

    /**
     * 1.4 第三方登录
     */
    @POST("service")
    Observable<UserLoginBean> thirdLogin(@Query("json") String json);

    /**
     * 2.0 定位获取城市对应的cityId
     */
    @POST("service")
    Observable<CityIdBean> getLocationCityId(@Query("json") String json);

    /**
     * 2.1 获取所有城市
     */
    @POST("service")
    Observable<CityListBean> getAllCityList(@Query("json") String json);

    /**
     * 2.2 首頁主界面
     */
    @POST("service")
    Observable<HomePageBean> getHomePageInfo(@Query("json") String json);

    /**
     * 2.3 推荐商品
     */
    @POST("service")
    Observable<HomeRecommendGoodsBean> getHomeRecommendGoodsList(@Query("json") String json);

    /**
     * 2.4 搜索商品-推荐搜索词
     */
    @POST("service")
    Observable<HotSearchListResultModel> getHotSearchList(@Query("json") String json);

    /**
     * 2.5 搜索商品
     */
    @POST("service")
    Observable<MyGoodsListBean> searchGoodsList(@Query("json") String json);

    /**
     * 2.6通知列表
     */
    @POST("service")
    Observable<BaseBean> getSystemMsgList(@Query("json") String json);

    /**
     * 2.10 申诉列表
     */
    @POST("service")
    Observable<AppealListBean> getAppealMsgList(@Query("json") String json);

    /**
     * 2.11 申诉详情
     */
    @POST("service")
    Observable<UserLoginBean> getAppealMsgDetail(@Query("json") String json);

    /**
     * 2.12 意见反馈
     */
    @POST("service")
    Observable<BaseBean> feedBack(@Query("json") String json);

    /**
     * 2.17 附近好店 更多 店铺列表搜索
     */
    @POST("service")
    Observable<ShopListResultBean> searchNearShopList(@Query("json") String json);

    /**
     * 2.31 厂家直销商品列表
     */
    @POST("service")
    Observable<UserLoginBean> getDirectDealGoods(@Query("json") String json);

    /**
     * 3.0 获取所有的店铺分类
     */
    @POST("service")
    Observable<UserLoginBean> getShopTypeList(@Query("json") String json);

    /**
     * 3.2 店铺列表
     */
    @POST("service")
    Observable<UserLoginBean> getShopList(@Query("json") String json);

    /**
     * 3.3店铺详情
     */
    @POST("service")
    Observable<UserLoginBean> getShopDetail(@Query("json") String json);

    /**
     * 3.4 店铺折扣券
     */
    @POST("service")
    Observable<UserLoginBean> getDisctCouponList(@Query("json") String json);

    /**
     * 3.5 领取折扣券
     */
    @POST("service")
    Observable<UserLoginBean> takeDisctCoupon(@Query("json") String json);

    /**
     * 3.6 商品列表
     */
    @POST("service")
    Observable<UserLoginBean> getGoodsList(@Query("json") String json);

    /**
     * 3.7 零售店铺内商品的搜索
     */
    @POST("service")
    Observable<UserLoginBean> searchGoodsList2(@Query("json") String json);

    /**
     * 3.8 商品详情
     */
    @POST("service")
    Observable<UserLoginBean> getGoodsDetail(@Query("json") String json);

    /*
     * 申诉类型
     * */
    @POST("service")
    Observable<UserLoginBean> getAppealTypeList(@Query("json") String json);

    /**
     * 3.9 申诉类型列表
     */
    @POST("service")
    Observable<UserLoginBean> submitAppealMsg(@Query("json") String json);

    /**
     * 3.11 收藏/取消
     */
    @POST("service")
    Observable<UserLoginBean> collect(@Query("json") String json);

    /**
     * 3.12 商品评价列表
     */
    @POST("service")
    Observable<UserLoginBean> getGoodsCmtList(@Query("json") String json);

    /**
     * 5.0 购物车（进货单）列表
     */
    @POST("service")
    Observable<UserLoginBean> getShopCartList(@Query("json") String json);

    /**
     * 5.1 为你推荐/猜你喜欢
     */
    @POST("service")
    Observable<UserLoginBean> getFavoGoodsList(@Query("json") String json);


    /**
     * 6.8 我的收藏列表
     */
    @POST("ZJservice")
    Observable<MyCollectListBean> getMyCollectList(@Query("json") String json);

    /**
     * 6.11 我的地址管理
     */
    @POST("ZJservice")
    Observable<MyAddrListBean> getMyAddrList(@Query("json") String json);

    /**
     * 6.12 设置默认地址
     */
    @POST("ZJservice")
    Observable<BaseBean> setDefaultAddr(@Query("json") String json);


}
