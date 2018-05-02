package com.qingfeng.mymoduletest;

import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.callback.NavigationCallback;
import com.alibaba.android.arouter.launcher.ARouter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private BottomNavigationView.OnNavigationItemSelectedListener mNavSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    return true;
                case R.id.navigation_dashboard:
                    return true;
                case R.id.navigation_notifications:
                    return true;
                default:
                    return false;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.to_news).setOnClickListener(this);

        BottomNavigationView navigationView = findViewById(R.id.nav);
        navigationView.setOnNavigationItemSelectedListener(mNavSelectedListener);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.to_news:
                ARouter.getInstance().build("/news/center").navigation(this, new NavigationCallback() {

                    @Override
                    public void onFound(Postcard postcard) {
                        Log.d("test", "onFound: 找到了");
                    }

                    @Override
                    public void onLost(Postcard postcard) {
                        Log.d("test", "onLost: 没找到");
                    }

                    @Override
                    public void onArrival(Postcard postcard) {
                        Log.d("test", "onArrival: 到达");
                    }

                    @Override
                    public void onInterrupt(Postcard postcard) {
                        Log.d("test", "onInterrupt: 拦截");
                    }
                });
                break;
        }
    }
}
