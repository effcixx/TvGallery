package com.example.ewaew.tvgallery;

import android.support.v17.leanback.widget.HeaderItem;

/**
 * Created by Ewa Lyko on 26.05.2018.
 */

public class IconHeaderItem extends HeaderItem {
    public static final int ICON_NONE = -1;
    private int mIconResId = ICON_NONE;

    public IconHeaderItem(long id, String name, int iconResId) {
        super(id, name);
        mIconResId = iconResId;
    }

    public int getIconResId() {
        return mIconResId;
    }

}
