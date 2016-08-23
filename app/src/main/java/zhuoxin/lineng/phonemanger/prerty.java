package zhuoxin.lineng.phonemanger;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

/**
 * Created by 繁华丶落尽 on 2016/6/12.
 */
public class prerty extends Activity {
    private ImageView imageView;
   private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.prerty);
        imageView= (ImageView) findViewById(R.id.imageView);
        button= (Button) findViewById(R.id.button);

    }
    public void buttonClick(View view){
        ObjectAnimator a=ObjectAnimator.ofFloat(imageView,"rotationX",0,3600);
        ObjectAnimator b=ObjectAnimator.ofFloat(imageView,"alpha",1,0,1);

        a.setDuration(5000);
        b.setDuration(5000);
        a.start();
        b.start();
    }
}
