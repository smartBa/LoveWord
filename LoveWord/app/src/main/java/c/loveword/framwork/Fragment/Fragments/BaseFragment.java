package c.loveword.framwork.Fragment.Fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Toast;

import c.loveword.model.interfaces.IBaseFragmentModel;
import c.loveword.model.models.BaseFragmentModel;
import c.loveword.presenter.interfaces.IBaseFragmentPresenter;
import c.loveword.presenter.presenters.BaseFragmentPresenter;

/**
 * Created by hasee on 2017/5/18.
 */

public abstract class BaseFragment<T extends BaseFragmentPresenter & IBaseFragmentPresenter> extends Fragment{
    private Toast toast;
    T mPresenter;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter=getPresenter();
    }
    protected void showToast(String message){
        if (toast == null){
            toast = Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT);
        }else {
            toast.setText(message);
            toast.setDuration(Toast.LENGTH_SHORT);
        }
        toast.show();
    }
    protected abstract T getPresenter();
}
