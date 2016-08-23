package zhuoxin.lineng.phonemanger;

import android.os.Build;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by 繁华丶落尽 on 2016/6/23.
 */
public class speed {
    //获取手机品牌
    public static String getphonename(){
        return Build.BRAND;
    }
    //获取手机型号
    public static String getphoneversion(){
        return Build.MODEL+" Android "+Build.VERSION.RELEASE;
    }

    /*
    * 获取手机总内存
    * */
    public static long getmemory(){
        try {
            FileReader fr=new FileReader("pron/memifo");
            BufferedReader br=new BufferedReader(fr);
            String line=br.readLine();
            String []arr=line.split("\\D+");
            return Long.parseLong(arr[1]);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return 0;
    }
}
