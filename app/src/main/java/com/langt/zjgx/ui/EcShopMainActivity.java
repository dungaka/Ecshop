package com.langt.zjgx.ui;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.chaychan.library.BottomBarItem;
import com.chaychan.library.BottomBarLayout;
import com.langt.zjgx.R;
import com.langt.zjgx.base.BaseActivity;
import com.langt.zjgx.base.BasePresenter;
import com.langt.zjgx.cart.CartFragment;
import com.langt.zjgx.category.CategoryFragment;
import com.langt.zjgx.home.HomeFragment;
import com.langt.zjgx.mine.fragment.MineFragment;
import com.langt.zjgx.nearby.NearbyFragment;

import butterknife.BindView;

public class EcShopMainActivity extends BaseActivity {
    private static final String KEY_CURRENT_TAB_POSITION = "key_current_tab_position";

    @BindView(R.id.bbl)
    BottomBarLayout bottomBarLayout;


    private HomeFragment mHomeFragment;
    private CategoryFragment mCategoryFragment;
    private CartFragment mCartFragment;
    private MineFragment mMineFragment;
    private NearbyFragment mNearbyFragment;


    // 当前正在显示的Fragment
    private Fragment mCurrentFragment;
    private int mCurrentPosition;

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_eshop_main;
    }

    @Override
    public void initView() {
        retrieveFragments();

        bottomBarLayout.setOnItemSelectedListener(new BottomBarLayout.OnItemSelectedListener() {
            @Override
            public void onItemSelected(BottomBarItem bottomBarItem, int i, int i1) {
                onTabSelected(i1);
            }
        });
        bottomBarLayout.setCurrentItem(0);


    }

    public void onTabSelected(@IdRes int tabId) {
        this.mCurrentPosition = tabId;
        switch (tabId) {
            case 0:
                if (mHomeFragment == null) mHomeFragment = HomeFragment.newInstance();
                switchFragment(mHomeFragment);
                break;
            case 1:
                if (mCategoryFragment == null) mCategoryFragment = CategoryFragment.newInstance();
                switchFragment(mCategoryFragment);
                break;
            case 2:
                if (mNearbyFragment == null)
                    mNearbyFragment = NearbyFragment.newInstance();
                switchFragment(mNearbyFragment);
                break;
            case 3:
                if (mCartFragment == null) mCartFragment = CartFragment.newInstance();
                switchFragment(mCartFragment);
                break;
            case 4:
                if (mMineFragment == null) mMineFragment = MineFragment.newInstance();
                switchFragment(mMineFragment);
                break;
            default:
                throw new UnsupportedOperationException("Illegal branch!");
        }
    }

    @Override
    public void onBackPressed() {
        if (mCurrentFragment != mHomeFragment) {
            // 如果不是在HomeFragment, 则按返回键回到HomeFragment
            bottomBarLayout.setCurrentItem(0);
            return;
        }

        // 将Activity所在的Task移到后台, 而不是finish此Activity
        moveTaskToBack(true);
    }

    /**
     * 首页Fragment切换, 使用hide和show, 而不是replace.
     *
     * @param target 要显示的目标Fragment.
     */
    private void switchFragment(Fragment target) {
        if (mCurrentFragment == target) return;

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        if (mCurrentFragment != null) {
            // 隐藏当前正在显示的Fragment
            transaction.hide(mCurrentFragment);
        }

        if (target.isAdded()) {
            // 如果目标Fragment已经添加过, 就显示它
            transaction.show(target);
        } else {
            // 否则直接添加该Fragment
            transaction.add(R.id.layout_container, target, target.getClass().getName());
        }

        transaction.commit();

        mCurrentFragment = target;
    }

    // 找回FragmentManager中存储的Fragment
    private void retrieveFragments() {
        FragmentManager manager = getSupportFragmentManager();
        mHomeFragment = (HomeFragment) manager.findFragmentByTag(HomeFragment.class.getName());
        mCategoryFragment = (CategoryFragment) manager
                .findFragmentByTag(CategoryFragment.class.getName());
        mNearbyFragment = (NearbyFragment) manager.findFragmentByTag(NearbyFragment.class.getName());
        mCartFragment = (CartFragment) manager.findFragmentByTag(CartFragment.class.getName());
        mMineFragment = (MineFragment) manager.findFragmentByTag(MineFragment.class.getName());
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(KEY_CURRENT_TAB_POSITION, mCurrentPosition);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        mCurrentPosition = savedInstanceState.getInt(KEY_CURRENT_TAB_POSITION, 0);
        onTabSelected(mCurrentPosition);
    }
}
