package c.loveword.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import c.loveword.R;
/**
 * Created by hasee on 2017/5/20.
 */

public class SearchWordAdapter extends BaseAdapter{
    private List<String> wordTranslation;
    private Context context;

    public SearchWordAdapter(Context context,List<String> wordTranslation){
        this.wordTranslation=wordTranslation;
        this.context=context;
    }
    @Override
    public int getCount() {
        return wordTranslation.size();
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
        ViewHolder viewHolder=new ViewHolder();
        if(convertView==null){
            convertView = LayoutInflater.from(context).inflate(R.layout.adapter_search, parent, false);
            viewHolder.word=(TextView) convertView.findViewById(R.id.word_translation_detail);
            convertView.setTag(viewHolder);
        }
        else {
            viewHolder=(ViewHolder) convertView.getTag();
        }
        viewHolder.word.setText(wordTranslation.get(position));
        return convertView;
    }
    class ViewHolder{
        TextView word;
    }
}
