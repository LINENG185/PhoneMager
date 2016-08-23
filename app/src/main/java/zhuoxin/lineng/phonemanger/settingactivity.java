package zhuoxin.lineng.phonemanger;

import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ToggleButton;

/**
 * Created by 繁华丶落尽 on 2016/6/21.
 */
public class settingactivity extends BaseActivity implements CompoundButton.OnCheckedChangeListener {
    ToggleButton toggleButton;
    private notificationutil util;
    @Override
    public void bindLayout() {
    setContentView(R.layout.settingactivity);
    }

    @Override
    public void beforeInit() {
        util=new notificationutil(this);
    }

    @Override
    public void initview() {
        toggleButton= (ToggleButton) findViewById(R.id.tog_setting);
        initactionbar("设置",R.drawable.btn_homeasup_default,false,0);

    }

    @Override
    public void afterInit() {

        toggleButton.setOnCheckedChangeListener(this);
        toggleButton.setChecked(util.getNotify());

    }

    @Override
    public void clickEvent(View v) {

    }

    @Override
    public void actionclick(View v) {
        finish();
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (isChecked){
            util.shownotify();
        }else{
            util.cancelnotify();
        }
    }
}
