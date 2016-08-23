package zhuoxin.lineng.phonemanger;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by 繁华丶落尽 on 2016/6/14.
 */
public class teladter extends BaseAdapter {
    private Context context;
    private ArrayList<telclassif> list;

    public teladter(Context context, ArrayList<telclassif> list) {
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
       viewHolder holder;
        if (convertView==null){
            holder=new viewHolder();

        convertView= LayoutInflater.from(context).inflate(R.layout.item_tel,parent,false);
        holder.name= (TextView) convertView.findViewById(R.id.tv_tel);
        holder.nunber= (TextView) convertView.findViewById(R.id.lv_tel);
            convertView.setTag(holder);

        }else{
            holder=(viewHolder) convertView.getTag();
        }
        telclassif telclassif=list.get(position);
        holder.name.setText(telclassif.getName());
        holder.nunber.setText(telclassif.getNunber()+"");


        return convertView;
    }
    private class viewHolder{
        TextView name;
        TextView nunber;
    }
}
