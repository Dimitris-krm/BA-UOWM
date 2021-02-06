package com.UOWM.UOWM;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Lesxh_Plhrofories_Fragment extends Fragment {
    ImageView lesxh;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_lesxh_plhrofories, container, false);
         lesxh =(ImageView)v.findViewById(R.id.lesxh);



         lesxh.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                 builder.setCancelable(true);
                 builder.setTitle("");
                 builder.setMessage("Θέλετε να μεταβείτε στην εφαρμογή του χάρτη?");
                 builder.setNegativeButton("Οχι", new DialogInterface.OnClickListener() {
                     @Override
                     public void onClick(DialogInterface dialog, int which) {
                     }
                 });
                 builder.setPositiveButton("Ναι",
                         new DialogInterface.OnClickListener() {
                             @Override
                             public void onClick(DialogInterface dialog, int which) {
                                 Uri gmmIntentUri = Uri.parse("geo:0,0?q=Φοιτητική Εστία, Georgiou Mpousiou, Grevena");
                                 Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                                 mapIntent.setPackage("com.google.android.apps.maps");
                                 startActivity(mapIntent);

                             }
                         });

                 AlertDialog dialog = builder.create();
                 dialog.show();

             }
         });





        return v;

    }


}
