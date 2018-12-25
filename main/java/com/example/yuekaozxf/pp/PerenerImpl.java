package com.example.yuekaozxf.pp;

import com.example.yuekaozxf.bean.MyData;
import com.example.yuekaozxf.callback.MyCallBack;
import com.example.yuekaozxf.model.ModelImpl;
import com.example.yuekaozxf.vieww.IView;

public class PerenerImpl implements Perener{
    private IView iView;
    private ModelImpl  model;

    public PerenerImpl(IView iView) {
        this.iView = iView;
        model=new ModelImpl();
    }




    @Override
    public void startRequest(String mUrl) {
        this.model.getData(mUrl, new MyCallBack() {
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
