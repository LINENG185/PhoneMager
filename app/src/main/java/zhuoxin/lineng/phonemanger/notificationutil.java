package zhuoxin.lineng.phonemanger;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.widget.RemoteViews;

/**
 * Created by 繁华丶落尽 on 2016/6/21.
 */
public class notificationutil {
        private SharedPreferences preferences;
        private Notification notification;
        private NotificationManager manager;
    public notificationutil(Context context){
        preferences=context.getSharedPreferences("remember",Context.MODE_PRIVATE);

        manager= (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

        notification=new Notification();

        notification.icon=R.mipmap.icc_launcher;

        notification.flags=Notification.FLAG_AUTO_CANCEL;

        RemoteViews remoteViews=new RemoteViews(context.getPackageName(),R.layout.layout_notify);

        notification.contentView=remoteViews;

        Intent intent=new Intent(context,HomeActivity.class);

        PendingIntent pendingIntent=PendingIntent.getActivity(context,1,intent,PendingIntent.FLAG_UPDATE_CURRENT);

        notification.contentIntent=pendingIntent;

    }
    public void shownotify(){
        manager.notify(0x112,notification);
        preferences.edit().putBoolean("notifyon",true).commit();
    }
    public void cancelnotify(){
        manager.cancel(0x112);
        preferences.edit().putBoolean("notifyon",false).commit();
    }
    public boolean getNotify(){
        return preferences.getBoolean("notifyon",false);
    }
}
