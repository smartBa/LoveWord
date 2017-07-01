package c.loveword.util;

import java.util.Stack;

import c.loveword.framwork.Activity.BaseActivity;

/**
 * Created by hasee on 2017/5/17.
 */

public class ActivityManager {
    private static Stack<BaseActivity> mActivityStack;          //app寨
    private static ActivityManager mInstance;                   //对自身的持有
    public static ActivityManager  getActivityManager(){
        if(mInstance==null) {
            mInstance=new ActivityManager();
        }
        return mInstance;
    }
    public  void pushActivity(BaseActivity activity){
        if (mActivityStack==null){
            mActivityStack=new Stack<>();
        }
        mActivityStack.push(activity);
    }
    public  BaseActivity peekActivity(){
        if(!mActivityStack.isEmpty()){
            return mActivityStack.peek();
        }
        else {
             return  null;
        }
    }
    public  void popActivity(){
        if(!mActivityStack.isEmpty()){
            mActivityStack.pop();
        }
        if (mActivityStack != null && mActivityStack.isEmpty()) {
            mInstance = null;
        }
    }
}
