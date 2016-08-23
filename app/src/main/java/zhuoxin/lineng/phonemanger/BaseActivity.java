package zhuoxin.lineng.phonemanger;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by 繁华丶落尽 on 2016/6/15.
 */
public abstract class BaseActivity extends Activity implements View.OnClickListener{
   private boolean isShow=true;

    private ImageView left_icon,right_icon;
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        isShownotify(isShow);
        bindLayout();
        beforeInit();
        initview();
        afterInit();
    }
    public void isShownotify(boolean isShow){
        if (!isShow){
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }
        requestWindowFeature(Window.FEATURE_NO_TITLE);
    }

    public abstract void bindLayout();

    public abstract void beforeInit();

    public abstract void initview();

    public abstract void afterInit();
    public void onClick(View v){
        clickEvent(v);
    }

    public abstract void clickEvent(View v);
    public abstract void actionclick (View v);

    public void initactionbar(String tex,int leftresid,boolean isshowright,int rightresid){
        left_icon= (ImageView) findViewById(R.id.left_actionbar);

        right_icon= (ImageView) findViewById(R.id.right_actionbar);

        textView= (TextView) findViewById(R.id.tv_actionbar);

        textView.setText(tex);

        left_icon.setImageResource(leftresid);

        if (isshowright){
            right_icon.setImageResource(rightresid);
        }else{
            right_icon.setVisibility(View.GONE);
        }
    }

}
