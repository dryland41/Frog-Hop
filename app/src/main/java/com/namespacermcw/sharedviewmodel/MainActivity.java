package com.namespacermcw.sharedviewmodel;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager().beginTransaction()
                .add(R.id.container_first, new FirstFragment())
                .add(R.id.container_middle, new MiddleFragment())
                .add(R.id.container_last, new LastFragment())
                .commit();

        LocalBroadcastManager broadcastManager = LocalBroadcastManager.getInstance(this);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(BROADCAST_ACTIVITY_CLOSE);
        broadcastManager.registerReceiver(broadcastReceiver, intentFilter);
    }

    static final String BROADCAST_ACTIVITY_CLOSE = "com.example.ACTIVITY_CLOSE_BROADCAST";

    private BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            if(intent.getAction().equals(BROADCAST_ACTIVITY_CLOSE)) {
                //terminateCleanly();
                finish();
            }
        }
    };
}