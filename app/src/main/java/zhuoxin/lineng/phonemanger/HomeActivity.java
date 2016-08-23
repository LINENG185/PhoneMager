package zhuoxin.lineng.phonemanger;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;

/**
 * Created by 繁华丶落尽 on 2016/6/20.
 */
public class HomeActivity extends BaseActivity {
    TextView textView ,textview_speedup;
    @Override
    public void bindLayout() {
        setContentView(R.layout.actuvuty_home);
    }

    @Override
    public void beforeInit() {

    }

    @Override
    public void initview() {
        textview_speedup= (TextView) findViewById(R.id.tv_speedup);
        textView= (TextView) findViewById(R.id.tv_tel);

    }

    @Override
    public void afterInit() {

    }

    @Override
    public void clickEvent(View v) {

    }
    public void actionclick(View v){
        Intent intent=new Intent();
        switch (v.getId()){
            case R.id.left_actionbar:
                intent.setClass(HomeActivity.this,Aboutactivity.class);
                startActivity(intent);
                break;
            case R.id.right_actionbar:
                intent.setClass(HomeActivity.this,settingactivity.class);
                startActivity(intent);
                break;
            case R.id.tv_tel:
                intent.setClass(HomeActivity.this,TelActivity.class);
                startActivity(intent);
                break;
            case R.id.tv_speedup:
                intent.setClass(HomeActivity.this,Speed_Activity.class);
                startActivity(intent);
                break;
        }
    }

}
