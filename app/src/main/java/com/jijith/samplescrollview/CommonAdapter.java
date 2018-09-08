/* Copyright(C) 2018 Panasonic Corporation */
/*
 * File Name: CommonAdapter.java
 * Date: Sep 07, 2018
 */

package com.jijith.samplescrollview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.panasonic.automotive.alexa.hmi.model.holder.cbl.AlexaListItem;
import com.panasonic.automotive.alexa.hmi.view.commonui.AlexaCommonListAdapter;

import java.util.List;

/**
 * Common adapter class to inflate the list items.
 */
public class CommonAdapter extends AlexaCommonListAdapter {

    /**
     * variable contains the list items.
     */
    private List<AlexaListItem> mAlexaListItems;

    /**
     * Constructor.
     *
     * @param context current context.
     * @param list    items to inflate in the list.
     */
    public CommonAdapter(Context context, List<AlexaListItem> list) {
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

        CommonHolder commonHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext())
                    .inflate(R.layout.item_to_do, parent, false);
            commonHolder = new CommonHolder(convertView);

            convertView.setTag(commonHolder);
        } else {
            commonHolder = (CommonHolder) convertView.getTag();
        }

        commonHolder.tvSlNo.setText(mAlexaListItems.get(position).getIndexCount());
        commonHolder.tvItem.setText(mAlexaListItems.get(position).getItemName());

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
     * Inner class to handle the list items
     */
    private class CommonHolder {

        private TextView tvSlNo;
        private TextView tvItem;

        CommonHolder(View view) {
            tvSlNo = view.findViewById(R.id.tv_sl_no);
            tvItem = view.findViewById(R.id.tv_to_do_item);
        }
    }
}
