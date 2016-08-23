package zhuoxin.lineng.phonemanger;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by 繁华丶落尽 on 2016/6/21.
 */
public class Aboutactivity extends BaseActivity {


    @Override
    public void bindLayout() {
        setContentView(R.layout.activity_about);
    }

    @Override
    public void beforeInit() {

    }

    @Override
    public void initview() {
        initactionbar("关于我们",R.drawable.btn_homeasup_default,false,0);
    }

    @Override
    public void afterInit() {

    }

    @Override
    public void clickEvent(View v) {

    }
    public void actionclick (View v){
            finish();
    }
}