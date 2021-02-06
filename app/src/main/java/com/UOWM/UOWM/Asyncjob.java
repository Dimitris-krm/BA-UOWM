package com.UOWM.UOWM;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.util.Log;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import static com.UOWM.UOWM.App.CHANNEL_1;

public class Asyncjob extends JobService {
    SharedPreferences savedFields;
    private NotificationManagerCompat notificationmanager;


    @Override
    public boolean onStartJob(JobParameters params) {
        new doit().execute();


        return true;
    }

    @Override
    public boolean onStopJob(JobParameters params) {
        return false;
    }

    public class doit extends AsyncTask<Void,Void,Void> {


        String desct;
        String compare;


        @Override
        protected Void doInBackground(Void... voids) {

            try {
                Document doc = Jsoup.connect("https://ba.uowm.gr/category/news/").get();
                Element main = doc.select("h2[class=entry-title]").get(0);
                desct = main.text();
            } catch (Exception e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            savedFields = getSharedPreferences("info", MODE_PRIVATE);

            compare = savedFields.getString("Compare", "");


            if (desct.equals(compare)) {
                Log.d("Testing", "SUCCESS");

            }

            else{
                Log.d("Testing", "CompareXD");
                notificationmanager = NotificationManagerCompat.from(getBaseContext());
                String title = "Υπάρχει νέα ανακοίνωση";
                String message = desct;

                Intent anak = new Intent (getBaseContext(), MainActivity.class);
                anak.putExtra("NOTIFICATION", "notify");
                TaskStackBuilder stackBuilder = TaskStackBuilder.create(getBaseContext());
                stackBuilder.addNextIntentWithParentStack(anak);
                PendingIntent anak2 =
                        stackBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);

                Notification notification = new NotificationCompat.Builder(getBaseContext(), CHANNEL_1)
                        .setContentIntent(anak2)
                        .setAutoCancel(true)
                        .setSmallIcon(R.drawable.uowmlogo)
                        .setContentTitle(title)
                        .setColorized(true)
                        .setContentText(message)
                        .setPriority(NotificationCompat.PRIORITY_HIGH)
                        .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                        .build();

                notificationmanager.notify(1, notification);

                SharedPreferences.Editor preferencesEditor = savedFields.edit();
                preferencesEditor.putString("Compare", desct);
                preferencesEditor.apply();


            }
            Log.d("Testing", "jsoupJOB");


        }
    }
}
