package com.om.swachatha.corporation.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.om.swachatha.corporation.R;
import com.om.swachatha.corporation.service.APIService;
import com.om.swachatha.corporation.service.LoginService;
import com.om.swachatha.corporation.utils.Constant;
import com.om.swachatha.corporation.utils.NetworkUtility;
import com.om.swachatha.corporation.utils.ValidationUtils;

import org.json.JSONObject;

import java.util.HashMap;

public class SignInActivity extends AppCompatActivity implements View.OnClickListener {

    private final String TAG = SignInActivity.class.getName();
    private TextView tvSignInActForgotPwd;
    private TextView tvSignInActForgotSignUp;
    private Button btnActSignInNext;
    private EditText etActSignInPhoneNumber;
    private EditText etActSignInPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        setUpView();
        registerClickEvent();
    }

    @Override
    public void onClick(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.tvSignInActForgotPwd:
                intent = new Intent(SignInActivity.this, ForgotPasswordActivity.class);
                startActivity(intent);
                break;
            case R.id.tvSignInActForgotSignUp:
                intent = new Intent(SignInActivity.this, SignUpActivity.class);
                startActivity(intent);
                break;
            case R.id.btnActSignInNext:
                if (ValidationUtils.isValidEditText(etActSignInPhoneNumber, "Please enter mobile number") &&
                        ValidationUtils.isValidEditText(etActSignInPassword, "Please enter password")) {
                    /*if (ValidationUtils.isValidMobile(etActSignInPhoneNumber)) {*/
                    if (NetworkUtility.isNetworkAvailable(SignInActivity.this)) {
                        callLoginService();
                    }
                    intent = new Intent(SignInActivity.this, MainActivity.class);
                    intent.putExtra(Constant.COME_FROM_VERIFY,false);
                    startActivity(intent);
                    finish();
                    //}
                }
                break;
        }
    }

    /**
     * Set Up View
     */
    private void setUpView() {
        tvSignInActForgotPwd = (TextView) findViewById(R.id.tvSignInActForgotPwd);
        tvSignInActForgotSignUp = (TextView) findViewById(R.id.tvSignInActForgotSignUp);
        btnActSignInNext = (Button) findViewById(R.id.btnActSignInNext);
        etActSignInPhoneNumber = (EditText) findViewById(R.id.etActSignInPhoneNumber);
        etActSignInPassword = (EditText) findViewById(R.id.etActSignInPassword);
    }

    /**
     * Register Click Event
     */
    private void registerClickEvent() {
        tvSignInActForgotPwd.setOnClickListener(this);
        tvSignInActForgotSignUp.setOnClickListener(this);
        btnActSignInNext.setOnClickListener(this);
    }

    /**
     * Call Login Service
     */
    private void callLoginService() {
        HashMap<String, String> params = new HashMap<>();
        params.put("mobile", etActSignInPhoneNumber.getText().toString());
        params.put("password", etActSignInPassword.getText().toString());
        LoginService.loginService(SignInActivity.this, params, new APIService.Success<JSONObject>() {
            @Override
            public void onSuccess(JSONObject response) {
                Log.i(TAG, "Login Response-->" + response.toString());
            }
        });
    }
}
