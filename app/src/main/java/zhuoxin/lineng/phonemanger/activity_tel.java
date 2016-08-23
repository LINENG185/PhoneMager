package zhuoxin.lineng.phonemanger;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LayoutAnimationController;
import android.view.animation.TranslateAnimation;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by 繁华丶落尽 on 2016/6/14.
 */
public class activity_tel extends Activity {
    TextView textView;
    ListView listView;
    private teladter teladter;
    private ArrayList<telclassif> list;
    private long PhoneNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tel);
        textView = (TextView) findViewById(R.id.tv_name);
        listView = (ListView) findViewById(R.id.lv_name);
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        int idx = intent.getIntExtra("idx", -1);
        textView.setText(name);
        list = SQLiteUtil.gettelclass(idx);
        teladter = new teladter(this, list);
        listView.setAdapter(teladter);

        Animation animation = new TranslateAnimation(Animation.RELATIVE_TO_SELF, -1,
                Animation.RELATIVE_TO_SELF, 0,
                Animation.RELATIVE_TO_SELF, 0,
                Animation.RELATIVE_TO_SELF, 0);
        animation.setDuration(400);
        listView.setLayoutAnimation(new LayoutAnimationController(animation));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                PhoneNumber = list.get(position).getNunber();
                showDialog(PhoneNumber);

            }
        });

    }

    private DialogInterface.OnClickListener click = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            Intent intent = new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse("tel:" + PhoneNumber));
            startActivity(intent);
        }
    };

    public void showDialog(long phoneNumber) {
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setTitle("警告");
        dialog.setMessage("电话是" + phoneNumber);
        dialog.setPositiveButton("确定拨打", click);
        dialog.setNegativeButton("取消", null);
        dialog.create().show();
    }
}
