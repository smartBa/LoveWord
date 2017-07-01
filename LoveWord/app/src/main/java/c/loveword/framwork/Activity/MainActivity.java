package c.loveword.framwork.Activity;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import c.loveword.framwork.Fragment.Fragments.DiscoveryFragment;
import c.loveword.framwork.Fragment.Fragments.MainFragment;
import c.loveword.framwork.Fragment.Fragments.MyFragment;
import c.loveword.R;

public class MainActivity extends BaseActivity implements View.OnClickListener{
    private RelativeLayout search;
    private long clickFirstTime;                            //记录首次点击的时间
    private TextView discovery;
    private TextView my;
    private TextView main;
    private ImageView disPicture;
    private ImageView myPicture;
    private ImageView mainPicture;
    private int choosePlate=1;
    private LinearLayout disLinearLayout;
    private LinearLayout mainLinearLayout;
    private LinearLayout myLinearLayout;
    private android.app.FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setFragment();
        init();
        setListener();
    }



    @Override
    protected void onStart() {
        super.onStart();
        if(choosePlate==1) {
            Resources resource =  getBaseContext().getResources();
            ColorStateList csl = resource.getColorStateList(R.color.colorBlue);
            main.setTextColor(csl);
            mainPicture.setImageResource(R.drawable.home_click);
        }
    }
@Override
    public void init(){
        search=(RelativeLayout)findViewById(R.id.search_tool);
        mainLinearLayout=(LinearLayout)findViewById(R.id.about_main);
        myLinearLayout=(LinearLayout)findViewById(R.id.about_my);
        disLinearLayout=(LinearLayout)findViewById(R.id.about_discovery);
        my=(TextView)findViewById(R.id.my_text);
        myPicture=(ImageView)findViewById(R.id.my_picture);
        mainPicture=(ImageView)findViewById(R.id.main_picture);
        disPicture=(ImageView)findViewById(R.id.main_discovery);
        discovery=(TextView)findViewById(R.id.discovery_text);
        main=(TextView)findViewById(R.id.main_text);
    }
    public  void setFragment(){
        fragmentManager=getFragmentManager();
        fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.main_fragment,new MainFragment());
        fragmentTransaction.commit();
    }

    @Override
    public void setListener(){
        mainLinearLayout.setOnClickListener(this);
        myLinearLayout.setOnClickListener(this);
        disLinearLayout.setOnClickListener(this);
        search.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.about_main:
                if(choosePlate==2||choosePlate==3) {
                    fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                    fragmentTransaction.replace(R.id.main_fragment, new MainFragment());
                    fragmentTransaction.commit();
                    choosePlate=1;
                    Resources resource =  getBaseContext().getResources();
                    ColorStateList csl =  resource.getColorStateList(R.color.colorBlue);
                    main.setTextColor(csl);
                    mainPicture.setImageResource(R.drawable.home_click);
                    csl =  resource.getColorStateList(R.color.colorWord);
                    my.setTextColor(csl);
                    discovery.setTextColor(csl);
                    myPicture.setImageResource(R.drawable.my);
                    disPicture.setImageResource(R.drawable.discovery_new);
                }
                break;
            case R.id.about_my:
                if(choosePlate==1||choosePlate==2) {
                    fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                    fragmentTransaction.replace(R.id.main_fragment, new MyFragment());
                    fragmentTransaction.commit();
                    choosePlate=3;
                    Resources resource =  getBaseContext().getResources();
                    ColorStateList csl =  resource.getColorStateList(R.color.colorBlue);
                    my.setTextColor(csl);
                    myPicture.setImageResource(R.drawable.my_click);
                    csl =  resource.getColorStateList(R.color.colorWord);
                    main.setTextColor(csl);
                    discovery.setTextColor(csl);
                    mainPicture.setImageResource(R.drawable.home);
                    disPicture.setImageResource(R.drawable.discovery_new);
                }
                break;
            case R.id.about_discovery:
                if(choosePlate==1||choosePlate==3) {
                    fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                    fragmentTransaction.replace(R.id.main_fragment, new DiscoveryFragment());
                    fragmentTransaction.commit();
                    choosePlate=2;
                    Resources resource =  getBaseContext().getResources();
                    ColorStateList csl =  resource.getColorStateList(R.color.colorBlue);
                    discovery.setTextColor(csl);
                    disPicture.setImageResource(R.drawable.discovery_new_blue);
                    csl =  resource.getColorStateList(R.color.colorWord);
                    main.setTextColor(csl);
                    my.setTextColor(csl);
                    mainPicture.setImageResource(R.drawable.home);
                    myPicture.setImageResource(R.drawable.discovery_new);
                }
                break;
            case R.id.search_tool:
                Intent intent=new Intent(this,SearchActivity.class);
                startActivity(intent);
        }
    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
        long clickSecondTime = System.currentTimeMillis();
        if(clickSecondTime-clickFirstTime>=2000){
            Toast.makeText(this,getResources().getText(R.string.exit),Toast.LENGTH_SHORT).show();
            clickFirstTime=clickSecondTime;
        }
        else {
            finish();
        }
    }
}
