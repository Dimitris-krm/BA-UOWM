package com.UOWM.UOWM.ui.main;

import android.content.Context;

import com.UOWM.UOWM.R;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapterDTE extends FragmentPagerAdapter {

    @StringRes
    private static final int[] TAB_TITLES = new int[]{R.string.tab_text_1, R.string.tab_text_2,R.string.tab_text_3,R.string.tab_text_4,R.string.tab_text_5};
    private final Context mContext;

    public SectionsPagerAdapterDTE(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position)
    {
        case 0:
            fragment = new DeuteraDTE();
            break;
        case 1:
            fragment = new TrithDTE();
            break;
        case 2:
            fragment = new TetarthDTE();
            break;
        case 3:
            fragment = new PempthDTE();
            break;
        case 4:
            fragment = new ParaskeuhDTE();
            break;

    }
return fragment;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mContext.getResources().getString(TAB_TITLES[position]);
    }

    @Override
    public int getCount() {
        // Show 2 total pages.
        return 5;
    }
}