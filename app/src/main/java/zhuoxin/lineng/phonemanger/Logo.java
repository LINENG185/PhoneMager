package zhuoxin.lineng.phonemanger;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * Created by 繁华丶落尽 on 2016/6/12.
 */
public class Logo extends Activity {
    private  ImageView imageView;
    private Animation mAnimation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.logo);
        imageView= (ImageView) findViewById(R.id.imageView);
        mAnimation= AnimationUtils.loadAnimation(Logo.this, R.anim.set);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView.startAnimation(mAnimation);
            }
        });

        mAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                Intent intent=new Intent(Logo.this,HomeActivity.class);
                Logo.this.startActivity(intent);
//                System.exit(0);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

    }
}
