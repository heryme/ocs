package com.om.swachatha.corporation.service;

import android.content.Context;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Rahul Padaliya on 7/29/2016.
 */
public class CityListService extends APIService {

    private static final String TAG = CityListService.class.getSimpleName();
    private static final String URL_CITY_LIST = BASE_URL + "/getquestionnaire/NThhYWRmMjg5ZmRhMjAzMzExNmRhYzM2";


    public static void getCityListService(final Context context, final HashMap<String,String> params,
                                        final Success<JSONObject> successListener) {

 //       final ProgressDialog dialog = DialogUtility.processDialog(context, "Please Wait", true);

        Log.d(TAG, "OSC Get City List URL-->" + URL_CITY_LIST);
        StringRequest overviewRequest = new StringRequest(Request.Method.POST, URL_CITY_LIST, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    //dialog.hide();
                    successListener.onSuccess(new JSONObject(response));
                    Log.d(TAG, "OSC City List Response" + response.toString());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                    //dialog.hide();
                try{
                    Log.d(TAG,"OSC Get City List Error  >>"+ error.toString());
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
    }
}
