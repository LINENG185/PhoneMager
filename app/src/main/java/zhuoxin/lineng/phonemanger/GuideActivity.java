package zhuoxin.lineng.phonemanger;

import android.content.Intent;
import android.media.Image;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 繁华丶落尽 on 2016/6/15.
 */
public class GuideActivity extends BaseActivity {
    private ViewPager viewPager;
    private TextView textView;
    private Guideviewpager guideviewpager;
    private ImageView[] ico = new ImageView[3];
    private int[] image = {R.id.iv_1, R.id.iv_2, R.id.iv_3,};
    private ArrayList<ImageView> list = new ArrayList<>();
    private int[] resids = {R.drawable.adware_style_applist, R.drawable.adware_style_banner, R.drawable.adware_style_creditswall};
    private SharedHelper helper;
    private ImageView iv_3;
    @Override
    public void bindLayout() {
        helper=SharedHelper.getsInstance(this);
        setContentView(R.layout.guideactivity);
        if (helper.get()){
            Intent intent = new Intent(GuideActivity.this, Logo.class);
            startActivity(intent);
            finish();
        }
    }

    @Override
    public void beforeInit() {

    }

    @Override
    public void initview() {
        textView = (TextView) findViewById(R.id.tv_guide);
        viewPager = (ViewPager) findViewById(R.id.vp_guide);

        for (int i = 0; i < ico.length; i++) {
            ico[i] = (ImageView) findViewById(image[i]);
        }
        ico[0].setImageResource(R.drawable.adware_style_selected);
        iv_3 = (ImageView) findViewById(R.id.iv_3);
        iv_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GuideActivity.this,Logo.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public void afterInit() {
        for (int i = 0; i < 3; i++) {
            ImageView iv = new ImageView(GuideActivity.this);
            iv.setScaleType(ImageView.ScaleType.CENTER);
            iv.setImageResource(resids[i]);
            list.add(iv);
        }
        guideviewpager = new Guideviewpager(list);
        viewPager.setAdapter(guideviewpager);
        textView.setOnClickListener(this);
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                for (int i = 0; i < ico.length; i++) {
                    ico[i].setImageResource(i == position ? R.drawable.adware_style_selected : R.drawable.adware_style_default);
                }
                textView.setVisibility(position == 2 ? View.VISIBLE : View.GONE);





                }


            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    @Override
    public void clickEvent(View v) {
        switch (textView.getId()) {
            case R.id.tv_guide:
                helper.save();
                Intent intent = new Intent(GuideActivity.this, Logo.class);
                startActivity(intent);
                finish();
                break;

        }
    }

    @Override
    public void actionclick(View v) {

    }


}
