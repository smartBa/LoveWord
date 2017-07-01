package c.loveword.framwork.Activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

import c.loveword.Application.WordApplication;
import c.loveword.R;
import c.loveword.adapter.WrongWordAdapter;
import c.loveword.greendao.Word;

public class WrongActivity extends BaseActivity implements View.OnClickListener{

    private WrongWordAdapter wrongWordAdapter;
    private ListView listView;
    private ImageView backImg;
    private TextView title;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wrong);
        init();
        setListener();
        setList();
    }

    private void setList() {
        wrongWordAdapter=new WrongWordAdapter(this,getWord());
        listView.setAdapter(wrongWordAdapter);
    }

    @Override
    protected void init() {
        listView=(ListView)findViewById(R.id.wrong_list);
        backImg=(ImageView)findViewById(R.id.back);
        title=(TextView)findViewById(R.id.tool_title);
        title.setText(getResources().getText(R.string.wrong));
    }

    @Override
    protected void setListener() {
        backImg.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.back:
                finish();
                break;
        }
    }

    public List<Word> getWord() {
        return WordApplication.getWordDao().loadAll();
    }
}
