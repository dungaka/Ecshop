package com.langt.zjgx.goods;

import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.v4.widget.NestedScrollView;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.langt.zjgx.R;
import com.langt.zjgx.adapter.MyCommonNavigatorAdapter;
import com.langt.zjgx.base.BaseActivity;
import com.langt.zjgx.base.Constant;
import com.langt.zjgx.goods.presenter.GoodsDetailPresenter;
import com.langt.zjgx.goods.view.IGoodsDetailView;
import com.langt.zjgx.model.Banner;
import com.langt.zjgx.model.GoodsBean;
import com.langt.zjgx.order.ConfirmOrderActivity;
import com.langt.zjgx.shop.ShopDetailActivity;
import com.langt.zjgx.utils.ActivityUtils;
import com.langt.zjgx.utils.LogUtils;
import com.langt.zjgx.utils.StringUtils;
import com.langt.zjgx.widget.SnapUpCountDownTimerView;
import com.langt.zjgx.widget.banner.BannerAdapter;
import com.langt.zjgx.widget.banner.BannerLayout;
import com.langt.zjgx.widget.popup.GoodsDetailChooseToBuyPopupWindow;
import com.langt.zjgx.widget.viewpagerrecyclerview.GoodsRecommendListView;

import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 商品详情页面
 */
public class GoodsDetailActivity extends BaseActivity<GoodsDetailPresenter>
        implements MyCommonNavigatorAdapter.OnTabItemClickListener, NestedScrollView.OnScrollChangeListener,
        IGoodsDetailView {
    private static final String KEY_GOODS_ID = "key_goods_id";
    private static final String KEY_SHOP_ID = "key_shop_id";

    public static void startActivity(Context context, String shopId, String goodsId) {
        Intent intent = new Intent(context, GoodsDetailActivity.class);
        intent.putExtra(KEY_SHOP_ID, shopId);
        intent.putExtra(KEY_GOODS_ID, goodsId);
        ActivityUtils.startActivity(intent, context);
    }

    @BindView(R.id.scrollView)
    NestedScrollView scrollView;
    @BindView(R.id.magic_indicator)
    MagicIndicator magicIndicator;
    @BindView(R.id.layout_goods_banner)
    BannerLayout bannerLayout;
    @BindView(R.id.tv_goods_price)
    TextView tv_goods_price;
    @BindView(R.id.tv_goods_unit)
    TextView tv_goods_unit;
    @BindView(R.id.tv_goods_original_price)
    TextView tv_goods_original_price;
    @BindView(R.id.tv_goods_name)
    TextView tv_goods_name;
    @BindView(R.id.view_my_shop_recommend)
    GoodsRecommendListView view_my_shop_recommend;
    @BindView(R.id.view_goods_nearly_recommend)
    GoodsRecommendListView view_goods_nearly_recommend;
    // 评价部分
    @BindView(R.id.tv_comment_title)
    TextView tv_comment_title;
    // 商品详情
    @BindView(R.id.tv_goods_detail_title)
    TextView tv_goods_detail_title;

    // 拼团开始
    @BindView(R.id.tv_tuanpin_limit_purchase_count)
    TextView tv_tuanpin_limit_purchase_count;
    @BindView(R.id.tv_tuanpin_finish_rate)
    TextView tv_tuanpin_finish_rate;
    @BindView(R.id.tv_tuanpin_anim)
    TextView tv_tuanpin_anim;
    @BindView(R.id.timerView)
    SnapUpCountDownTimerView timerView;

    private BannerAdapter<Banner> mBannerAdapter;

    private String goodsId, shopId;

    @Override
    protected GoodsDetailPresenter createPresenter() {
        return new GoodsDetailPresenter(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_goods_detail;
    }

    @Override
    public void initView() {
        scrollView.setOnScrollChangeListener(this);
        // 顶部切换的tab
        String[] mTabs = new String[]{getString(R.string.goods_title_info), getString(R.string.goods_title_comments),
                getString(R.string.goods_title_recommend), getString(R.string.goods_title_details)};
        CommonNavigator commonNavigator = new CommonNavigator(this);
        MyCommonNavigatorAdapter myCommonNavigatorAdapter = new MyCommonNavigatorAdapter(mTabs);
        commonNavigator.setAdapter(myCommonNavigatorAdapter);
        commonNavigator.setAdjustMode(true);
        magicIndicator.setNavigator(commonNavigator);
        myCommonNavigatorAdapter.setOnTabItemClickListener(this);

        // 商品图片轮播图
        mBannerAdapter = new BannerAdapter<Banner>() {
            @Override
            protected void bind(BannerAdapter.ViewHolder holder, Banner data) {
                Glide.with(GoodsDetailActivity.this)
                        .load("https://img.zcool.cn/community/01acaf5722af116ac7253812b32635.jpg@1280w_1l_2o_100sh.jpg")
                        .into(holder.ivBannerItem);
            }
        };
        bannerLayout.setBannerAdapter(mBannerAdapter);
        // 图片地址测试
        ArrayList<Banner> bannerList = new ArrayList<>();
        bannerList.add(new Banner());
        bannerList.add(new Banner());
        bannerList.add(new Banner());
        bannerList.add(new Banner());
        mBannerAdapter.reset(bannerList);

        // 商品价格,规格信息
        tv_goods_original_price.setText(getString(R.string.goods_price, "125.00"));
        tv_goods_original_price.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
        StringUtils.setGoodsNameWithImage(tv_goods_name, this,
                R.drawable.ic_goods_type_qianggou, "  生活不止眼前的苟且，还有诗和远方的苟且 还有诗和远方的苟且还有诗和远方的苟且");
        // 商品推荐信息展示
        List<GoodsBean> list = new ArrayList<>();
        for (int i = 0; i < 13; i++) {
            list.add(new GoodsBean(""));
        }
        view_my_shop_recommend.setItemList(null);
        view_goods_nearly_recommend.setItemList(list);

        initTuanPinView();
    }

    private void initTuanPinView() {
        tv_tuanpin_limit_purchase_count.setText("10件");
        tv_tuanpin_finish_rate.setText("80%");
        tv_tuanpin_anim.setText("100件");
        timerView.start(4 * 24 * 60 * 60 * 1000 + 4 * 60 * 60 * 1000 + 35 * 60 * 1000);
    }

    @Override
    public void initData() {
        super.initData();
        Intent fromIntent = getIntent();
        if (fromIntent != null) {
            goodsId = getIntent().getStringExtra(KEY_GOODS_ID);
            shopId = getIntent().getStringExtra(KEY_SHOP_ID);
        }
        if (TextUtils.isEmpty(goodsId) || TextUtils.isEmpty(shopId)) {
            showError("参数错误");
            finish();
        }
        presenter.test();
        presenter.getGoodsDetailInfo(shopId, goodsId, String.valueOf(Constant.ShopRecommendGoodsType.type_0));
    }

    @Override
    public void onTabItemClick(int position, View view) {
        magicIndicator.onPageSelected(position);
        magicIndicator.onPageScrolled(position, 0, 0);

        // scrollView滚动到指定位置
        switch (position) {
            case 0:
                scrollView.fullScroll(ScrollView.FOCUS_UP);
                break;
            case 1:
                scrollView.post(() -> {
                    scrollView.smoothScrollTo(0, tv_comment_title.getTop());
                    scrollView.smoothScrollTo(0, tv_comment_title.getTop());
                });
                break;
            case 2:
                scrollView.post(() -> scrollView.smoothScrollTo(0, view_my_shop_recommend.getTop()));
                break;
            case 3:
                scrollView.post(() -> scrollView.smoothScrollTo(0, tv_goods_detail_title.getTop()));
                break;
        }

    }

    @OnClick({R.id.iv_complain_goods, R.id.tv_collect,
            R.id.tv_share, R.id.tv_show_more_comments, R.id.layout_shop,
            R.id.tv_shop_service, R.id.tv_shop_info, R.id.ll_faqi_pintuan_buy_alone,
            R.id.ll_faqi_pintuan_buy_i_kaituan})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_complain_goods:
                startActivity(new Intent(this, GoodsAppealActivity.class));
                break;
            case R.id.tv_collect:
                break;
            case R.id.tv_share:

                break;
            case R.id.tv_show_more_comments:
                break;
            case R.id.layout_shop:
                startActivity(new Intent(this, ShopDetailActivity.class));
                break;
            case R.id.tv_shop_service: // 客服

                break;
            case R.id.tv_shop_info: // 店铺信息
                startActivity(new Intent(this, ShopDetailActivity.class));
                break;
            case R.id.ll_faqi_pintuan_buy_alone:  // 发起团品-单独购买
                // 显示选择商品规格的弹窗
                showChooseGoodsInfoPopup(findViewById(R.id.ll_faqi_pintuan_buy_alone));
                break;
            case R.id.ll_faqi_pintuan_buy_i_kaituan:  // 发起团品-我要开团
                // 显示选择商品规格的弹窗
                showChooseGoodsInfoPopup(findViewById(R.id.ll_faqi_pintuan_buy_i_kaituan));
                break;
        }
    }

    /**
     * 显示选择商品规格信息弹窗
     */
    private void showChooseGoodsInfoPopup(View view) {
        GoodsDetailChooseToBuyPopupWindow popupWindow = new GoodsDetailChooseToBuyPopupWindow(this);
        popupWindow.setOnConfirmClickListener(new GoodsDetailChooseToBuyPopupWindow.OnConfirmClickListener() {
            @Override
            public void onConfirmClick() {
                startActivity(new Intent(GoodsDetailActivity.this, ConfirmOrderActivity.class));
            }
        });
        popupWindow.showAtLocation(view, Gravity.BOTTOM, 0, 0);
    }

    @Override
    public void onScrollChange(NestedScrollView v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
        //Log.e(TAG, "onScrollChange: " + scrollX +"---" + scrollY + "----" +oldScrollX + "---" + oldScrollY );
        //监听滚动状态

        if (scrollY > oldScrollY) {//向下滚动
            LogUtils.i("Scroll DOWN");
        }
        if (scrollY < oldScrollY) {//向上滚动
            LogUtils.i("Scroll UP");
        }

        if (scrollY == 0) {// 滚动到顶
            LogUtils.i("TOP SCROLL");
        }
        // 滚动到底
        if (scrollY == (v.getChildAt(0).getMeasuredHeight() - v.getMeasuredHeight())) {
            LogUtils.i("BOTTOM SCROLL");
        }

        //判断某个控件是否可见
        Rect scrollBounds = new Rect();
        scrollView.getHitRect(scrollBounds);
        if (bannerLayout.getLocalVisibleRect(scrollBounds)) {//可见
            // 轮播图可见

        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (timerView != null) {
            timerView.stop();
        }
    }
}
