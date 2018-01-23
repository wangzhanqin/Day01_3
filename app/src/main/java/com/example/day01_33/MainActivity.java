package com.example.day01_33;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * 1.导包
 *      百度，比较新的包
 * 2.配置权限
 * 3.使用
 */
public class MainActivity extends AppCompatActivity {

    private String url = "http://pic29.photophoto.cn/20131204/0034034499213463_b.jpg";
    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button but= (Button) findViewById(R.id.main_bt);

        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //使用okhttp请求
                //创建client
                OkHttpClient client = new OkHttpClient();
                //创建请求 request请求
                Request build = new Request.Builder().url(url).build();
                //创建请求队列
                Call call = client.newCall(build);
                //执行
                call.enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {
                        Log.d(TAG, "失败--- ");
                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        Log.d(TAG, "成功---");
                    }
                });
            }
        });

    }
}
