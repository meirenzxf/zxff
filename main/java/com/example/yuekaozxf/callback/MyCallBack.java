package com.example.yuekaozxf.callback;

import com.example.yuekaozxf.bean.MyData;

public interface MyCallBack {
    void setSuccess(MyData data);
    void setError(String error);

}
