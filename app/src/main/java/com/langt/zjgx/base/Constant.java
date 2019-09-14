package com.langt.zjgx.base;

public class Constant {
    public static  final String  BASE_URL = "https://shop.zjguangxuan.com";

    public interface SpConstant{
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
    public interface HomeGoodsListOrderType{
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
