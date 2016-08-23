package zhuoxin.lineng.phonemanger;

import android.view.View;
import android.widget.TextView;

/**
 * Created by 繁华丶落尽 on 2016/6/22.
 */
public class Speed_Activity extends BaseActivity {
    private TextView phonename,version,memory;

    @Override
    public void bindLayout() {
        setContentView(R.layout.activity_speedup);
        initactionbar("手机加速",R.drawable.btn_homeasup_default,false,0);

    }

    @Override
    public void beforeInit() {

    }

    @Override
    public void initview() {
        phonename= (TextView) findViewById(R.id.phonename);

        version= (TextView) findViewById(R.id.version);

        memory= (TextView) findViewById(R.id.momory);
    }

    @Override
    public void afterInit() {
        phonename.setText(speed.getphonename());

        version.setText(speed.getphoneversion());

        memory.setText(speed.getmemory()+"KB");


    }

    @Override
    public void clickEvent(View v) {
    }

    @Override
    public void actionclick(View v) {
        finish();
    }
}
