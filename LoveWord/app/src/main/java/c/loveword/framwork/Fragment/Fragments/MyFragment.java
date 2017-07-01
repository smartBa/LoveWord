package c.loveword.framwork.Fragment.Fragments;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import c.loveword.Application.WordApplication;
import c.loveword.framwork.Activity.MyWordActivity;
import c.loveword.framwork.Activity.WrongActivity;
import c.loveword.R;

/**
 * Created by hasee on 2017/4/16.
 */

public class MyFragment extends Fragment implements View.OnClickListener{
    private View view;
    private LinearLayout wrong;
    private LinearLayout myWord;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.my_fragment, container, false);
        findViews();
        setListener();
        return view;
    }
    public void findViews(){
        wrong=(LinearLayout)view.findViewById(R.id.my_wrong);
        myWord=(LinearLayout)view.findViewById(R.id.my_word);
    }
    public void setListener(){
        wrong.setOnClickListener(this);
        myWord.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent=new Intent();
        switch (v.getId()){
            case R.id.my_wrong:
                intent.setClass(getActivity(), WrongActivity.class);
                startActivity(intent);
                break;
            case R.id.my_word:
                intent.setClass(getActivity(), MyWordActivity.class);
                startActivity(intent);
                break;
        }
    }
}
