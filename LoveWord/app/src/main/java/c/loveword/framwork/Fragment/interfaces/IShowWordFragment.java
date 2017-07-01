package c.loveword.framwork.Fragment.interfaces;

import android.os.Message;

/**
 * Created by hasee on 2017/5/20.
 */

public interface IShowWordFragment extends IBaseFragment{
    void searchMeaning();
    void meaningReturn(Message message);
}
