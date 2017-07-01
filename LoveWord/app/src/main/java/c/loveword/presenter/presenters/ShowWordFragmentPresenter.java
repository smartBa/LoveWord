package c.loveword.presenter.presenters;

import android.os.Message;

import c.loveword.framwork.Fragment.Fragments.BaseFragment;
import c.loveword.framwork.Fragment.Fragments.ShowWordFragment;
import c.loveword.model.models.BaseFragmentModel;
import c.loveword.model.models.ShowWordFragmentModel;
import c.loveword.presenter.interfaces.IBaseFragmentPresenter;
import c.loveword.presenter.interfaces.IShowWordFragmentPresenter;

/**
 * Created by hasee on 2017/5/20.
 */

public class ShowWordFragmentPresenter extends BaseFragmentPresenter<ShowWordFragment,ShowWordFragmentModel> implements IShowWordFragmentPresenter{
    public ShowWordFragmentPresenter(ShowWordFragment fragment) {
        super(fragment);
    }

    @Override
    public ShowWordFragmentModel getModel(BaseFragmentPresenter baseFragmentPresenter) {
        return new ShowWordFragmentModel(this);
    }

    @Override
    public void eventReceive(Message message) {
       fragment.meaningReturn(message);
    }

    @Override
    public void searchWord(String word) {
        model.searchWord(word);
    }
}
