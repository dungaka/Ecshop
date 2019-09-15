package com.langt.zjgx.mine.activity;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.widget.EditText;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.langt.zjgx.R;
import com.langt.zjgx.base.BaseActivity;
import com.langt.zjgx.base.BaseBean;
import com.langt.zjgx.base.BasePresenter;
import com.langt.zjgx.base.GlobalFun;
import com.langt.zjgx.comm.Constants;
import com.langt.zjgx.event.ModifyUserInfoEvent;
import com.langt.zjgx.server.HttpClient;
import com.langt.zjgx.utils.OptionsUtils;
import com.langt.zjgx.utils.SPStaticUtils;
import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.entity.LocalMedia;

import org.greenrobot.eventbus.EventBus;

import java.io.File;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class ModifyAvatarActivity extends BaseActivity {

    @BindView(R.id.iv_avatar)
    ImageView ivMyPicture;
    @BindView(R.id.et_nickname)
    EditText etName;

    String userName ;
    String avatar ;
    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.act_modify_avatar;
    }

    @Override
    public void initView() {

        avatar = SPStaticUtils.getString(Constants.USER_ICON);
        userName = SPStaticUtils.getString(Constants.NICK_NAME);
        etName.setText(userName);
        Glide.with(this).load(avatar).apply(OptionsUtils.circleCrop()).into(ivMyPicture);

    }

    @OnClick(R.id.iv_avatar)
    void selectPic(){
        PictureSelector.create(this)
                .openGallery(PictureMimeType.ofImage())//全部.PictureMimeType.ofAll()、图片.ofImage()、视频.ofVideo()、音频.ofAudio()
                .maxSelectNum(1)// 最大图片选择数量 int
                .minSelectNum(1)// 最小选择数量 int
                .imageSpanCount(3)// 每行显示个数 int
                .selectionMode(PictureConfig.SINGLE)// 多选 or 单选 PictureConfig.MULTIPLE or PictureConfig.SINGLE
                .previewImage(true)// 是否可预览图片 true or false
                .isCamera(true)// 是否显示拍照按钮 true or false
                .imageFormat(PictureMimeType.PNG)// 拍照保存图片格式后缀,默认jpeg
                .sizeMultiplier(0.5f)// glide 加载图片大小 0~1之间 如设置 .glideOverride()无效
                .setOutputCameraPath("/CustomPath")// 自定义拍照保存路径,可不填
                .enableCrop(true)// 是否裁剪 true or false
                .compress(true)// 是否压缩 true or false
                .withAspectRatio(1, 1)// int 裁剪比例 如16:9 3:2 3:4 1:1 可自定义
                .freeStyleCropEnabled(false)// 裁剪框是否可拖拽 true or false
                .circleDimmedLayer(true)// 是否圆形裁剪 true or false
                .showCropFrame(false)// 是否显示裁剪矩形边框 圆形裁剪时建议设为false   true or false
                .showCropGrid(false)// 是否显示裁剪矩形网格 圆形裁剪时建议设为false    true or false
                .minimumCompressSize(100)// 小于100kb的图片不压缩
                .synOrAsy(true)//同步true或异步false 压缩 默认同步
                .cropWH(500, 500)// 裁剪宽高比，设置如果大于图片本身宽高则无效 int
                .forResult(PictureConfig.CHOOSE_REQUEST);//结果回调onActivityResult code
    }


    @OnClick(R.id.btn_confirm)
    void confirm(){

        modifyUserInfo();
    }

    File file = null;
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // 图片、视频、音频选择结果回调
        List<LocalMedia> selectList = PictureSelector.obtainMultipleResult(data);
        if (selectList.get(0).isCompressed()) {
            Glide.with(this).load(selectList.get(0).getCompressPath()).apply(OptionsUtils.circleCrop()).into(ivMyPicture);

            file = new File(selectList.get(0).getCompressPath());
        }
    }


    private void modifyUserInfo(){
        String nickname = etName.getText().toString().trim();
        HttpClient client = new HttpClient();
        client.modifyUserInfo(GlobalFun.getUserId(),file,nickname,"","")
                .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(new Observer<BaseBean>() {
            @Override
            public void onSubscribe(Disposable d) {
//                presenter.addDisposable(d);
            }

            @Override
            public void onNext(BaseBean bean) {
                showError(bean.getResultNote());
            }

            @Override
            public void onError(Throwable e) {
                showError(e.getMessage());
            }

            @Override
            public void onComplete() {
                EventBus.getDefault().post(new ModifyUserInfoEvent());
                finish();
            }
        });
    }
}
