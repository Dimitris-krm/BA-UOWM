package com.UOWM.UOWM;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

public class Proswpiko_fragment extends Fragment {


    @Nullable
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_proswpiko,container, false);
        // Setting ViewPager for each Tabs
        CustomProgrammata viewPager = (CustomProgrammata) view.findViewById(R.id.viewpager);
        setupViewPager(viewPager);


        // Set Tabs inside Toolbar
        TabLayout tabs = (TabLayout) view.findViewById(R.id.result_tabs);
        tabs.setupWithViewPager(viewPager);


        return view;

    }


    // Add Fragments to Tabs
    private void setupViewPager(ViewPager viewPager) {
        Adapter adapter = new Adapter(getChildFragmentManager());
        adapter.addFragment(new Proswpiko_Fragment_Proswpiko(), "Προσωπικό");
        adapter.addFragment(new Proswpiko_Fragment_DEP(), "ΔΕΠ");
        adapter.addFragment(new Proswpiko_Fragment_EDIP(), "ΕΔΙΠ");
        adapter.addFragment(new Proswpiko_Fragment_ETEP(), "ΕΤΕΠ");
        adapter.addFragment(new Proswpiko_Fragment_Dioikhtiko(), "Διοικητό");
        adapter.addFragment(new Proswpiko_Fragment_Ektatoi(), "Έκτατοι");

        viewPager.setAdapter(adapter);

    }

    static class Adapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public Adapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }

    @Override
    public void onResume() {
        super.onResume();

        ((MainActivity) getActivity())
                .setActionBarTitle("Προσωπικό");
    }

}