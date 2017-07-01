package c.loveword.Application;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import c.loveword.greendao.MyWord;
import c.loveword.greendao.Word;
import greendao.gen.DaoMaster;
import greendao.gen.DaoSession;
import greendao.gen.MyWordDao;
import greendao.gen.WordDao;

/**
 * Created by hasee on 2017/4/17.
 */

public class WordApplication  extends Application{
    private static int learnWord=0;
    private boolean isFirst=true;
    private static int numDate;
    private int numBool;
    private static WordDao wordDao;
    private static MyWordDao myWordDao;
    private static  int restWordNum=40;
    private static int runWord=0;
    private static int wrongWordNum=0;
    private static  String[] wordList= new String[]{"abandon","ability" , "abnormal" , "aboard" , "abroad" , "absence" , "absent" ,
            "absolute" ,
            "absolutely" ,
            "absorb" ,
            "abstract" ,
            "abundant" ,
            "abuse" ,
            "academic" ,
            "academy" ,
            "accelerate" ,
            "acceleration" ,
            "accent" ,
            "badminton" ,
            "baggage" ,
            "bake" ,
            "balance" ,
            "band" ,
            "bang" ,
            "banner" ,
            "bar" ,
            "barber" ,
            "bare" ,
            "bargain" ,
            "bark" ,
            "barn" ,
            "barrel" ,
            "barrier" ,
            "basic" ,
            "basically" ,
            "basin" ,
            "basis" ,
            "bat" ,
            "bath" ,
            "bathe" ,
            "care" ,
            "career" ,
            "careful" ,
            "careless" ,
            "cargo" ,
            "carpenter" ,
            "carpet" ,
            "carriage" ,
            "carrier" ,
            "definition" ,
            "degree" ,
            "delay" ,
            "delete" ,
            "delegation" ,
            "delicate" ,
            "delicious" ,
            "delight" ,
            "deliver" ,
            "delivery" ,
            "demand" ,
            "democracy" ,
            "democratic" ,
            "demonstrate" ,
            "dense" ,
            "density" ,
            "entertain" ,
            "enthusiasm" ,
            "enthusiastic" ,
            "entire" ,
            "entitle" ,
            "entrance" ,
            "entry" ,
            "envelope" ,
            "envy" ,
            "equal" ,
            "equality" ,
            "final" ,
            "finally" ,
            "finance" ,
            "financial" ,
            "find" ,
            "finding" ,
            "fine" ,
            "finger" ,
            "finish" ,
            "fireman" ,
            "firm" ,
            "first" ,
            "fish" ,
            "fisherman" ,
            "glow" ,
            "glue" ,
            "goal" ,
            "golf" ,
            "goodness" ,
            "goods" ,
            "goose" ,
            "govern" ,
            "government" ,
            "governor" ,
            "gown" ,
            "hurry" ,
            "hurt" ,
            "husband" ,
            "hut" ,
            "hydrogen" ,
            "ice-cream" ,
            "ideal",
            "identical" ,
            "identify" ,
            "idiom"};

    public static void setLearnWord(){
        learnWord++;
    }
    public static int getLearnWord(){
        return learnWord;
    }
    public static void setRest(){
        restWordNum--;
        if(restWordNum<0){
            restWordNum=0;
        }
    }
    public static int getRestWordNum(){
        return restWordNum;
    }
    public static int getRunWord(){
        return runWord;
    }
    public static void setRunWord(int num){
        runWord=num;
    }
    public static String[] getWordList(){
        return wordList;
    }

    public static int getWrongWordNum(){             //当天错误的单词总数
        return wrongWordNum;
    }
    public static void setWrongWordNum(){
        wrongWordNum++;
    }
    @Override
    public void onCreate() {
        super.onCreate();
        init();
        getShare();
    }

    private void init() {
        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(getApplicationContext(), "LoveWorld-db", null);
        DaoMaster daoMaster = new DaoMaster(devOpenHelper.getWritableDatabase());
        DaoSession daoSession = daoMaster.newSession();
        wordDao=daoSession.getWordDao();
        myWordDao=daoSession.getMyWordDao();
    }
    private void getShare(){
        SharedPreferences sharedPreferences = getSharedPreferences("num", Context.MODE_PRIVATE);
        wrongWordNum=sharedPreferences.getInt("wrongWordNum",0);
        restWordNum=sharedPreferences.getInt("restNum",40);
        numBool=sharedPreferences.getInt("isFirst",-1);
        learnWord=sharedPreferences.getInt("learnWord",learnWord);
        SimpleDateFormat sDateFormat    =   new    SimpleDateFormat("yyyy-MM-dd");
        String    date    =    sDateFormat.format(new    java.util.Date());
        if(numBool==-1){
            Log.e("date",date);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("date",date);
            editor.putInt("isFirst",0);
            editor.commit();
        }
        if(!sharedPreferences.getString("date","").equals(date)){
            restWordNum=40;
        }
    }

    public  static WordDao getWordDao(){
        return wordDao;
    }
    public static MyWordDao getMyWordDao(){
        return myWordDao;
    }
}
