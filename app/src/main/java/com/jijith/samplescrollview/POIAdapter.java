/* Copyright(C) 2018 Panasonic Corporation */
/*
 * File Name: POIAdapter.java
 * Date: Sep 07, 2018
 */
package com.jijith.samplescrollview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.panasonic.automotive.alexa.hmi.model.holder.cbl.AlexaListItem;
import com.panasonic.automotive.alexa.hmi.view.commonui.AlexaCommonListAdapter;
import com.panasonic.automotive.alexa.utils.AlexaApplication;

import java.util.List;

/**
 * Adapter class to inflate the poi list items.
 */
public class POIAdapter extends AlexaCommonListAdapter {

    /**
     * Menu items.
     */
    private List<AlexaListItem> mAlexaListItems;

    /**
     * Constructor.
     *
     * @param context current context.
     * @param list    items to inflate in the list.
     */
    public POIAdapter(Context context, List<AlexaListItem> list) {
        super(context, list);
        this.mAlexaListItems = list;
    }

    /**
     * Method invoked when the adapter item inflated to the view.
     *
     * @param position    of the list.
     * @param convertView view of the current list item.
     * @param parent      view group to be attached.
     * @return inflated view.
     */
    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        POIHolder poiHolder;

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext())
                    .inflate(R.layout.item_poi, parent, false);
            poiHolder = new POIHolder(convertView);
            convertView.setTag(poiHolder);
        } else {
            poiHolder = (POIHolder) convertView.getTag();
        }

        if (mAlexaListItems != null) {
            poiHolder.tvSlNo.setText(String.valueOf(position + 1));
            poiHolder.tvDistance.setText(mAlexaListItems.get(position).getIndexCount());
            poiHolder.tvItem.setText(mAlexaListItems.get(position).getRightPrimaryTextField());
            poiHolder.tvDetails.setText(mAlexaListItems.get(position).getRightSecondaryTextField());
            if (AlexaApplication.isNaviStatus()) {
                poiHolder.ivNavigation.setVisibility(View.VISIBLE);
            } else {
                poiHolder.ivNavigation.setVisibility(View.GONE);
            }

            poiHolder.ivNavigation.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    /*if (AlexaApplication.isNaviStatus()) {

                    } else {

                    }*/
                }
            });
        }

        return convertView;
    }

    /**
     * Method to get the lit items count.
     *
     * @return count of the list item.
     */
    @Override
    public int getCount() {
        return mAlexaListItems.size();
    }

    /**
     * Inner class to handle the mAlexaListItems items
     */
    private class POIHolder {

        private TextView tvSlNo;
        private TextView tvItem;
        private TextView tvDistance;
        private TextView tvDetails;
        private ImageButton ivNavigation;

        /**
         * Constructor
         *
         * @param view mAlexaListItems item view
         */
        POIHolder(View view) {
            tvSlNo = view.findViewById(R.id.tv_sl_no);
            tvItem = view.findViewById(R.id.tv_item);
            tvDistance = view.findViewById(R.id.tv_distance);
            tvDetails = view.findViewById(R.id.tv_details);
            ivNavigation = view.findViewById(R.id.iv_navigation);
        }
    }
}
