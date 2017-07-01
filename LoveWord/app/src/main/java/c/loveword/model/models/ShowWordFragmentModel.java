package c.loveword.model.models;

import android.os.Message;
import android.util.Log;

import com.google.gson.Gson;

import java.io.IOException;

import c.loveword.data.search.RootClass;
import c.loveword.model.interfaces.IShowWordFragmentModel;
import c.loveword.net.NetworkInterfaces;
import c.loveword.presenter.presenters.BaseFragmentPresenter;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * Created by hasee on 2017/5/20.
 */

public class ShowWordFragmentModel extends BaseFragmentModel<BaseFragmentPresenter> implements IShowWordFragmentModel{
    public ShowWordFragmentModel(BaseFragmentPresenter presenter) {
        super(presenter);
    }

    @Override
    public void searchWord(String word) {
        Callback callback=new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Gson gson = new Gson();
                RootClass root = gson.fromJson(response.body().string(), RootClass.class);  //json解析
                Message message=new Message();
                message.what=1;
                message.obj=root;
                presenter.postMessage(message);
                Log.e("123",root.getbasic().getphonetic());
            }
        };
        NetworkInterfaces networkInterfaces=new NetworkInterfaces(word,callback);
        networkInterfaces.sendRequest();
    }
}
