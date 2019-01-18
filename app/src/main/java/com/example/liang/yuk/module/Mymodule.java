package com.example.liang.yuk.module;

import com.example.liang.yuk.bean.User;

import java.util.List;

public interface Mymodule {
    interface Jie{
        void showChenggong(List<User.RecentBean> list);
        void showError(String error);
    }
    void sModule(Jie jie);
}
