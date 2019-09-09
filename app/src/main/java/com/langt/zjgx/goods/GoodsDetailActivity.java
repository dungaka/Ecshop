package com.langt.zjgx.goods;

import android.graphics.Paint;
import android.text.Html;
import android.view.View;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.langt.zjgx.R;
import com.langt.zjgx.adapter.MyCommonNavigatorAdapter;
import com.langt.zjgx.base.BaseActivity;
import com.langt.zjgx.base.BasePresenter;
import com.langt.zjgx.home.HomeFragment;
import com.langt.zjgx.home.model.Banner;
import com.langt.zjgx.utils.ImageUtils;
import com.langt.zjgx.utils.StringUtils;
import com.langt.zjgx.widget.banner.BannerAdapter;
import com.langt.zjgx.widget.banner.BannerLayout;

import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 商品详情页面
 */
public class GoodsDetailActivity extends BaseActivity implements MyCommonNavigatorAdapter.OnTabItemClickListener{

    @BindView(R.id.iv_back)
    View iv_back;
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

    private BannerAdapter<Banner> mBannerAdapter;

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_goods_detail;
    }

    @Override
    public void initView() {
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
        tv_goods_original_price.setText(getString(R.string.goods_price,"125.00"));
        tv_goods_original_price.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);

        tv_goods_name.setText(Html.fromHtml("<img src='" + R.drawable.ic_goods_type_qianggou + "'/>"+"  生活不止眼前的苟且，还有诗和远方的苟且 还有诗和远方的苟且还有诗和远方的苟且",
                ImageUtils.getGoodTypeImageGetterInstance(this),
                null));
    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void onTabItemClick(int position, View view) {
        magicIndicator.onPageSelected(position);
        magicIndicator.onPageScrolled(position, 0, 0);
    }

    @OnClick({R.id.iv_back,R.id.iv_complain_goods})
    public void onClick(View view){
        switch (view.getId()) {
            case R.id.iv_back:
                onBackPressed();
                break;
            case R.id.iv_complain_goods:
                // TODO: 2019/9/9 申诉
                break;
            case R.id.tv_collect:
                break;
            case R.id.tv_share:

                break;
        }
    }
}
