package c.loveword.framwork.Fragment.Fragments;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import c.loveword.Application.WordApplication;
import c.loveword.framwork.Activity.StudyActivity;
import c.loveword.R;

/**
 * Created by hasee on 2017/4/15.
 */

public class MainFragment extends Fragment implements View.OnClickListener{
    private TextView restNum;
    private TextView wrongNum;
    private View view;
    private ImageView startStudy;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.main_fragment, container, false);
        findViews();
        setListener();
        return view;
    }
    public void findViews(){
        startStudy=(ImageView)view.findViewById(R.id.startStudy);
        restNum=(TextView)view.findViewById(R.id.rest_word_num);
        wrongNum=(TextView)view.findViewById(R.id.wrong_word_num);
    }
    public void setListener(){
        startStudy.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.startStudy:
                Intent intent=new Intent(getActivity(), StudyActivity.class);
                startActivity(intent);
                break;
        }
    }

    @Override
    public void onStart() {
        restNum.setText(String.valueOf(WordApplication.getRestWordNum()));
        wrongNum.setText(String.valueOf(WordApplication.getWrongWordNum()));
        super.onStart();
    }
}
