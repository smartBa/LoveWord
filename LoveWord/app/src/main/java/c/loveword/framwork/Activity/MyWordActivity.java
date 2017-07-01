package c.loveword.framwork.Activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import c.loveword.Application.WordApplication;
import c.loveword.R;
import c.loveword.adapter.MyWordAdapter;

public class MyWordActivity extends BaseActivity implements View.OnClickListener{

    private ListView listView;
    private ImageView imageView;
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_word);
        init();
        setListener();
        setAdapter();
    }

    private void setAdapter() {
        MyWordAdapter myWordAdapter=new MyWordAdapter(this, WordApplication.getMyWordDao().loadAll());
        listView.setAdapter(myWordAdapter);
    }

    @Override
    protected void init() {
        listView=(ListView)findViewById(R.id.my_list);
         imageView=(ImageView)findViewById(R.id.back);
        textView=(TextView)findViewById(R.id.tool_title);
        textView.setText(getResources().getText(R.string.my_word));
    }

    @Override
    protected void setListener() {
         imageView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.back:
                finish();
                break;
        }
    }
}
