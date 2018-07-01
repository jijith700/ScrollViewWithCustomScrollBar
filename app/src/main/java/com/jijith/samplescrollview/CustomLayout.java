package com.jijith.samplescrollview;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

public class CustomLayout extends RelativeLayout {

    ScrollView scrollView;
    RelativeLayout relativeLayout;
    Button btnTop;

    public CustomLayout(Context context) {
        super(context);
        initView();
    }

    public CustomLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();

    }

    public CustomLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();

    }

    public CustomLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initView();

    }

    private void initView() {
        LayoutInflater layoutInflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.custom_layout, null, false);
        scrollView = view.findViewById(R.id.sv_top);
        relativeLayout = view.findViewById(R.id.layout_btn_sv);
        btnTop = view.findViewById(R.id.btnTop);
        RelativeLayout layout = view.findViewById(R.id.container);

        View view2 = layoutInflater.inflate(R.layout.item_layout, null, false);
        TextView tvtext = view2.findViewById(R.id.tv_text);

        String s = "";
        for (int i = 0; i < 50; i++) {
            s = s + "a " + i + "\n";
        }

        tvtext.setText(s);
        layout.addView(view2);

        addView(view);

        int childHeight = view2.findViewById(R.id.child).getHeight();
        boolean isScrollable = scrollView.getHeight() < childHeight + scrollView.getPaddingTop() + scrollView.getPaddingBottom();


    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (canScroll(scrollView)) {
                    btnTop.setVisibility(GONE);
                    Log.e("MAx scroll", "scrollable");
                }
            }
        }, 200);


    }

    private boolean canScroll(HorizontalScrollView horizontalScrollView) {
        View child = (View) horizontalScrollView.getChildAt(0);
        if (child != null) {
            int childWidth = (child).getWidth();
            return horizontalScrollView.getWidth() < childWidth + horizontalScrollView.getPaddingLeft() + horizontalScrollView.getPaddingRight();
        }
        return false;

    }

    private boolean canScroll(ScrollView scrollView) {
        View child = (View) scrollView.getChildAt(0);
        if (child != null) {
            int childHeight = (child).getHeight();
            return scrollView.getHeight() < childHeight + scrollView.getPaddingTop() + scrollView.getPaddingBottom();
        }
        return false;
    }
}
