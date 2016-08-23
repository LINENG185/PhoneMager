package zhuoxin.lineng.phonemanger;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

/**
 * Created by 繁华丶落尽 on 2016/6/15.
 */
public class Guideviewpager extends PagerAdapter {
    private List<ImageView>list;

    public Guideviewpager(List<ImageView> list) {
        this.list = list;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view=list.get(position);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(list.get(position));
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }
}
