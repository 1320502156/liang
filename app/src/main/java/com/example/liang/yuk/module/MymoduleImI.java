package com.example.liang.yuk.module;

import android.util.Log;

import com.example.liang.yuk.bean.User;
import com.example.liang.yuk.http.Myserver;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MymoduleImI implements Mymodule {
    @Override
    public void sModule(final Jie jie) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Myserver.URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        Myserver myserver = retrofit.create(Myserver.class);
        Observable<User> data = myserver.getData("hot");
        data.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<User>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(User value) {
                        List<User.RecentBean> recent = value.getRecent();
                        jie.showChenggong(recent);

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("111",e.getMessage());

                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }
}
