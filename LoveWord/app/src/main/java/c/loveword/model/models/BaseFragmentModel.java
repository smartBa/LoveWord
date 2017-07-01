package c.loveword.model.models;

import c.loveword.model.interfaces.IBaseFragmentModel;
import c.loveword.presenter.interfaces.IBaseFragmentPresenter;
import c.loveword.presenter.presenters.BaseFragmentPresenter;

/**
 * Created by hasee on 2017/5/18.
 */

public class BaseFragmentModel<P extends BaseFragmentPresenter&IBaseFragmentPresenter>  implements IBaseFragmentModel {
    P presenter;
    public BaseFragmentModel(P presenter){
         this.presenter=presenter;
    }
}
