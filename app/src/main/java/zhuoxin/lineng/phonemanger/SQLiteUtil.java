package zhuoxin.lineng.phonemanger;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Adapter;

import java.util.ArrayList;

/**
 * Created by 繁华丶落尽 on 2016/6/13.
 */
public class SQLiteUtil {
    public static ArrayList<Telclass>getclass(){
        ArrayList<Telclass> list=new ArrayList<>();
        SQLiteDatabase database=SQLiteDatabase.openOrCreateDatabase("data/data/zhuoxin.lineng.phonemanger/commonnum.db",null);
        Cursor cursor=database.query("classlist",null,null,null,null,null,null);
        while (cursor.moveToNext()){
            String name = cursor.getString(cursor.getColumnIndex("name"));

            int idx = cursor.getInt(cursor.getColumnIndex("idx"));

            list.add(new Telclass(name,idx));
        }
        return list;
    }


    public static ArrayList<telclassif> gettelclass(int idx){
        ArrayList<telclassif> list=new ArrayList<>();
    SQLiteDatabase database=SQLiteDatabase.openOrCreateDatabase(constant.DATA_PATH,null);
        Cursor cursor= database.query("table"+idx,null,null,null,null,null,null);
        while (cursor.moveToNext()){
            int _id=cursor.getInt(cursor.getColumnIndex("_id"));
            long nunber=cursor.getLong(cursor.getColumnIndex("number"));
            String name=cursor.getString(cursor.getColumnIndex("name"));
            list.add(new telclassif(_id,nunber,name));
        }



        return list;
    }

}
