package zhuoxin.lineng.phonemanger;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by 繁华丶落尽 on 2016/6/15.
 */
public class SharedHelper {
    private static SharedHelper sInstance;
    private SharedHelper(Context context){
        preferences=context.getSharedPreferences("is_watch_guide",Context.MODE_PRIVATE);
    }

    public static SharedHelper getsInstance(Context context){
        if (sInstance==null){
            sInstance=new SharedHelper(context);
        }
        return sInstance;
    }
    private SharedPreferences preferences;
    public void save(){
        preferences.edit().putBoolean("iswatch",true).commit();

    }
    public boolean get(){

        return preferences.getBoolean("iswatch",false);
    }
}
