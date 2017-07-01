package c.loveword.framwork.Activity;

import android.os.Handler;
import android.os.Message;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TextView;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.List;

import c.loveword.Application.WordApplication;
import c.loveword.R;
import c.loveword.adapter.MyWordAdapter;
import c.loveword.adapter.SearchWordAdapter;
import c.loveword.data.search.RootClass;
import c.loveword.greendao.MyWord;
import c.loveword.net.NetworkInterfaces;
import c.loveword.util.NetWorkHelper;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class SearchActivity extends BaseActivity {

    private RootClass root;
    private Button save;
    private View view;
    private TextView flag;
    private ListView listView;
    private List<String> wordTranslation;
    private SearchWordAdapter searchWordAdapter;
    private TextView word;
    private NetworkInterfaces networkInterfaces;
    private EditText search;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        init();
        setListener();
    }


    @Override
    protected void init() {
        listView=(ListView)findViewById(R.id.word_list);
        search=(EditText)findViewById(R.id.search_search);
        word=(TextView)findViewById(R.id.search_word);
        view=(View)findViewById(R.id.view);
        flag=(TextView)findViewById(R.id.search_result);
        save=(Button)findViewById(R.id.save);
    }

    @Override
    protected void setListener() {
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!search.getText().toString().isEmpty()&&root!=null){
                    MyWord word=new MyWord((long)WordApplication.getMyWordDao().loadAll().size(),search.getText().toString(),root.gettranslation().get(0),root.getbasic().getexplains().get(0));
                    List<MyWord> myWords=WordApplication.getMyWordDao().loadAll();
                    if(myWords.size()==0){
                        WordApplication.getMyWordDao().insert(word);
                        showToast(getResources().getString(R.string.success_s));
                    }
                    else {
                        for(int i=0;i<myWords.size();i++){
                            if(word.getName().equals(myWords.get(i).getName())){
                                showToast(getResources().getString(R.string.second_in));
                                break;
                            }
                            else if(i==myWords.size()-1){
                                WordApplication.getMyWordDao().insert(word);
                                showToast(getResources().getString(R.string.success_s));
                                break;
                            }
                        }
                    }
                }
                else {
                    showToast(getResources().getString(R.string.wrong_in));
                }
            }
        });
        search.setOnEditorActionListener(new EditText.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                view.setVisibility(View.VISIBLE);
                flag.setVisibility(View.VISIBLE);
                if(actionId == EditorInfo.IME_ACTION_SEARCH){
                    try {
                        word.setText(search.getText().toString());
                    }
                    catch (NullPointerException   e){
                        Log.e("error",e.getMessage());
                    }
                    Callback callback=new Callback() {
                        @Override
                        public void onFailure(Call call, IOException e) {
                            showToast(getResources().getString(R.string.net_fail));
                        }
                        @Override
                        public void onResponse(Call call, Response response) throws IOException {
                            Gson gson = new Gson();
                            Message message=new Message();
                            try {
                                root = gson.fromJson(response.body().string(), RootClass.class);  //json解析
                                message.what=0;
                                wordTranslation=root.getbasic().getexplains();
                                message.what=1;
                            }catch (NullPointerException   e){
                               Log.e("error",e.getMessage());
                            }
                            finally {
                                handler.sendMessage(message);
                            }
                        }
                    };
                    if (NetWorkHelper.isNetworkAvailable(getApplicationContext())){
                        if(!search.getText().toString().isEmpty())
                        {
                            try {
                                networkInterfaces = new NetworkInterfaces(search.getText().toString(), callback);
                                networkInterfaces.sendRequest();
                            }
                            catch (Exception   e){
                                Log.e("error",e.getMessage());
                            }
                        }
                        else {
                            showToast(getResources().getString(R.string.empty));
                        }
                    }
                    else {
                        showToast(getResources().getString(R.string.no_net));
                    }
                }
                return false;
            }
        });
    }
    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case 0:
                    showToast(getResources().getString(R.string.wrong_in));
                    root=null;
                    break;
                case 1:
                    searchWordAdapter=new SearchWordAdapter(getApplicationContext(),wordTranslation);
                    listView.setAdapter(searchWordAdapter);
                    break;
            }
            super.handleMessage(msg);
        }
    };
}
