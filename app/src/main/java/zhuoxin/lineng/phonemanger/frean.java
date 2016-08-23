package zhuoxin.lineng.phonemanger;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * Created by 繁华丶落尽 on 2016/6/12.
 */
public class frean extends Activity {
    private  ImageView imageView;
    private AnimationDrawable mAnimationDrawable;
    private int mTime=0;
    Toast toast;
    private Handler mHandler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (toast!=null){
                toast.cancel();
            }
            switch (msg.what){
                case 0:
                case 1:
                case 2:
                case 3:
                mTime++;
                    toast=Toast.makeText(frean.this,"这是第"+mTime+"秒",Toast.LENGTH_SHORT);
                    toast.show();
                    mHandler.sendEmptyMessageDelayed(mTime,1000);
                    break;
                case 4:
                    Intent intent=new Intent(frean.this,TelActivity.class);
                    startActivity(intent);
                    overridePendingTransition(R.anim.samll,R.anim.big);
                    finish();
                    break;
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.frean);
        imageView= (ImageView) findViewById(R.id.imageView);
        mAnimationDrawable= (AnimationDrawable) imageView.getDrawable();
        mAnimationDrawable.start();
        mHandler.sendEmptyMessage(0);

    }
}
