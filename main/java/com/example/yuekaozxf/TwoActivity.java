package com.example.yuekaozxf;

import android.Manifest;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.PermissionChecker;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.yuekaozxf.adapter.MyAdapter;
import com.example.yuekaozxf.adapter.XAdapter;
import com.example.yuekaozxf.bean.MyData;
import com.example.yuekaozxf.pp.PerenerImpl;
import com.example.yuekaozxf.vieww.IView;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;

public class TwoActivity extends AppCompatActivity implements IView{

    private RecyclerView recydan;
    private XRecyclerView xrecy;
    private String mUrl = "http://www.zhaoapi.cn/product/getCarts?uid=71";
    private PerenerImpl perener;
    private ArrayList<MyData.DataBean> list = new ArrayList<>();
    private ArrayList<MyData.DataBean> list1 = new ArrayList<>();
    private MyAdapter adapter;
    private LinearLayoutManager lmanager;
    private TextView sao;
    private EditText sousuo;
    private ImageView qiehuan;
    private GridLayoutManager manager;
    private LinearLayout linear;
    private android.widget.SearchView searchView;
    private XAdapter xAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);
        initView();
        perener = new PerenerImpl(this);
        perener.startRequest(mUrl);
        adapter = new MyAdapter(list, this);
        xAdapter = new XAdapter(list1,this);
       recydan .setAdapter(adapter);
       xrecy.setAdapter(xAdapter);
       manager=new GridLayoutManager(this,5);
       recydan.setLayoutManager(manager);
       lmanager=new LinearLayoutManager(this);
       xrecy.setLayoutManager(lmanager);
    }

    private void initView() {

        //引用控件
        recydan = (RecyclerView) findViewById(R.id.recydan);
        xrecy = (XRecyclerView) findViewById(R.id.xrecy);
        sao = (TextView) findViewById(R.id.sao);
        /*sao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!initPermmsion()){
                    new AlertDialog.Builder(TwoActivity.this)
                            .

                }



            }
        });*/
        //searchView= findViewById(R.id.search_view);
        qiehuan = (ImageView) findViewById(R.id.qiehuan);
        //切换页面
        qiehuan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TwoActivity.this,ThreeActivity.class));
            }
        });

    }
//成功的方法
    @Override
    public void setSuccess(MyData data) {
        list.addAll(data.getData());
        list1.addAll(data.getData());
        adapter.notifyDataSetChanged();

    }

    @Override
    public void setError(String error) {

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

    }

    private boolean initPermmsion(){
        String mmm=Manifest.permission.CAMERA;
        boolean es=false;
        if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.M){
            es=PermissionChecker.checkSelfPermission(TwoActivity.this,mmm)==PermissionChecker.PERMISSION_GRANTED;

        }
        return es;
}

}
