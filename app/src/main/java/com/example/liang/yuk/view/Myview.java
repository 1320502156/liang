package com.example.liang.yuk.view;

import com.example.liang.yuk.bean.User;

import java.util.List;

public interface Myview {

    void showChenggong(List<User.RecentBean>list);
    void showError(String error);
}
