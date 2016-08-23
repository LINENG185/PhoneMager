package zhuoxin.lineng.phonemanger;

import android.util.Log;

/**
 * Created by 繁华丶落尽 on 2016/6/13.
 */
public class Logutil {
    private static final boolean IS_DEBUG=true;
    public static void LogD(String content){
        if (IS_DEBUG){
            Log.d("debug","content");
        }
    }
    public static void LogW(String content){
        if (IS_DEBUG){
            Log.w("warn",content);
        }
    }
}
