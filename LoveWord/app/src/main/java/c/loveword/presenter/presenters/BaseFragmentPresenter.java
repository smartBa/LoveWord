package c.loveword.presenter.presenters;

import android.os.Handler;
import android.os.Message;

import c.loveword.framwork.Fragment.Fragments.BaseFragment;
import c.loveword.framwork.Fragment.interfaces.IBaseFragment;
import c.loveword.model.interfaces.IBaseFragmentModel;
import c.loveword.model.models.BaseFragmentModel;
import c.loveword.presenter.interfaces.IBaseFragmentPresenter;

/**
 * Created by hasee on 2017/5/18.
 */

public abstract class BaseFragmentPresenter <T extends BaseFragment &IBaseFragment,M extends BaseFragmentModel&IBaseFragmentModel>implements IBaseFragmentPresenter {
    T fragment;
    M model;
    private Handler handler;

    public BaseFragmentPresenter(T fragment) {
        this.fragment = fragment;
        model = getModel(this);
        handler=getHandler();
    }
    public abstract M getModel(BaseFragmentPresenter baseFragmentPresenter);
    public abstract void eventReceive(Message message);
    public Handler getHandler(){
        return new MainHandler();
    }
    public void postMessage(Message message){
        handler.sendMessage(message);
    }
    private class MainHandler extends Handler{
        @Override
        public void handleMessage(Message msg) {
            eventReceive(msg);
            super.handleMessage(msg);
        }
    }
}
