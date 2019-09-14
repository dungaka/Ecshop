package com.langt.zjgx.base;

public class Constant {
    public static final String BASE_URL = "https://shop.zjguangxuan.com";

    /**
     * 首页轮播图连接类型
     */
    public interface HomeBannerUrlType {
        int type_url = 0; // 0链接富文本
        int type_shop = 1;  // 1店铺
        int type_goods = 2;  // 2商品
        int type_3 = 3;  //3平台商品二级分类
        int type_4 = 4;  // 4零售团购列表
        int type_5 = 5; // 5店铺优惠券列表;
        int type_6 = 6;  // 6积分换购商品列表
        int type_7 = 7; // 7零售限时商品列表
        int type_8 = 8; // 8零售满减商品列表
    }

    /**
     * 店铺推荐商品属性
     */
    public interface ShopRecommendGoodsType {
        int type_0 = 0;  // 0普通零售
        int type_1 = 1;  // 1零售团购
        int type_2 = 2;  // 2零售满减商品
        int type_3 = 3;  // 3零售限时抢购
        int type_4 = 4;  // 4厂家直销
        int type_5 = 5;  // 5发起拼团商品
    }

    public interface SpConstant {
        /**
         * 搜索页面-搜索历史保存的关键字
         */
        String GOODS_SEARCH_KEY = "goodsSearchKey";
        String KEY_USER_ID = "key_user_id";
        String KEY_CITY_ID = "key_city_id";
        String KEY_LONGITUDE = "key_longitude";
        String KEY_LATITUDE = "key_latitude";
    }

    /**
     * 首页-推荐商品类型常量
     */
    public interface HomeGoodsListOrderType {
        /**
         * 订单量
         */
        String type_order = "type_order";
        /**
         * 距离
         */
        String type_distance = "type_distance";
        /**
         * 星级
         */
        String type_star_level = "type_star_level";
        /**
         * 好评率
         */
        String type_favorable_rate = "type_favorable_rate";
        /**
         * 搜索结果
         */
        String type_search = "type_search";
    }
}
