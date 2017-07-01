package c.loveword.util;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import c.loveword.R;

/**
 * Created by hasee on 2017/5/16.
 */

public class MainToolBar extends LinearLayout{

    private Context context;
    private View view;
    private ImageView backImage;
    private TextView textView;
    private ImageView imageView;
    public MainToolBar(Context context) {
        super(context);
    }

    public MainToolBar(Context context, AttributeSet attrs) {
        super(context, attrs);
       // this.context=context;
        //initView(context);
    }

    public MainToolBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        //initView(context);
    }
    public void setTitle(String title)
    {
        textView.setText(title);
    }
    public void initView(Context context){
        //view=inflate(context,R.layout.my_toolbar,null);
       view= LayoutInflater.from(context).inflate(R.layout.my_toolbar, this);
        textView=(TextView) view.findViewById(R.id.word_name);
        imageView=(ImageView)view.findViewById(R.id.right_icon);
        backImage=(ImageView)view.findViewById(R.id.back);
        textView.setText("123");
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        //initView(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        initView(context);
        //invalidate();
    }

    public void setIcon(int ID){
        imageView.setImageResource(ID);
    }





}
