package com.example.yuekaozxf.pp;

import com.example.yuekaozxf.bean.MyData;
import com.example.yuekaozxf.callback.MyCallBack;
import com.example.yuekaozxf.model.ModelImpl;
import com.example.yuekaozxf.model.ModelImpl1;
import com.example.yuekaozxf.vieww.IView;

public class PerenerImpl1 implements Perener1{
    private IView iView;
    private ModelImpl1  model1;

    public PerenerImpl1(IView iView) {
        this.iView = iView;
        model1=new ModelImpl1();
    }


    @Override
    public void startRequest(String url) {
        this.model1.getData(url, new MyCallBack() {
            @Override
            public void setSuccess(MyData data) {
                iView.setSuccess(data);
            }

            @Override
            public void setError(String error) {
                iView.setError(error);
            }
        });
    }
}
