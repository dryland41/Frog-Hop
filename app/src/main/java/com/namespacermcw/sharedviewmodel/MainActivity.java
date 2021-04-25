package com.namespacermcw.sharedviewmodel;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

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
    }
}