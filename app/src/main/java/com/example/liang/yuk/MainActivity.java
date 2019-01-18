package com.example.liang.yuk;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;

import com.bumptech.glide.Glide;
import com.example.liang.yuk.adapter.Myadapter;
import com.example.liang.yuk.bean.User;
import com.example.liang.yuk.module.MymoduleImI;
import com.example.liang.yuk.presenter.MypresenterImI;
import com.example.liang.yuk.view.Myview;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements Myview, View.OnClickListener {


    private Toolbar toobal;
    private XRecyclerView xrv;
    private ArrayList<User.RecentBean> recentBeans;
    private Myadapter myadapter;
    private ImageButton img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MypresenterImI mypresenterImI = new MypresenterImI(new MymoduleImI(), this);
        mypresenterImI.lPresenter();
        initView();
    }

    private void initView() {

        toobal = (Toolbar) findViewById(R.id.toobal);
        xrv = (XRecyclerView) findViewById(R.id.xrv);
        recentBeans = new ArrayList<>();
        myadapter = new Myadapter(this, recentBeans);
        xrv.setAdapter(myadapter);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        xrv.setLayoutManager(manager);


        img = (ImageButton) findViewById(R.id.img);
        img.setOnClickListener(this);
        Intent intent = getIntent();
        String url = intent.getStringExtra("url");
        Glide.with(MainActivity.this).load(url).into(img);
    }


    @Override
    public void showChenggong(List<User.RecentBean> list) {
        recentBeans.addAll(list);
        myadapter.notifyDataSetChanged();


    }

    @Override
    public void showError(String error) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.img:
                Intent intent = new Intent(MainActivity.this,Main2Activity.class);
                startActivity(intent);
                break;
        }
    }
}
