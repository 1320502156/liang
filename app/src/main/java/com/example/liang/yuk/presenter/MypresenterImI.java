package com.example.liang.yuk.presenter;

import com.example.liang.yuk.bean.User;
import com.example.liang.yuk.module.Mymodule;
import com.example.liang.yuk.view.Myview;

import java.util.List;

public class MypresenterImI implements Mypresenter, Mymodule.Jie {
    private Mymodule mymodule;
    private Myview myview;

    public MypresenterImI(Mymodule mymodule, Myview myview) {
        this.mymodule = mymodule;
        this.myview = myview;
    }

    @Override
    public void lPresenter() {
        if (myview!=null){
            mymodule.sModule(this);
        }
    }

    @Override
    public void showChenggong(List<User.RecentBean> list) {
        if (myview!=null){
            myview.showChenggong(list);
        }
    }

    @Override
    public void showError(String error) {

        if (myview!=null){
            myview.showError(error);
        }
    }
}
