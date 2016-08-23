package zhuoxin.lineng.phonemanger;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RemoteViews;

/**
 * Created by 繁华丶落尽 on 2016/6/21.
 */
public class Notify_activity extends Activity {
    Button button;
    Notification notification;
    NotificationManager manager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.selector);
        button= (Button) findViewById(R.id.btn_selector);
        initnotify();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                manager.notify(0x110,notification);
            }
        });
    }
    public void initnotify(){
        //所有系统级服务都是这个方法初始化
        manager= (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notification=new Notification();
        notification.icon=R.mipmap.icc_launcher;
        notification.flags=Notification.FLAG_AUTO_CANCEL;//可以清理
        notification.tickerText="你有新短消息，请注意查收";

        RemoteViews remoteViews=new RemoteViews(getPackageName(),R.layout.activity_notify);
        notification.contentView=remoteViews;
        Intent intent = new Intent(Notify_activity.this,HomeActivity.class);
        PendingIntent pendingIntent=PendingIntent.getActivity(Notify_activity.this,1, intent,PendingIntent.FLAG_UPDATE_CURRENT);

        notification.contentIntent=pendingIntent;
    }
}
