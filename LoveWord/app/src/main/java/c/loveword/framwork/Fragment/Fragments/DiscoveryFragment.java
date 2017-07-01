package c.loveword.framwork.Fragment.Fragments;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import c.loveword.R;
import c.loveword.framwork.Activity.AboutActivity;
import c.loveword.framwork.Activity.MyPathActivity;

/**
 * Created by hasee on 2017/6/12.
 */

public class DiscoveryFragment extends Fragment implements View.OnClickListener{
    private View view;
    private LinearLayout aboutUs;
    private LinearLayout studyPath;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.discovery_fragment, container, false);
        aboutUs=(LinearLayout)view.findViewById(R.id.about_us);
        aboutUs.setOnClickListener(this);
        studyPath=(LinearLayout)view.findViewById(R.id.study_path);
        studyPath.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.about_us){
            Intent intent=new Intent(getActivity(), AboutActivity.class);
            startActivity(intent);
        }
        else if(v.getId()==R.id.study_path){
            Intent intent=new Intent(getActivity(), MyPathActivity.class);
            startActivity(intent);
        }
    }
}
