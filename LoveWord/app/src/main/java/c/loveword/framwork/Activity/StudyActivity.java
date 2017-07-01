package c.loveword.framwork.Activity;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import c.loveword.framwork.Fragment.Fragments.ShowWordFragment;
import c.loveword.R;

public class StudyActivity extends BaseActivity implements View.OnClickListener{

    private ImageView backImg;
    private TextView title;
    private android.app.FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_study);
        setFragment();
        init();
        setListener();
    }

    @Override
    protected void init() {
        backImg=(ImageView)findViewById(R.id.back);
        title=(TextView)findViewById(R.id.tool_title);
        title.setText(getResources().getText(R.string.study));
    }

    @Override
    protected void setListener() {
         backImg.setOnClickListener(this);
    }

    public  void setFragment(){
        fragmentManager=getFragmentManager();
        fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.study_fragment,new ShowWordFragment());
        fragmentTransaction.commit();
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
