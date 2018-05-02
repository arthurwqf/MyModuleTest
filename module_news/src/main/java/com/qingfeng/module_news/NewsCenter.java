package com.qingfeng.module_news;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.facade.callback.NavigationCallback;
import com.alibaba.android.arouter.launcher.ARouter;

@Route(path = "/news/center")
public class NewsCenter extends AppCompatActivity {

    private static final String TAG = "test";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        final Context context = this;
        findViewById(R.id.tv_news).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ARouter.getInstance().build("/news/center").navigation(NewsCenter.this, new NavigationCallback() {
                    @Override
                    public void onFound(Postcard postcard) {
                        Log.d("test", "onFound: ");
                    }

                    @Override
                    public void onLost(Postcard postcard) {
                        Log.d("test", "onLost: ");
                    }

                    @Override
                    public void onArrival(Postcard postcard) {
                        Log.d(TAG, "onArrival: ");
                    }

                    @Override
                    public void onInterrupt(Postcard postcard) {
                        Log.d(TAG, "onInterrupt: ");
                    }
                });
            }
        });
    }
}
