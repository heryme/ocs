package com.om.swachatha.corporation.utils;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;

/**
 * Created by Rid's Patel on 15-03-2018.
 */

public class DialogUtils {

    public static ProgressDialog showProgress(final Context context) {
        final ProgressDialog progressDialog;
        progressDialog = new ProgressDialog(context);
        ((Activity) context).runOnUiThread(new Runnable() {
            @Override
            public void run() {
                progressDialog.setMessage("Please wait...");
                progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                progressDialog.setCancelable(false);
                progressDialog.show();

            }
        });

        return progressDialog;
    }
}
