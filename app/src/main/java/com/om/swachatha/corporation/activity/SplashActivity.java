package com.om.swachatha.corporation.activity;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.om.swachatha.corporation.R;

/**
 * Date Project Starting 12-03-2018
 */
public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        handler();
    }

    private void handler() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //Check User Ready Login Or Not
                Intent intent = new Intent(SplashActivity.this, SignInActivity.class);
                finish();
                startActivity(intent);

            }
        }, 3000);
    }
}
