package c.loveword.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import c.loveword.R;
import c.loveword.greendao.MyWord;

/**
 * Created by hasee on 2017/6/8.
 */

public class MyWordAdapter extends BaseAdapter{
    private Context context;
    private List<MyWord> myWords;
    public MyWordAdapter(Context context, List<MyWord> myWords){
        this.context=context;
        this.myWords=myWords;
    }
    @Override
    public int getCount() {
        return myWords.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        MyWordAdapter.ViewHolder viewHolder=new MyWordAdapter.ViewHolder();
        if(convertView==null){
            convertView = LayoutInflater.from(context).inflate(R.layout.wrong_adapter, parent, false);
            viewHolder.name=(TextView) convertView.findViewById(R.id.name);
            viewHolder.voice=(TextView) convertView.findViewById(R.id.voice);
            viewHolder.explain=(TextView) convertView.findViewById(R.id.explain);
            convertView.setTag(viewHolder);
        }
        else {
            viewHolder=(MyWordAdapter.ViewHolder) convertView.getTag();
        }
        viewHolder.name.setText(myWords.get(position).getName());
        viewHolder.voice.setText(myWords.get(position).getVoice());
        viewHolder.explain.setText(myWords.get(position).getExplain());
        return convertView;
    }
    class ViewHolder{
        TextView name;
        TextView voice;
        TextView explain;
    }
}
