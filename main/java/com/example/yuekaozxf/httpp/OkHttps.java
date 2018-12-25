package com.example.yuekaozxf.httpp;


import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.logging.HttpLoggingInterceptor;

public class OkHttps {

    private final HttpLoggingInterceptor loggingInterceptor;
    private final OkHttpClient okHttpClient;

    public OkHttps() {
        loggingInterceptor = new HttpLoggingInterceptor();
        okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(20,TimeUnit.SECONDS)
                .readTimeout(20,TimeUnit.SECONDS)
                .callTimeout(20,TimeUnit.SECONDS)
                .addInterceptor(loggingInterceptor)
                .build();


    }
    public static OkHttps getInstence(){
        return OkHolder.okutli;
    }
 static class OkHolder{
        private static final OkHttps okutli=new OkHttps();
 }
public String get(String mUrl) throws IOException{
    Request request=new Request.Builder().url(mUrl).build();
    return okHttpClient.newCall(request).execute().body().string();

}
public String post(String mUrl,String key,String value) throws IOException{
    RequestBody body=new FormBody.Builder().add(mUrl,value).build();
    Request request=new Request.Builder().url(mUrl).post(body).build();
        return okHttpClient.newCall(request).execute().body().string();
}





}
