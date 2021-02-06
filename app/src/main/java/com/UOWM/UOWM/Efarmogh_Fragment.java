package com.UOWM.UOWM;

import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Efarmogh_Fragment extends Fragment {
    TextView text;
    TextView text2;



    @Nullable
    @Override

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_efarmogh, container, false);


        text =(TextView)v.findViewById(R.id.textefarmogh);
        text2=(TextView)v.findViewById(R.id.textefarmogh2);


        text.setText(Html.fromHtml("APPLICATION CREATED BY <br> UNDERGRADUATE STUDENT OF UOWM BUSINESS ADMINISTRATION:<br>  <p style='color:red'<b>Dimitrios Karamatskos</p> </b>"));
        text2.setText(Html.fromHtml("<p style='color:red'<b>ΠΡΟΣΟΧΗ</p> </b> <br> 1)Η συγκεκριμένη εφαρμογή δεν αποτελεί σε καμία περίπτωση επίσημη εφαρμογή του τμήματος Διοίκησης επιχειρήσεων. <br>" +
                "2)Η Εφαρμογή δεν παρέχει καμία επιπλέον πληροφόρηση πέρα αυτών που υπάρχουν στην ιστοσελίδα του τμήματος<br>" +
                "3)Ο Δημιουργός της εφαρμογής δεν φέρει καμία ευθύνη για τυχόν λάθη στην πληροφόρηση που παρέχει η εφαρμογή!"));

        return v;


    }
    @Override
    public void onResume() {
        super.onResume();

        ((MainActivity) getActivity())
                .setActionBarTitle("Πληροφορίες Εφαρμογής");
    }

}