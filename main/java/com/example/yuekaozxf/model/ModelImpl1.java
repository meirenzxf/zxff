package com.example.yuekaozxf.model;

import android.os.Handler;
import android.os.Message;

import com.example.yuekaozxf.bean.MyData;
import com.example.yuekaozxf.callback.MyCallBack;
import com.example.yuekaozxf.httpp.OkHttps;
import com.example.yuekaozxf.httpp.OkHttps1;
import com.google.gson.Gson;

import java.io.IOException;

public class ModelImpl1 implements Model1 {
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 0:
                    String jsonstr = (String) msg.obj;
                    Gson gson = new Gson();
                    MyData data = gson.fromJson(jsonstr, MyData.class);
                    callBack.setSuccess(data);

                    break;
            }
        }
    };
    private MyCallBack callBack;


    @Override
    public void getData(final String url, final MyCallBack callBack) {
        this.callBack = callBack;
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    String okk = OkHttps1.getInstence().get(url);
                    handler.sendMessage(handler.obtainMessage(0, okk));
                } catch (IOException e) {
                    callBack.setError("...........");
                }

            }
        }).start();
    }
}
