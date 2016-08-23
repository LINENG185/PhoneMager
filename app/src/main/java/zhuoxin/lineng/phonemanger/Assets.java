package zhuoxin.lineng.phonemanger;

import android.content.Context;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by 繁华丶落尽 on 2016/6/13.
 */
public class Assets {
    public static void saveFile(Context context, String fromFile, String toFile) throws IOException {
        Logutil.LogD("fromFile:" + fromFile);
        Logutil.LogD("toFile:"+toFile);
        InputStream is = context.getResources().getAssets().open(fromFile);
        File target = new File(toFile);
//        if (!target.exists()){
        target.getParentFile().mkdirs();
        target.createNewFile();
        FileOutputStream fos= new FileOutputStream(target);
        byte[] b = new byte[1024];
        int len = 0;
        while((len = is.read(b))!=-1){
            fos.write(b,0,len);
            fos.flush();
        }
        fos.close();
        is.close();
//        }
    }
}
