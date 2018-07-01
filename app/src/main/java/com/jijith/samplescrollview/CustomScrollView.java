package com.jijith.samplescrollview;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.ScrollView;

public class CustomScrollView extends ScrollView implements ScrollView.OnScrollChangeListener {

    private Context context;
    private RelativeLayout layout;
    private Button btnTop;
    private Button btnBottom;
    CustomLayout customLayout;
    ScrollView scrollView;

    public CustomScrollView(Context context) {
        super(context);
        this.context = context;
    }

    public CustomScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public CustomScrollView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();

//        LayoutInflater layoutInflater =
//        View view = LayoutInflater.from(getContext()).inflate(R.layout.scrollview_button, null);
//        layout = view.findViewById(R.id.layout_btn_sv);
//        Button btnTop = view.findViewById(R.id.btnTop);
//        Button btnBottom = view.findViewById(R.id.btnBottom);
//        addView(layout);
//        setScrollView();
    }

    @Override
    public void onScrollChange(View view, int i, int i1, int i2, int i3) {

    }


    private void setScrollView() {
        int height = getMaxScrollAmount();
        Log.e("MAx Scroll", "" + height);
        if(height == 0)
            layout.setVisibility(GONE);
    }
}
