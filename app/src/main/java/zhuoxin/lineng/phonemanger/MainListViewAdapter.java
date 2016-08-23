package zhuoxin.lineng.phonemanger;

import android.content.Context;
import android.support.v4.widget.ViewDragHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by 繁华丶落尽 on 2016/6/13.
 */
public class MainListViewAdapter extends BaseAdapter {
    private Context context;

    private ArrayList<Telclass> list;
    public MainListViewAdapter(Context context, ArrayList<Telclass> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
       ViewHolder holder;
        if (convertView==null){
            holder=new ViewHolder();
            convertView= LayoutInflater.from(context).inflate(R.layout.main_item_lv,parent,false);
            holder.idx=(TextView)convertView.findViewById(R.id.idx_item_lv_main);
            holder.name=(TextView)convertView.findViewById(R.id.name_item_lv_main);
            convertView.setTag(holder);
        }else{
            holder=(ViewHolder)convertView.getTag();
        }
        Telclass telclass=list.get(position);
        holder.idx.setText(telclass.getIdx()+"");
        holder.name.setText(telclass.getName());
        return convertView;
    }
    public class ViewHolder{
        TextView name;
        TextView idx;
    }

}
