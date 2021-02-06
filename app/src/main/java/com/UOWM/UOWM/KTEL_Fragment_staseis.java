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

public class KTEL_Fragment_staseis extends Fragment {
    ImageView stash1;
    ImageView stash2;
    ImageView stash3;
    ImageView stash4;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.staseis_fragment_ktel, container, false);

        stash1 =(ImageView) v.findViewById(R.id.stash1);
        stash2 =(ImageView) v.findViewById(R.id.stash2);
        stash3 =(ImageView) v.findViewById(R.id.stash3);
        stash4 =(ImageView) v.findViewById(R.id.stash4);


        stash1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                builder.setCancelable(true);
                builder.setTitle("Αφετηρία");
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
                                Uri gmmIntentUri = Uri.parse("geo:0,0?q=Grevena KTEL, Grevena");
                                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                                mapIntent.setPackage("com.google.android.apps.maps");
                                startActivity(mapIntent);

                            }
                        });

                AlertDialog dialog = builder.create();
                dialog.show();


            }
        });


        stash2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                builder.setCancelable(true);
                builder.setTitle("Στάση #1");
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
                                Uri gmmIntentUri = Uri.parse("geo:0,0?q=ΚΙΒΩΤΟΣ ΤΩΝ ΓΕΥΣΕΩΝ, Grevena");
                                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                                mapIntent.setPackage("com.google.android.apps.maps");
                                startActivity(mapIntent);

                            }
                        });

                AlertDialog dialog = builder.create();
                dialog.show();


            }
        });


        stash3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                builder.setCancelable(true);
                builder.setTitle("Στάση #2");
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
                                Uri gmmIntentUri = Uri.parse("geo:0,0?q=40°05'06.3\"N 21°26'08.2\"E");
                                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                                mapIntent.setPackage("com.google.android.apps.maps");
                                startActivity(mapIntent);

                            }
                        });

                AlertDialog dialog = builder.create();
                dialog.show();

            }
        });


        stash4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                builder.setCancelable(true);
                builder.setTitle("Στάση #3");
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
                                Uri gmmIntentUri = Uri.parse("geo:0,0?q=40.089670, 21.444459");
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
