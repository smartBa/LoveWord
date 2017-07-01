package c.loveword.framwork.Activity;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import c.loveword.Application.WordApplication;
import c.loveword.util.ActivityManager;

public abstract class BaseActivity extends AppCompatActivity {

    private Toast toast;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityManager.getActivityManager().pushActivity(this);           //将所有的activity压入栈中
    }

    @Override
    protected void onDestroy() {
        SharedPreferences sharedPreferences = getSharedPreferences("num", Context.MODE_PRIVATE); //私有数据
        SharedPreferences.Editor editor = sharedPreferences.edit();//获取编辑器
        editor.putInt("wrongWordNum", WordApplication.getWrongWordNum());
        editor.putInt("restNum",WordApplication.getRestWordNum());
        editor.putInt("learnWord",WordApplication.getLearnWord());
        editor.commit();//提交修改
        super.onDestroy();
        ActivityManager.getActivityManager().popActivity();
    }

    protected void showToast(String message){
        if (toast == null){
            toast = Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT);
        }else {
            toast.setText(message);
            toast.setDuration(Toast.LENGTH_SHORT);
        }
        toast.show();
    }
    protected abstract void  init();
    protected abstract void  setListener();
}
