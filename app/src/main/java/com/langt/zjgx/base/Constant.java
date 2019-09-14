package com.langt.zjgx.base;

public class Constant {
    public static  final String  BASE_URL = "https://shop.zjguangxuan.com";

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
    }
}
