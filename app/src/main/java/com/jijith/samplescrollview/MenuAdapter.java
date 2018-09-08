/* Copyright(C) 2018 Panasonic Corporation */
/*
 * File Name: MenuAdapter.java
 * Date: Sep 07, 2018
 */

package com.jijith.samplescrollview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.panasonic.automotive.alexa.hmi.view.commonui.AlexaCommonListAdapter;

import java.util.List;

/**
 * Adapter class to inflate the menu list items.
 */
public class MenuAdapter extends AlexaCommonListAdapter {

    /**
     * Menu items.
     */
    private List<String> mMenuItems;

    /**
     * Constructor.
     *
     * @param context current context.
     * @param list    items to inflate in the list.
     */
    public MenuAdapter(Context context, List<String> list) {
        super(context, list);
        this.mMenuItems = list;
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

        MenuHolder menuHolder;

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext())
                    .inflate(R.layout.item_menu, parent, false);
            menuHolder = new MenuHolder(convertView);
            convertView.setTag(menuHolder);
        } else {
            menuHolder = (MenuHolder) convertView.getTag();
        }

        menuHolder.tvMenuItem.setText(mMenuItems.get(position));

        return convertView;
    }

    /**
     * Method to get the lit items count.
     *
     * @return count of the list item.
     */
    @Override
    public int getCount() {
        return mMenuItems.size();
    }

    /**
     * The type Menu holder.
     */
    private class MenuHolder {

        /**
         * The Tv menu item.
         */
        TextView tvMenuItem;

        /**
         * Instantiates a new Menu holder.
         *
         * @param itemView the item view
         */
        MenuHolder(View itemView) {
            tvMenuItem = itemView.findViewById(R.id.tvMenuItem);
        }
    }
}
