package com.example.yuekaozxf.model;

import android.os.Handler;
import android.os.Message;

import com.example.yuekaozxf.bean.MyData;
import com.example.yuekaozxf.callback.MyCallBack;
import com.example.yuekaozxf.httpp.OkHttps;
import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.OkHttpClient;

public class ModelImpl implements Model{
    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case 0:
                    String jsonstr= (String) msg.obj;
                    Gson gson=new Gson();
                   MyData data= gson.fromJson(jsonstr,MyData.class);
                    callBack.setSuccess(data);

                    break;
            }
        }
    };
    private MyCallBack callBack;



    @Override
    public void getData(final String mUrl, final MyCallBack callBack) {
this.callBack=callBack;
new Thread(new Runnable() {
    @Override
    public void run() {
        try {
            String okk=OkHttps.getInstence().get(mUrl);
            handler.sendMessage(handler.obtainMessage(0,okk));
        } catch (IOException e) {
            callBack.setError("...........");
        }

    }
}).start();
    }
}
