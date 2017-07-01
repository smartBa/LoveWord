package c.loveword.net;

import android.support.v4.util.ArrayMap;
import android.util.Log;

import java.io.IOException;
import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by hasee on 2017/5/18.
 */

public class NetworkInterfaces {
    String baseUrl="http://fanyi.youdao.com/openapi.do?keyfrom=loveword10086&key=706188467&type=data&doctype=json&version=1.1&q=";
    String translate;
    private Callback callback;
   public  NetworkInterfaces(String translate,Callback callback){
       this.translate=translate;
       this.callback=callback;
   }
   public void sendRequest(){
       Log.e("12345","send");
       OkHttpClient okHttpClient=new OkHttpClient();
       final Request request = new Request.Builder().url(baseUrl+translate).build();
       okHttpClient.newCall(request).enqueue(callback);
   }

}
