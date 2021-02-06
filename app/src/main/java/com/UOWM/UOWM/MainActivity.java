package com.UOWM.UOWM;

import android.Manifest;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener  {

    private DrawerLayout mDrawerlayout;
    private ActionBarDrawerToggle mToggle;



    private static final int REQUEST_WRITE_STORAGE_REQUEST_CODE = 123 ;
     TextView textjsoup;


    private NotificationManagerCompat notificationmanager;
    SharedPreferences savedFields;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDrawerlayout = (DrawerLayout) findViewById(R.id.drawer);
        mToggle = new ActionBarDrawerToggle(this, mDrawerlayout, R.string.Open, R.string.Close);
        mDrawerlayout.addDrawerListener(mToggle);
        mToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);



        NavigationView navigationView = (NavigationView) findViewById(R.id.nagivationview);
        navigationView.setNavigationItemSelectedListener(this);


        textjsoup = (TextView) findViewById(R.id.textJSOUP);

        notificationmanager = NotificationManagerCompat.from(this);

        savedFields = getSharedPreferences("info", MODE_PRIVATE);

        // In case no value is already saved, use a Default Value


        /* new doit().execute(); */



        String notificationIntent = getIntent().getStringExtra("NOTIFICATION");

        if (notificationIntent != null) {
            if (notificationIntent.equals("notify")) {
                getSupportFragmentManager().beginTransaction().replace(R.id.Fragmenet_container, new Anak_Fragment()).addToBackStack("null").commit();
            }
        } else {
            if (savedInstanceState == null) {
                getSupportFragmentManager().beginTransaction().replace(R.id.Fragmenet_container, new Arxikh_Fragment()).commit();
            }

        }

        requestAppPermissions();

        new doit().execute();





    }


    public void scheduleJob() {
        ComponentName componentName = new ComponentName(this, Asyncjob.class);
        JobInfo info = new JobInfo.Builder(123, componentName)
                .setRequiredNetworkType(JobInfo.NETWORK_TYPE_ANY)
                .setPersisted(true)
                .setPeriodic(15 * 60 * 1000)
                .build();

        JobScheduler scheduler = (JobScheduler) getSystemService(JOB_SCHEDULER_SERVICE);
        scheduler.schedule(info);


    }


    private void requestAppPermissions() {


        if (hasReadPermissions() && hasWritePermissions()) {
            return;
        }

        ActivityCompat.requestPermissions(this,
                new String[] {
                        Manifest.permission.READ_EXTERNAL_STORAGE,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE
                }, REQUEST_WRITE_STORAGE_REQUEST_CODE);
    }

    private boolean hasReadPermissions() {
        return (ContextCompat.checkSelfPermission(getBaseContext(), Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED);
    }

    private boolean hasWritePermissions() {
        return (ContextCompat.checkSelfPermission(getBaseContext(), Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED);
    }








    public class doit extends AsyncTask<Void,Void,Void> {
        String desct;
        @Override
        protected Void doInBackground(Void... voids) {

            try {
                Document doc = Jsoup.connect("https://ba.uowm.gr/anakoinoseis").get();
                Element main = doc.select("h2[class=entry-title]").get(1);
                desct = main.text();
            }
            catch (Exception e){e.printStackTrace();}

            return null;
        }
        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            ;
            textjsoup.setText(desct);
            Log.d("test", "doit");
            scheduleJob();
        }}












    @Override
    public  void onBackPressed() {
        {
            if (mDrawerlayout.isDrawerOpen(GravityCompat.START)) {
                mDrawerlayout.closeDrawer(GravityCompat.START);
            } else {
                super.onBackPressed();
            }
        }
        
    }




    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (mToggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
             switch (item.getItemId()){
                 case R.id.arxikh:
                     getSupportFragmentManager().beginTransaction().replace(R.id.Fragmenet_container,new Arxikh_Fragment()).addToBackStack("null").commit();
                     break;
                 case R.id.anakoinwseis:
                     getSupportFragmentManager().beginTransaction().replace(R.id.Fragmenet_container,new Anak_Fragment()).addToBackStack("null").commit();
                     break;
                 case R.id.programmalesxhs:
                     getSupportFragmentManager().beginTransaction().replace(R.id.Fragmenet_container,new Lesxh_Fragment()).addToBackStack("null").commit();
                     break;
                 case R.id.programmamath:
                     getSupportFragmentManager().beginTransaction().replace(R.id.Fragmenet_container,new Programmata_Fragment()).addToBackStack("null").commit();
                     break;
                 case R.id.plhroforieskath:
                     getSupportFragmentManager().beginTransaction().replace(R.id.Fragmenet_container,new Proswpiko_fragment()).addToBackStack("null").commit();
                     break;
                 case R.id.epikoinwnia:
                     getSupportFragmentManager().beginTransaction().replace(R.id.Fragmenet_container,new epikoinwnia_Fragment()).addToBackStack("null").commit();
                     break;
                 case R.id.KTEL:
                     getSupportFragmentManager().beginTransaction().replace(R.id.Fragmenet_container,new KTEL_Fragment()).addToBackStack("null").commit();
                     break;
                 case R.id.Efarmogh:
                     getSupportFragmentManager().beginTransaction().replace(R.id.Fragmenet_container,new Efarmogh_Fragment()).addToBackStack("null").commit();
                     break;
                 case R.id.Bohtheia:
                     getSupportFragmentManager().beginTransaction().replace(R.id.Fragmenet_container,new Bohtheia()).addToBackStack("null").commit();
                     break;
                 case R.id.Links:
                     getSupportFragmentManager().beginTransaction().replace(R.id.Fragmenet_container,new Links_fragment()).addToBackStack("null").commit();
                     break;
                 case R.id.entupa:
                     getSupportFragmentManager().beginTransaction().replace(R.id.Fragmenet_container,new Entupa_Fragment()).addToBackStack("null").commit();
                     break;
                 case R.id.praktikh:
                     getSupportFragmentManager().beginTransaction().replace(R.id.Fragmenet_container,new Praktikh_Fragment()).addToBackStack("null").commit();
                     break;
             }

       mDrawerlayout.closeDrawer(GravityCompat.START);
        return true;
    }

    public void setActionBarTitle(String title) {
        getSupportActionBar().setTitle(title);
    }
}
