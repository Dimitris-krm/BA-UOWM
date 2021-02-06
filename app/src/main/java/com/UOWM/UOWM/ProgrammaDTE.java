package com.UOWM.UOWM;

import android.content.Intent;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.provider.CalendarContract;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;

import com.UOWM.UOWM.ui.main.SectionsPagerAdapterDTE;
import com.google.android.material.tabs.TabLayout;

import java.util.Calendar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

public class ProgrammaDTE extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);




        Calendar calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DAY_OF_WEEK);

        setContentView(R.layout.activity_programma_dte);
        SectionsPagerAdapterDTE sectionsPagerAdapter = new SectionsPagerAdapterDTE(this, getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);


        switch (day){

            case Calendar.MONDAY:
                viewPager.setCurrentItem(0);
                break;
            case Calendar.TUESDAY:
                viewPager.setCurrentItem(1);
                break;
            case Calendar.WEDNESDAY:
                viewPager.setCurrentItem(2);
                break;
            case Calendar.THURSDAY:
                viewPager.setCurrentItem(3);
                break;
            case Calendar.FRIDAY:
                viewPager.setCurrentItem(4);
                break;
        }

    }



    public void showPopup(View view) {
        PopupMenu popup = new PopupMenu(this,view);
        popup.setOnMenuItemClickListener(this);
        popup.inflate(R.menu.popupmenu);
        popup.show();
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()){
            case R.id.test1:
                Intent alarmClockIntent = new Intent(AlarmClock.ACTION_SHOW_ALARMS);;
                startActivity(alarmClockIntent);
                return true;
            case R.id.test2:
                Intent intent = new Intent(Intent.ACTION_INSERT);
                intent.setData(CalendarContract.Events.CONTENT_URI);
                startActivity(intent);

                return true;
            default:
                return false;

        }




    }

}