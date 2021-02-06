package com.UOWM.UOWM;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Bohtheia extends Fragment {
    Spinner help;


    @Nullable
    @Override

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_bohtheia, container, false);

        help =(Spinner)v.findViewById(R.id.spinnerepiloges);


        String[] Entoles = new String[]{
                "Επίλεξε Εντολή",
                "Προγράμματα",
                "Email Εκπαιδευτικών",
                "Εστιατόριο Φοιτητών",
                "Επικοινωνία",
                "Πληροφορίες ΚΤΕΛ",
                "Χρήσιμες Διευθύνσεις",
                "Χρήσιμα Εντυπα",
                "Πρακτική Ασκηση"

        };


        final List<String> Helpentoles = new ArrayList<>(Arrays.asList(Entoles));


        final ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(
                v.getContext(),R.layout.spinner_item,Helpentoles){
            @Override
            public boolean isEnabled(int position){
                if(position == 0)
                {

                    return false;
                }
                else
                {
                    return true;
                }

            }
            @Override
            public View getDropDownView(int position, View convertView,
                                        ViewGroup parent) {
                View view = super.getDropDownView(position, convertView, parent);
                TextView tv = (TextView) view;
                if(position == 0){
                    tv.setTextColor(Color.GRAY);
                }
                else {
                }
                return view;
            }
        };
        spinnerArrayAdapter.setDropDownViewResource(R.layout.spinner_item3);
        help.setAdapter(spinnerArrayAdapter);


        help.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long arg3) {

                if (position == 0){

                }

                else if (position ==1 ){
                    AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                    builder.setCancelable(true);
                    builder.setTitle("Προγράμματα");
                    builder.setMessage("Στο μενού προγράμματα μπορείτε να δημιουργήσετε το πρόγραμμα μαθημάτων και το πρόγραμμα εξεταστικής προσαρμοσμένο στις ανάγκες σας.");
                    builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                        }

                    });

                    AlertDialog dialog = builder.create();
                    dialog.show();
                }

                else if (position ==2 ){
                    {
                        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                        builder.setCancelable(true);
                        builder.setTitle("Email Εκπαιδευτικών");
                        builder.setMessage("Στο μενού Email Εκπαιδευτικών υπάρχουν τα email των εκπαιδευτικών. Mπορείτε να πατήσετε πάνω στο email του καθηγήτη που αναζειτείτε  ώστε να του στείλετε απευθείας email");
                        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                            }

                        });

                        AlertDialog dialog = builder.create();
                        dialog.show();
                    }

                }
                else if (position ==3)
                {
                    {
                        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                        builder.setCancelable(true);
                        builder.setTitle("Εστιατόριο Φοιτητών");
                        builder.setMessage("Στο μενού αυτό υπάρχει το μενού των 4 εβδομάδων και το ωράριο του εστιατορίου των φοιτητών.Μπορείτε να πατήσετε στην εικόνα του εστιατορίου ώστε να δείτε το εστιατόριο στον χάρτη");
                        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                            }

                        });

                        AlertDialog dialog = builder.create();
                        dialog.show();
                    }
                }
                else if (position ==4 ){
                    {
                        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                        builder.setCancelable(true);
                        builder.setTitle("Επικοινωνία");
                        builder.setMessage("Στο μενού αυτό υπάρχουν τα διαθέσιμα μέσα επικοινωνίας του τμήματος");
                        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                            }

                        });

                        AlertDialog dialog = builder.create();
                        dialog.show();
                    }

                }
                else if (position == 5)
                {
                    {
                        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                        builder.setCancelable(true);
                        builder.setTitle("Πληροφορίες ΚΤΕΛ");
                        builder.setMessage("Στο μενού αυτό μπορείτε να δείτε πληροφορίες σχετικά με το ΚΤΕΛ,τα δρομολόγια και τις στάσεις των αστικών λεωφορείων. \n Μπορείτε να πατήσετε στην εικόνα των στάσεων ώστε να μεταβείτε στην εφαρμογή του χάρτη.");
                        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                            }

                        });

                        AlertDialog dialog = builder.create();
                        dialog.show();
                    }

                }
                else if (position == 6)
                {
                    {
                        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                        builder.setCancelable(true);
                        builder.setTitle("Χρήσιμες Διευθύνσεις");
                        builder.setMessage("Στο μενού αυτό μπορείτε να πατήσετε στα υπάρχοντα εικονίδια ώστε να ανακατευθύνθηκε στην αντίστοιχη σελίδα");
                        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                            }

                        });

                        AlertDialog dialog = builder.create();
                        dialog.show();
                    }

                }
                else if (position == 7)
                {
                    {
                        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                        builder.setCancelable(true);
                        builder.setTitle("Χρήσιμα Έντυπα");
                        builder.setMessage("Στο μενού αυτό μπορείτε να κατεβάσετε χρήσιμα έντυπα");
                        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                            }

                        });

                        AlertDialog dialog = builder.create();
                        dialog.show();
                    }

                }
                else if (position == 8)
                {
                    {
                        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                        builder.setCancelable(true);
                        builder.setTitle("Πρακτική Ασκηση");
                        builder.setMessage("Στο μενού αυτό μπορείτε να βρείτε πληροφορίες που αφορούν στην πρακτική άσκηση");
                        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                            }

                        });

                        AlertDialog dialog = builder.create();
                        dialog.show();
                    }

                }
            }{

            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });




        return v;


    }
    @Override
    public void onResume() {
        super.onResume();

        ((MainActivity) getActivity())
                .setActionBarTitle("Βοήθεια Εντολών");
    }

}