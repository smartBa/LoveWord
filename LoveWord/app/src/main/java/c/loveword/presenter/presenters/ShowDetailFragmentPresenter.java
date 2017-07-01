package c.loveword.presenter.presenters;

import android.os.Message;

import c.loveword.framwork.Fragment.Fragments.BaseFragment;
import c.loveword.framwork.Fragment.Fragments.ShowDetailFragment;
import c.loveword.model.models.BaseFragmentModel;
import c.loveword.model.models.ShowDetailFragmentModel;
import c.loveword.presenter.interfaces.IBaseFragmentPresenter;
import c.loveword.presenter.interfaces.IShowDetailFragmentPresenter;

/**
 * Created by hasee on 2017/5/22.
 */

public class ShowDetailFragmentPresenter extends BaseFragmentPresenter<ShowDetailFragment,ShowDetailFragmentModel> implements IShowDetailFragmentPresenter{
    public ShowDetailFragmentPresenter(ShowDetailFragment fragment) {
        super(fragment);
    }

    @Override
    public ShowDetailFragmentModel getModel(BaseFragmentPresenter baseFragmentPresenter) {
        return new ShowDetailFragmentModel(this);
    }


    @Override
    public void eventReceive(Message message) {
      fragment.meaningReturn(message);
    }

    @Override
    public void searchWord(String word) {
        model.searchMeaning(word);
    }
}
