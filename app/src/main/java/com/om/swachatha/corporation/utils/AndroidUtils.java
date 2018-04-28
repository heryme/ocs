package com.om.swachatha.corporation.utils;

import android.util.Log;

import java.util.Map;

/**
 * Created by Rid's Patel on 15-03-2018.
 */

public class AndroidUtils {
    public static void queryString(String from, String url, Map<String, String> map) {

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(url);
        stringBuilder.append("/");
        if (map.size() > 0) {
            for (Map.Entry<String, String> entry : map.entrySet()) {

                stringBuilder.append(entry.getKey() + "=" + entry.getValue() + "&");
            }
        }

        Log.i(from, stringBuilder.toString());
    }
}

