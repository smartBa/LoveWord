package c.loveword.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import c.loveword.R;
import c.loveword.greendao.Word;

/**
 * Created by hasee on 2017/6/8.
 */

public class WrongWordAdapter extends BaseAdapter{
    private Context context;
    private List<Word> words;
    public WrongWordAdapter(Context context, List<Word> words){
        this.context=context;
        this.words=words;
    }
    @Override
    public int getCount() {
        return words.size();
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
        WrongWordAdapter.ViewHolder viewHolder=new WrongWordAdapter.ViewHolder();
        if(convertView==null){
            convertView = LayoutInflater.from(context).inflate(R.layout.wrong_adapter, parent, false);
            viewHolder.name=(TextView) convertView.findViewById(R.id.name);
            viewHolder.voice=(TextView) convertView.findViewById(R.id.voice);
            viewHolder.explain=(TextView) convertView.findViewById(R.id.explain);
            convertView.setTag(viewHolder);
        }
        else {
            viewHolder=(WrongWordAdapter.ViewHolder) convertView.getTag();
        }
        viewHolder.name.setText(words.get(position).getName());
        viewHolder.voice.setText(words.get(position).getVoice());
        viewHolder.explain.setText(words.get(position).getExplain());
        return convertView;
    }
    class ViewHolder{
        TextView name;
        TextView voice;
        TextView explain;
    }
}
