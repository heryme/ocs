package com.om.swachatha.corporation.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.om.swachatha.corporation.R;
import com.om.swachatha.corporation.utils.ValidationUtils;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText etActSignUpPhoneNumber;
    //private EditText etActSignUpCity;
    private EditText etActSignUpPassword;
    private EditText etActSignUpConfirmPassword;
    private Button btnActSignUpNext;
    private TextView tvActSignUpSignIn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        setUpView();
        setClickLister();
    }

    /**
     * Set Up View
     */
    private void setUpView() {
        etActSignUpPhoneNumber = (EditText) findViewById(R.id.etActSignUpPhoneNumber);
       // etActSignUpCity = (EditText) findViewById(R.id.etActSignUpCity);
        etActSignUpPassword = (EditText) findViewById(R.id.etActSignUpPassword);
        etActSignUpConfirmPassword = (EditText) findViewById(R.id.etActSignUpConfirmPassword);
        btnActSignUpNext = (Button) findViewById(R.id.btnActSignUpNext);
        tvActSignUpSignIn = (TextView) findViewById(R.id.tvActSignUpSignIn);
    }

    @Override
    public void onClick(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.tvActSignUpSignIn:
                intent = new Intent(SignUpActivity.this,SignInActivity.class);
                startActivity(intent);
                break;
            case R.id.btnActSignUpNext:
                if(ValidationUtils.isValidEditText(etActSignUpPhoneNumber,"Please enter mobile number") &&
                        ValidationUtils.isValidEditText(etActSignUpPassword,"Please enter Password") &&
                        ValidationUtils.isValidEditText(etActSignUpConfirmPassword,"Please enter confirm password")) {
                    if(ValidationUtils.isBothPasswordEqual(SignUpActivity.this,etActSignUpPassword,etActSignUpConfirmPassword)) {
                        //Toast.makeText(SignUpActivity.this,"Success",Toast.LENGTH_SHORT).show();
                        intent = new Intent(SignUpActivity.this,VerifyActivity.class);
                        startActivity(intent);
                    }
                }
                break;
           }
    }

    /**
     * Set Click Listener
     */
    private void setClickLister() {
        tvActSignUpSignIn.setOnClickListener(this);
        btnActSignUpNext.setOnClickListener(this);
    }
}
