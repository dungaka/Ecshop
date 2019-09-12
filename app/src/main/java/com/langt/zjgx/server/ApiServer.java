package com.langt.zjgx.server;

import com.langt.zjgx.base.BaseBean;
import com.langt.zjgx.login.model.UserLoginBean;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiServer {


    @POST("service")
    Observable<BaseBean> method(@Query("json") String json);

    @POST("service")
    Observable<UserLoginBean> userLogin(@Query("json") String json);

}
