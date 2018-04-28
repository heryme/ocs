package com.om.swachatha.corporation.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by DELL on 25-11-2015.
 */
public class UserSession {

    private Context mContext;

    public static final String PREFERENCE_NAME = "omc";
    public static final String USER_ID = "userId";


    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    private static UserSession userSession;


    public UserSession(Context context) {
        this.mContext = context;
        sharedPreferences = this.mContext.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE);
        this.editor = sharedPreferences.edit();
    }

    public SharedPreferences getSharedPreferences() {
        return sharedPreferences;
    }


    public void setUserId(String userId) {
        editor.putString(USER_ID,userId);
        editor.commit();
    }

    /**
     * Get Value Of The Given USer Rate
     * @return
     */
    public String getUserId() {
        return getSharedPreferences().getString(USER_ID,"");
    }
}
