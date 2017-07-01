package c.loveword.framwork.Fragment.interfaces;

import android.os.Message;

/**
 * Created by hasee on 2017/5/22.
 */

public interface IShowDetailFragment extends IBaseFragment{
    void searchMeaning();
    void meaningReturn(Message message);
}
