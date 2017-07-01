package c.loveword.framwork.Activity;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import c.loveword.Application.WordApplication;
import c.loveword.R;

public class MyPathActivity extends AppCompatActivity {

    private TextView textView;
    private ImageView back;
    private TextView usingDay;
    private TextView myWord;
    private TextView learnWord;
    private TextView wrongWord;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_path);
        try {
            init();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        textView=(TextView)findViewById(R.id.tool_title);
        textView.setText(getResources().getString(R.string.my_study));
        back=(ImageView)findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void init() throws ParseException {
        usingDay=(TextView)findViewById(R.id.using_day);
        myWord=(TextView)findViewById(R.id.my_word);
        learnWord=(TextView)findViewById(R.id.learn_word);
        wrongWord=(TextView)findViewById(R.id.wrong_word);
        SimpleDateFormat sDateFormat  = new  SimpleDateFormat("yyyy-MM-dd");
        String   date = sDateFormat.format(new  java.util.Date());
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date dateOne=df.parse(date);
        SharedPreferences sharedPreferences = getSharedPreferences("num", Context.MODE_PRIVATE);
        Date dateTwo=df.parse(sharedPreferences.getString("date",date));
        long time=dateOne.getTime()-dateTwo.getTime()+1;
        usingDay.setText(String.valueOf(time));
        myWord.setText(String.valueOf(WordApplication.getMyWordDao().loadAll().size()));
        learnWord.setText(String.valueOf(WordApplication.getLearnWord()));
        wrongWord.setText(String.valueOf(WordApplication.getWordDao().loadAll().size()));
    }
}
