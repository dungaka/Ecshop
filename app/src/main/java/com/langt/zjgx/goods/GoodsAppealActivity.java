package com.langt.zjgx.goods;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.langt.zjgx.R;
import com.langt.zjgx.base.BaseActivity;
import com.langt.zjgx.base.BasePresenter;

import org.raphets.roundimageview.RoundImageView;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 商品申诉页面
 */
public class GoodsAppealActivity extends BaseActivity {
    @BindView(R.id.tv_shop_name)
    TextView tv_shop_name;
    @BindView(R.id.iv_shop_image)
    RoundImageView iv_shop_image;
    @BindView(R.id.tv_goods_name)
    TextView tv_goods_name;
    @BindView(R.id.tv_goods_price)
    TextView tv_goods_price;
    @BindView(R.id.spinner)
    Spinner spinner;
    @BindView(R.id.et_appeal_theme)
    EditText et_appeal_theme;
    @BindView(R.id.et_appeal_content)
    EditText et_appeal_content;


    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_goods_appeal;
    }

    @Override
    public void initView() {
        final String[] arr={"商品虚假","其他商品问题"};
        //创建ArrayAdapter对象
        ArrayAdapter<String> adapter= new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, arr);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                spinner.setSelection(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    @OnClick({R.id.btn_summit})
    public void onClick(View view){
        switch (view.getId()) {
            case R.id.btn_summit:

                break;
        }
    }
}
