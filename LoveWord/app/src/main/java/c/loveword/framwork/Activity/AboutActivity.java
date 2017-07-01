package c.loveword.framwork.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import c.loveword.R;

public class AboutActivity extends AppCompatActivity{
    private TextView textView;
    private ImageView back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        back=(ImageView)findViewById(R.id.back);
        textView=(TextView)findViewById(R.id.tool_title);
        textView.setText(getResources().getString(R.string.about_us));
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
