package com.UOWM.UOWM;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Lesxh_Menou_Fragment extends Fragment {

    ImageView bdomada1;
    ImageView bdomada2;
    ImageView bdomada3;
    ImageView bdomada4;

    RadioGroup radioGroup;
    RadioButton rbdomada1;
    RadioButton rbdomada2;
    RadioButton rbdomada3;
    RadioButton rbdomada4;

    TextView text;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_lesxh_menou, container, false);

         radioGroup= (RadioGroup) v.findViewById(R.id.radioGroup);
         rbdomada1 = (RadioButton)v.findViewById(R.id.rbdomada1);
         rbdomada2 = (RadioButton)v.findViewById(R.id.rbdomada2);
         rbdomada3 = (RadioButton)v.findViewById(R.id.rbdomada3);
         rbdomada4 = (RadioButton)v.findViewById(R.id.rbdomada4);


         bdomada1 =(ImageView)v.findViewById(R.id.bdomada1);
         bdomada2 =(ImageView)v.findViewById(R.id.bdomada2);
         bdomada3 =(ImageView)v.findViewById(R.id.bdomada3);
         bdomada4 =(ImageView)v.findViewById(R.id.bdomada4);

         text = (TextView)v.findViewById(R.id.text);


       rbdomada1.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               bdomada1.setVisibility(View.VISIBLE);
               bdomada2.setVisibility(View.INVISIBLE);
               bdomada3.setVisibility(View.INVISIBLE);
               bdomada4.setVisibility(View.INVISIBLE);
               text.setVisibility(View.INVISIBLE);
           }
       });
        rbdomada2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bdomada1.setVisibility(View.INVISIBLE);
                bdomada2.setVisibility(View.VISIBLE);
                bdomada3.setVisibility(View.INVISIBLE);
                bdomada4.setVisibility(View.INVISIBLE);
                text.setVisibility(View.INVISIBLE);
            }
        });

        rbdomada3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bdomada1.setVisibility(View.INVISIBLE);
                bdomada2.setVisibility(View.INVISIBLE);
                bdomada3.setVisibility(View.VISIBLE);
                bdomada4.setVisibility(View.INVISIBLE);
                text.setVisibility(View.INVISIBLE);
            }
        });

        rbdomada4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bdomada1.setVisibility(View.INVISIBLE);
                bdomada2.setVisibility(View.INVISIBLE);
                bdomada3.setVisibility(View.INVISIBLE);
                bdomada4.setVisibility(View.VISIBLE);
                text.setVisibility(View.INVISIBLE);
            }
        });




        return v;

    }


    }

