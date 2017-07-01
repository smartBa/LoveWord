package c.loveword.framwork.Fragment.Fragments;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.os.Message;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import c.loveword.Application.WordApplication;
import c.loveword.R;
import c.loveword.data.search.RootClass;
import c.loveword.framwork.Fragment.interfaces.IShowWordFragment;
import c.loveword.greendao.Word;
import c.loveword.presenter.presenters.ShowWordFragmentPresenter;
import c.loveword.util.NetWorkHelper;

/**
 * Created by hasee on 2017/4/17.
 */

public class ShowWordFragment extends BaseFragment<ShowWordFragmentPresenter> implements View.OnClickListener, IShowWordFragment {
    private RootClass rootClass;
    private TextView word;
    private TextView phonogram;
    private View view;
    private Button knowButton;
    private Button unKnowButton;
    private android.app.FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.word_show_fragment, container, false);
        findViews();
        searchMeaning();
        setListener();
        if (!NetWorkHelper.isNetworkAvailable(getActivity().getApplicationContext())){
            showToast(getResources().getString(R.string.no_net));
        }
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.word_know:
                WordApplication.setRest();
                WordApplication.setLearnWord();
                fragmentTransaction=fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.study_fragment,new ShowDetailFragment());
                fragmentTransaction.commit();
                break;
            case R.id.word_un_know:
                WordApplication.setRest();
                WordApplication.setLearnWord();
                addWord();
                fragmentTransaction=fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.study_fragment,new ShowDetailFragment());
                fragmentTransaction.commit();
                break;
        }
    }
    public void setListener(){
        knowButton.setOnClickListener(this);
        unKnowButton.setOnClickListener(this);
    }
    public void findViews(){
        word=(TextView)view.findViewById(R.id.word_learn);
        phonogram=(TextView)view.findViewById(R.id.word_phonogram);
        knowButton=(Button)view.findViewById(R.id.word_know);
        unKnowButton=(Button)view.findViewById(R.id.word_un_know);
        fragmentManager=getFragmentManager();
    }

    @Override
    public void searchMeaning() {
        mPresenter.searchWord(WordApplication.getWordList()[WordApplication.getRunWord()]);
    }

    @Override
    public void meaningReturn(Message message) {
        rootClass=(RootClass) message.obj;
        if(rootClass.geterrorCode()==0)
        {
            word.setText(WordApplication.getWordList()[WordApplication.getRunWord()]);
            phonogram.setText(String.valueOf(rootClass.getbasic().getphonetic()));
        }
        else {
            showToast(getResources().getString(R.string.wrong_in));
        }
    }

    @Override
    protected ShowWordFragmentPresenter getPresenter() {
        return new ShowWordFragmentPresenter(this);
    }
    public void addWord(){
        WordApplication.setWrongWordNum();
        List<Word> words=WordApplication.getWordDao().loadAll();
        Word word=new Word((long)WordApplication.getWordDao().loadAll().size(),String.valueOf(WordApplication.getWordList()[WordApplication.getRunWord()]),String.valueOf(rootClass.getbasic().getphonetic()),String.valueOf(rootClass.getbasic().getexplains().get(0)));
        if(words.size()==0){
            WordApplication.getWordDao().insert(word);
        }
        else {
            for(int i=0;i<words.size();i++){
                if(word.getName().equals(words.get(i).getName())){
                    break;
                }
                else if(i==words.size()-1){
                    WordApplication.getWordDao().insert(word);
                    break;
                }
            }
        }

    }
}
