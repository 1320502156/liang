package com.example.liang.yuk;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.liang.yuk.bean.HeaderBean;
import com.example.liang.yuk.http.Myserver;

import java.io.File;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener {

    private ImageView aimg;
    private Button bt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initView();
    }

    private void initView() {

        aimg = (ImageView) findViewById(R.id.aimg);
        bt = (Button) findViewById(R.id.bt);
        bt.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt:
                Retrofit retrofit5 = new Retrofit.Builder()
                        .baseUrl(Myserver.URL1)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                Myserver myServer5 = retrofit5.create(Myserver.class);
                File file = new File("/sdcard/g.png");
                if (file.exists()) {
                    RequestBody requestBody3 = new MultipartBody.Builder().setType(MultipartBody.FORM)
                            .addFormDataPart("key", "sadgaesrhtrfggf")
                            .addFormDataPart("file", file.getName(), RequestBody.create(MediaType.parse("image/png"), file)).build();

                    retrofit2.Call<HeaderBean> call = myServer5.uploadFileMore(requestBody3);
                    call.enqueue(new retrofit2.Callback<HeaderBean>() {
                        @Override
                        public void onResponse(retrofit2.Call<HeaderBean> call, retrofit2.Response<HeaderBean> response) {
                            Toast.makeText(getBaseContext(), "上传成功", Toast.LENGTH_LONG).show();
                            String url = response.body().getData().getUrl();
                            Glide.with(Main2Activity.this).load(url).into(aimg);
                            Intent intent = new Intent(Main2Activity.this, MainActivity.class);
                            intent.putExtra("url",url);
                            startActivity(intent);
                        }
                        @Override
                        public void onFailure(retrofit2.Call<HeaderBean> call, Throwable t) {
                            Log.e("222", t.getMessage());
                        }
                    });
                    break;
                }
        }
    }
}
