package com.example.liang.yuk.http;

import com.example.liang.yuk.bean.HeaderBean;
import com.example.liang.yuk.bean.User;

import io.reactivex.Observable;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Url;

public interface Myserver {

    //http://news-at.zhihu.com/api/4/news/hot
    String URL="http://news-at.zhihu.com/api/4/news/";
    @GET
    Observable<User>getData(@Url String url);

    //http://yun918.cn/study/public/file_upload.php

    String URL1="http://yun918.cn/study/public/";
    @POST("file_upload.php")
    Call<HeaderBean> uploadFileMore(@Body RequestBody requestBody);
}
