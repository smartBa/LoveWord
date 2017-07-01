package c.loveword.framwork.Fragment.Fragments;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.os.Message;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import c.loveword.Application.WordApplication;
import c.loveword.R;
import c.loveword.data.search.RootClass;
import c.loveword.framwork.Fragment.interfaces.IShowDetailFragment;
import c.loveword.presenter.presenters.ShowDetailFragmentPresenter;
import c.loveword.util.NetWorkHelper;

/**
 * Created by hasee on 2017/4/17.
 */

public class ShowDetailFragment extends BaseFragment<ShowDetailFragmentPresenter> implements View.OnClickListener,IShowDetailFragment{
    private LinearLayout second_line;
    private TextView localFirst;
    private TextView localSecond;
    private TextView outFirst;
    private TextView outSecond;
    private TextView word;
    private TextView wordVoice;
    private TextView first;
    private TextView second;
    private View view;
    private Button button;
    private android.app.FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.word_detail_fragment, container, false);
        findViews();
        searchMeaning();
        setListener();
        if (!NetWorkHelper.isNetworkAvailable(getActivity().getApplicationContext())){
            showToast(getResources().getString(R.string.no_net));
        }
        return view;
    }


    private void setListener() {
        button.setOnClickListener(this);
    }


    public void findViews(){
        button=(Button)view.findViewById(R.id.next_word);
        fragmentManager=getFragmentManager();
        first=(TextView)view.findViewById(R.id.word_first_expression);
        second=(TextView)view.findViewById(R.id.word_second_expression);
        word=(TextView)view.findViewById(R.id.word_name);
        wordVoice=(TextView)view.findViewById(R.id.word_voice);
        localFirst=(TextView)view.findViewById(R.id.first_sentence_in);
        localSecond=(TextView)view.findViewById(R.id.second_sentence_in);
        outFirst=(TextView)view.findViewById(R.id.first_sentence_out);
        outSecond=(TextView)view.findViewById(R.id.second_sentence_out);
        second_line=(LinearLayout)view.findViewById(R.id.second_line);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.next_word:
                WordApplication.setRunWord(WordApplication.getRunWord()+1);
                fragmentTransaction=fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.study_fragment,new ShowWordFragment());
                fragmentTransaction.commit();
                break;

        }
    }

    @Override
    protected ShowDetailFragmentPresenter getPresenter() {
        return new ShowDetailFragmentPresenter(this);
    }

    @Override
    public void searchMeaning() {
        mPresenter.searchWord(WordApplication.getWordList()[WordApplication.getRunWord()]);
    }

    @Override
    public void meaningReturn(Message message) {
        RootClass root=(RootClass) message.obj;
        if(root.geterrorCode()==0)
        {
            first.setText(root.getbasic().getexplains().get(0));
            word.setText(WordApplication.getWordList()[WordApplication.getRunWord()]);
            wordVoice.setText(root.getbasic().getphonetic());
            if(root.getbasic().getexplains().size()>1){
                second.setVisibility(View.VISIBLE);
                second.setText(root.getbasic().getexplains().get(1));
            }
            else {
                second.setVisibility(View.GONE);
            }
            localFirst.setText(root.getweb().get(1).getvalue().get(0));
            outFirst.setText(root.getweb().get(1).getkey());
            if(root.getweb().size()>2){
                second_line.setVisibility(View.VISIBLE);
                localSecond.setText(root.getweb().get(2).getvalue().get(0));
                outSecond.setText(root.getweb().get(2).getkey());
            }
            else {
                second_line.setVisibility(View.GONE);
            }
        }
        else {
            showToast(getResources().getString(R.string.wrong_in));
        }
    }
}
