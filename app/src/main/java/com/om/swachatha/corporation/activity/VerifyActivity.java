package com.om.swachatha.corporation.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.om.swachatha.corporation.R;
import com.om.swachatha.corporation.utils.Constant;
import com.om.swachatha.corporation.utils.ValidationUtils;

public class VerifyActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText etActVerifyOtp;
    private Button btnActVerifyResend;
    private Button btnActVerifyNext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verify);
        setUpView();
        setListener();
    }

    /**
     * Set Up View
     */
    private  void setUpView() {
        etActVerifyOtp = (EditText) findViewById(R.id.etActVerifyOtp);
        btnActVerifyResend = (Button) findViewById(R.id.btnActVerifyResend);
        btnActVerifyNext = (Button) findViewById(R.id.btnActVerifyNext);

    }

    @Override
    public void onClick(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.btnActVerifyNext:
                if(ValidationUtils.isValidEditText(etActVerifyOtp,"Enter otp")) {
                    //Toast.makeText(VerifyActivity.this,"Success",Toast.LENGTH_SHORT).show();
                    intent = new Intent(VerifyActivity.this,MainActivity.class);
                    intent.putExtra(Constant.COME_FROM_VERIFY,true);
                    startActivity(intent);
                }
                break;
        }
    }

    /**
     * Set Listner
     */
    private void setListener() {
        btnActVerifyNext.setOnClickListener(this);
    }
}
