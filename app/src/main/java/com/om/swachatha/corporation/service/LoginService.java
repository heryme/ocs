package com.om.swachatha.corporation.service;

import android.app.ProgressDialog;
import android.content.Context;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.om.swachatha.corporation.utils.AndroidUtils;
import com.om.swachatha.corporation.utils.DialogUtils;

import org.json.JSONException;
import org.json.JSONObject;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Rahul Padaliya on 7/29/2016.
 */
public class LoginService extends APIService {

    private static final String TAG = LoginService.class.getSimpleName();
    private static final String URL_LOGIN = BASE_URL + "login";


    public static void loginService(final Context context, final HashMap<String,String> params,
                                        final Success<JSONObject> successListener) {

       final ProgressDialog dialog = DialogUtils.showProgress(context);

        Log.d(TAG, "OSC Login URL-->" + URL_LOGIN);
        StringRequest overviewRequest = new StringRequest(Request.Method.POST, URL_LOGIN, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    dialog.hide();
                    successListener.onSuccess(new JSONObject(response));
                    Log.d(TAG, "OSC Login Response" + response.toString());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                    dialog.hide();
                try{
                    Log.d(TAG,"OSC Login Error  >>"+ error.toString());
                    //handleError(context,error);

                }catch (Exception e) {
                    Log.d(TAG,""+ e.getMessage());
                }

            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                return params;
            }
        };

        APIController.getInstance(context).addRequest(overviewRequest, TAG);
        AndroidUtils.queryString(TAG,URL_LOGIN,params);
    }
}
