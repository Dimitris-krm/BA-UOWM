package com.UOWM.UOWM.ui.main;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.UOWM.UOWM.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class PempthDPS extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.dpspempth, container, false);

        final SharedPreferences savedFields;
        final Button Save;
        final Button edit;
        final FloatingActionButton floatingActionButton;
        final Context mContext = getActivity().getApplicationContext();
        final FloatingActionButton floatingActionButton2;
        floatingActionButton2 =(FloatingActionButton)v.findViewById(R.id.floatingActionButton2);

        Calendar calendar = Calendar.getInstance();
        final int hour = calendar.get(Calendar.HOUR_OF_DAY);
        final int minute = calendar.get(Calendar.MINUTE);


        final TextView TimeApo = (TextView)v.findViewById(R.id.TimeApo);
        final TextView TimeEws = (TextView)v.findViewById(R.id.TimeEws);


        final Spinner spinner = (Spinner) v.findViewById(R.id.spinner);
        final Spinner spinner2 = (Spinner) v.findViewById(R.id.spinner5);
        final Button bt1 = (Button)v.findViewById(R.id.bt1);
        final Button bt2 = (Button)v.findViewById(R.id.bt2);
        final Button bt3 = (Button)v.findViewById(R.id.bt3);
        final Button bt4 = (Button)v.findViewById(R.id.bt4);
        Save = (Button)v.findViewById(R.id.save);
        edit =(Button)v.findViewById(R.id.edit);
        floatingActionButton =(FloatingActionButton)v.findViewById(R.id.floatingActionButton);

        final TextView txt1 = (TextView)v.findViewById(R.id.txt1);
        final TextView txt2 = (TextView)v.findViewById(R.id.txt2);
        final TextView txt3 = (TextView)v.findViewById(R.id.txt3);
        final TextView txt4 = (TextView)v.findViewById(R.id.txt4);


        // "info" is just a tag name, use anything you like
        savedFields = this.getActivity().getSharedPreferences("info", 0);

        // In case no value is already saved, use a Default Value
        txt1.setText(savedFields.getString("Pedps1", " "));
        txt2.setText(savedFields.getString("PEdps2", " "));
        txt3.setText(savedFields.getString("PEdps3", " "));
        txt4.setText(savedFields.getString("PEdps4", " "));


        Save.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("RestrictedApi")
            @Override
            public void onClick(View v) {


                spinner.setVisibility(View.INVISIBLE);
                spinner2.setVisibility(View.INVISIBLE);
                bt1.setVisibility(View.INVISIBLE);
                bt2.setVisibility(View.INVISIBLE);
                bt3.setVisibility(View.INVISIBLE);
                bt4.setVisibility(View.INVISIBLE);
                TimeApo.setVisibility(View.INVISIBLE);
                TimeEws.setVisibility(View.INVISIBLE);
                Save.setVisibility(View.INVISIBLE);
                edit.setVisibility(View.VISIBLE);
                floatingActionButton.setVisibility(View.VISIBLE);
                floatingActionButton2.setVisibility(View.INVISIBLE);

                Toast.makeText(getActivity(),"Έγινε αποθήκευση",Toast.LENGTH_SHORT).show();

                SharedPreferences.Editor preferencesEditor = savedFields.edit();

                preferencesEditor.putString("PEdps1", txt1.getText().toString());
                preferencesEditor.putString("PEdps2", txt2.getText().toString());
                preferencesEditor.putString("PEdps3", txt3.getText().toString());
                preferencesEditor.putString("PEdps4", txt4.getText().toString());

                preferencesEditor.commit();



            }
        });

        floatingActionButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                builder.setCancelable(true);
                builder.setTitle("Βοήθεια");
                builder.setMessage("Μπορείτε να προσαμόρσετε το πρόγραμμα σπουδών ανάλογα με τις ανάγκες σας.\n\nΚατά την δημιουργία προγράμματος, μπορείτε να κάνετε Long press σε μία στήλη για να την διαγράψετε");
                builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }

                });

                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });


        edit.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("RestrictedApi")
            @Override
            public void onClick(View v) {
                spinner.setVisibility(View.VISIBLE);
                spinner2.setVisibility(View.VISIBLE);
                bt1.setVisibility(View.VISIBLE);
                bt2.setVisibility(View.VISIBLE);
                bt3.setVisibility(View.VISIBLE);
                bt4.setVisibility(View.VISIBLE);
                TimeApo.setVisibility(View.VISIBLE);
                TimeEws.setVisibility(View.VISIBLE);
                Save.setVisibility(View.VISIBLE);
                edit.setVisibility(View.INVISIBLE);
                floatingActionButton.setVisibility(View.INVISIBLE);
                floatingActionButton2.setVisibility(View.VISIBLE);

            }
        });



        TimeApo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimePickerDialog timePickerDialog = new TimePickerDialog(v.getContext(), new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        TimeApo.setText(String.format("%02d:%02d", hourOfDay, minute));


                    }
                },hour,minute,android.text.format.DateFormat.is24HourFormat(v.getContext()));
                timePickerDialog.show();
            }
        });

        TimeEws.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimePickerDialog timePickerDialog = new TimePickerDialog(v.getContext(), new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        TimeEws.setText(String.format("%02d:%02d", hourOfDay, minute));


                    }
                },hour,minute,android.text.format.DateFormat.is24HourFormat(v.getContext()));
                timePickerDialog.show();
            }
        });



        String[] Kateuth = new String[]{
                "Επέλεξε Κατεύθυνση",
                "Διοίκηση Επιχειρήσεων Χειμερινό Εξάμηνο",
                "Διοίκηση Επιχειρήσεων Εαρινό Εξάμηνο",
                "Διοίκηση Τουριστικών Επιχειρήσεων Χειμερινό Εξάμηνο",
                "Διοίκηση Τουριστικών Επιχειρήσεων Εαρινό Εξάμηνο",
                "Διοίκηση Πληροφοριακών Συστημάτων Χειμερινό Εξάμηνο",
                "Διοίκηση Πληροφοριακών Συστημάτων Εαρινό Εξάμηνο"

        };


        String[] DE = new String[]{
                "Επέλεξε μάθημα",
                "Πληροφοριακά Συστήματα & Διαδίκτυο",
                "Λογιστική",
                "Μαθηματικά",
                "Μικροοικονομική I",
                "Εισαγωγή στη Στατιστική",
                "Κοινωνιολογία",
                "Πληροφοριακά Συστήματα Διοίκησης - E",
                "Πληροφοριακά Συστήματα Διοίκησης - Θ",
                "Αγγλική Ορολογία Ι",
                "Αγγλική Ορολογία Ι - ΑΠ",
                "Διοίκηση Ανθρωπίνων Πόρων",
                "Ανάλυση Χρηματοοικονομικών Καταστάσεων",
                "Σύγχρονη Οικονομία Βαλκανικών & Παραευξείνιων Χωρών",
                "Διοίκηση Λειτουργιών",
                "Επιχειρηματική Ηθική & Εταιρική Κοινωνική Ευθύνη",
                "Business English",
                "Διοικητική Λογιστική",
                "Οργανωσιακή Συμπεριφορά",
                "Ασφαλίσεις Επιχειρήσεων",
                "Μεθοδολογία έρευνας",
                "Εσωτερικός έλεγχος και ελεγκτική",
                "Επιχειρησιακή Έρευνα",
                "Διεθνείς Οικονομικοί Οργανισμοί",
                "Στρατηγική Επιχειρήσεων",
                "Αξιολόγηση επενδύσεων και αποτίμηση"};

        String[] DE2 = new String[]{
                "Επέλεξε μάθημα",
                "Μικροοικονομική ΙΙ",
                "Εισαγωγή στο Δίκαιο",
                "Εφαρμοσμένη Στατιστική",
                "Εισαγωγή στα Χρηματοοικονομικά Μαθηματικά ",

                "Εισαγωγή στη Διοίκηση Επιχειρήσεων",

                "Εισαγωγή στην Οικονομετρία",
                "Προγραμματισμός Η/Υ",
                "Μακροοικονομική ",
                "Διοίκηση Έργων",
                "Χρηματοοικονομική Διοίκηση",

                "Δίκτυα Υπολογιστών",
                "Ευρωπαϊκή Ένωση: Θεσμοί και Πολιτικές Σύγκλισης",
                "Διοίκηση Ολικής Ποιότητας",
                "Πληροφοριακά Συστήματα Υγείας",
                "Ηλεκτρονική Διακυβέρνηση και Ψηφιακό Χάσμα",
                "Ηλεκτρονικό Μάρκετινγκ",


                "Ασφαλίσεις Επιχειρήσεων",
                "Κλαδική Λογιστική",
                "Εφαρμοσμένη Οικονομετρία",
                "Διαχείριση Εφοδιαστικής Αλυσίδας"};





        String[] DPS = new String[]{
                "Επέλεξε μάθημα",
                "Πληροφοριακά Συστήματα & Διαδίκτυο",
                "Λογιστική",
                "Μαθηματικά",
                "Μικροοικονομική I",
                "Εισαγωγή στη Στατιστική",
                "Κοινωνιολογία",
                "Πληροφοριακά Συστήματα Διοίκησης - E",
                "Πληροφοριακά Συστήματα Διοίκησης - Θ",
                "Αγγλική Ορολογία Ι",
                "Αγγλική Ορολογία Ι - ΑΠ",
                "Διοίκηση Ανθρωπίνων Πόρων",
                "Ανάλυση Χρηματοοικονομικών Καταστάσεων",
                "Αντικειμενοστρεφής Προγραμματισμός - Θ",
                "Αντικειμενοστρεφής Προγραμματισμός - Ε",
                "Ανάπτυξη Διαδικτυακών εφαρμογών Ι - Θ",
                "Ανάπτυξη Διαδικτυακών εφαρμογών Ι - Ε",
                "Βάσεις Δεδομένων Ι - Θ",
                "Βάσεις Δεδομένων Ι - Ε",
                "Υπολογιστική Νέφους",
                "Τεχνολογίες Πολυμέσων",
                "Τεχνολογία Λογισμικού",
                "Δίκτυα Υπολογιστών - Θ",
                "Δίκτυα Υπολογιστών - Ε ",
                "Ανάπτυξη Διαδικτυακών εφαρμογών ΙΙ - Θ",
                "Ανάπτυξη Διαδικτυακών εφαρμογών ΙΙ - Ε",
                "Αλληλεπίδραση Ανθρώπου-Υπολογιστή και Ευχρηστία",
                "Ηλεκτρονικό Εμπόριο",
                "Σεμινάριο Τελειοφοίτων",
                "Συγγραφή Επιστημονικών Εργασιών "};




        String[] DPS2 = new String[]{
                "Επέλεξε μάθημα",

                "Μικροοικονομική ΙΙ",
                "Εισαγωγή στο Δίκαιο",
                "Εφαρμοσμένη Στατιστική",
                "Εισαγωγή στα Χρηματοοικονομικά Μαθηματικά ",
                "Εισαγωγή στη Διοίκηση Επιχειρήσεων",

                "Εισαγωγή στην Οικονομετρία",
                "Προγραμματισμός Η/Υ",
                "Μακροοικονομική ",
                "Διοίκηση Έργων",
                "Χρηματοοικονομική Διοίκηση",

                "Ασφάλεια Πληροφοριακών Συστημάτων",
                "Δίκτυα Υπολογιστών",
                "Προγραμματισμός Κινητών Συσκευών",
                "Δομές Δεδομένων και Αλγόριθμοι ",
                "Πληροφοριακά Συστήματα Υγείας",
                "Βάσεις Δεδομένων ΙΙ ",
                "Ηλεκτρονική Διακυβέρνηση και Ψηφιακό Χάσμα",
                "Ηλεκτρονικό Μάρκετινγκ",


                "Ασφαλίσεις Επιχειρήσεων",
                "Κλαδική Λογιστική",
                "Εφαρμοσμένη Οικονομετρία",
                "Διαχείριση Εφοδιαστικής Αλυσίδας"};




        String[] DTE = new String[]{
                "Επέλεξε μάθημα",
                "Πληροφοριακά Συστήματα & Διαδίκτυο",
                "Λογιστική",
                "Μαθηματικά",
                "Μικροοικονομική I",
                "Εισαγωγή στη Στατιστική",

                "Ανάλυση Χρηματοοικονομικών Καταστάσεων",
                "Αρχές Τουρισμού",
                "Αρχές Τουρισμού-ΑΠ",
                "Αγγλική Ορολογία Ι",
                "Αγγλική Ορολογία Ι - ΑΠ",
                "Διοίκηση Ανθρωπίνων Πόρων",
                "Κοινωνιολογία",


                "Διοίκηση Επισιτισμού ΙΙ - Θ",
                "Διοίκηση Επισιτισμού ΙΙ - Ε",
                "Διοικητική Λογιστική Ξενοδοχειακών Επιχειρήσεων",
                "Ειδικές & Εναλλακτικές Μορφές Τουρισμού",
                "Έρευνα Τουριστικής Αγοράς",
                "Επιχειρηματικά Σχέδια",
                "Οικονομική του Τουρισμού",
                "Οργάνωση και Λειτουργία Ταξ. Βιομηχανίας",
                "Τουριστική Γεωγραφία",


                "Διοίκηση Υπηρεσιών Φιλοξενίας ΙΙ ",
                "Διαχείριση κρίσεων στην τουριστική βιομηχανία",
                "Ξενόγλωσση Τουριστική Ορολογία - Θ",
                "Ξενόγλωσση Τουριστική Ορολογία - ΑΠ",
                "Οινοτουρισμός",
                "Οργάνωση & Διοίκηση Αγροτουριστικών Επιχειρήσεων",
                "Σχεδιασμός και διαχείριση τουριστικών προορισμών"};






        String[] DTE2 = new String[]{
                "Επέλεξε μάθημα",
                "Μικροοικονομική ΙΙ",
                "Εισαγωγή στο Δίκαιο",
                "Εφαρμοσμένη Στατιστική",
                "Εισαγωγή στα Χρηματοοικονομικά Μαθηματικά ",
                "Εισαγωγή στη Στατιστική",
                "Εισαγωγή στη Διοίκηση Επιχειρήσεων",

                "Εισαγωγή στην Οικονομετρία",
                "Προγραμματισμός Η/Υ",
                "Μακροοικονομική ",
                "Διοίκηση Έργων",
                "Χρηματοοικονομική Διοίκηση",

                "Δίκτυα Υπολογιστών",
                "Διοίκηση Ποιότητας στον Τουρισμό",
                "Διοίκηση Επισιτισμού",
                "Πληροφοριακά Συστήματα Υγείας",
                "Ηλεκτρονική Διακυβέρνηση και Ψηφιακό Χάσμα",
                "Ηλεκτρονικό Μάρκετινγκ",
                "Ελληνική Οικονομία",

                "Ασφαλίσεις Επιχειρήσεων",
                "Κλαδική Λογιστική",
                "Εφαρμοσμένη Οικονομετρία",
                "Διαχείριση Εφοδιαστικής Αλυσίδας"};



        final List<String> DEmath = new ArrayList<>(Arrays.asList(DE));

        // Initializing an ArrayAdapter
        final ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(
                v.getContext(),R.layout.spinner_item,DEmath){
            @Override
            public boolean isEnabled(int position){
                if(position == 0)
                {
                    // Disable the first item from Spinner
                    // First item will be use for hint
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
                    // Set the hint text color gray
                    tv.setTextColor(Color.GRAY);
                }
                else {
                    TimeApo.setVisibility(View.VISIBLE);
                }
                return view;
            }
        };




        final List<String> DEmath2 = new ArrayList<>(Arrays.asList(DE2));

        // Initializing an ArrayAdapter
        final ArrayAdapter<String> spinnerArrayAdapter5 = new ArrayAdapter<String>(
                v.getContext(),R.layout.spinner_item,DEmath2){
            @Override
            public boolean isEnabled(int position){
                if(position == 0)
                {
                    // Disable the first item from Spinner
                    // First item will be use for hint
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
                    // Set the hint text color gray
                    tv.setTextColor(Color.GRAY);
                }
                else {
                    TimeApo.setVisibility(View.VISIBLE);
                }
                return view;
            }
        };


        final List<String> Kateuthmath = new ArrayList<>(Arrays.asList(Kateuth));

        // Initializing an ArrayAdapter
        final ArrayAdapter<String> spinnerArrayAdapter2 = new ArrayAdapter<String>(
                v.getContext(),R.layout.spinner_item2,Kateuthmath){
            @Override
            public boolean isEnabled(int position){
                if(position == 0)
                {
                    // Disable the first item from Spinner
                    // First item will be use for hint
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
                    // Set the hint text color gray
                    tv.setTextColor(Color.GRAY);
                }
                else {


                }
                return view;
            }
        };

        final List<String> DPSmath = new ArrayList<>(Arrays.asList(DPS));

        // Initializing an ArrayAdapter
        final ArrayAdapter<String> spinnerArrayAdapter3 = new ArrayAdapter<String>(
                v.getContext(),R.layout.spinner_item2,DPSmath){
            @Override
            public boolean isEnabled(int position){
                if(position == 0)
                {
                    // Disable the first item from Spinner
                    // First item will be use for hint
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
                    // Set the hint text color gray
                    tv.setTextColor(Color.GRAY);
                }
                else {
                    TimeApo.setVisibility(View.VISIBLE);

                }
                return view;
            }
        };



        final List<String> DPSmath2 = new ArrayList<>(Arrays.asList(DPS2));

        // Initializing an ArrayAdapter
        final ArrayAdapter<String> spinnerArrayAdapter6 = new ArrayAdapter<String>(
                v.getContext(),R.layout.spinner_item2,DPSmath2){
            @Override
            public boolean isEnabled(int position){
                if(position == 0)
                {
                    // Disable the first item from Spinner
                    // First item will be use for hint
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
                    // Set the hint text color gray
                    tv.setTextColor(Color.GRAY);
                }
                else {
                    TimeApo.setVisibility(View.VISIBLE);

                }
                return view;
            }
        };



        final List<String> DTEmath = new ArrayList<>(Arrays.asList(DTE));

        // Initializing an ArrayAdapter
        final ArrayAdapter<String> spinnerArrayAdapter4 = new ArrayAdapter<String>(
                v.getContext(),R.layout.spinner_item2,DTEmath){
            @Override
            public boolean isEnabled(int position){
                if(position == 0)
                {
                    // Disable the first item from Spinner
                    // First item will be use for hint
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
                    // Set the hint text color gray
                    tv.setTextColor(Color.GRAY);
                }
                else {
                    TimeApo.setVisibility(View.VISIBLE);

                }
                return view;
            }
        };



        final List<String> DTEmath2 = new ArrayList<>(Arrays.asList(DTE2));

        // Initializing an ArrayAdapter
        final ArrayAdapter<String> spinnerArrayAdapter7 = new ArrayAdapter<String>(
                v.getContext(),R.layout.spinner_item2,DTEmath2){
            @Override
            public boolean isEnabled(int position){
                if(position == 0)
                {
                    // Disable the first item from Spinner
                    // First item will be use for hint
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
                    // Set the hint text color gray
                    tv.setTextColor(Color.GRAY);
                }
                else {
                    TimeApo.setVisibility(View.VISIBLE);

                }
                return view;
            }
        };




        spinnerArrayAdapter.setDropDownViewResource(R.layout.spinner_item);
        spinnerArrayAdapter2.setDropDownViewResource(R.layout.spinner_item);
        spinner.setAdapter(spinnerArrayAdapter);
        spinner2.setAdapter(spinnerArrayAdapter2);


        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long arg3) {

                if (position == 0){
                    spinner.setAdapter(null);
                }

                else if (position ==1 ){
                    spinner.setAdapter(spinnerArrayAdapter);


                }
                else if (position ==2 ){
                    spinner.setAdapter(spinnerArrayAdapter5);

                }
                else if (position ==3)
                {
                    spinner.setAdapter(spinnerArrayAdapter4);
                }
                else if (position ==4 ){
                    spinner.setAdapter(spinnerArrayAdapter7);

                }
                else if (position == 5)
                {
                    spinner.setAdapter(spinnerArrayAdapter3);

                }
                else if (position ==6 ){
                    spinner.setAdapter(spinnerArrayAdapter6);

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(final AdapterView<?> parent, View view, final int position, long id) {
                String selectedItemText = (String) parent.getItemAtPosition(position);
                // If user change the default selection
                // First item is disable and it is used for hint
                if(position > 0){
                    // Notify the selected item text


                    bt4.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            txt4.setText(TimeApo.getText().toString()+" εώς "+TimeEws.getText().toString()+" "+parent.getItemAtPosition(position).toString());
                        }
                    });

                    bt3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            txt3.setText(TimeApo.getText().toString()+" εώς "+TimeEws.getText().toString()+" "+parent.getItemAtPosition(position).toString());
                        }
                    });

                    bt2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            txt2.setText(TimeApo.getText().toString()+" εώς "+TimeEws.getText().toString()+" "+parent.getItemAtPosition(position).toString());
                        }
                    });
                    bt1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            txt1.setText(TimeApo.getText().toString()+" εώς "+TimeEws.getText().toString()+" "+parent.getItemAtPosition(position).toString());

                        }
                    });
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        txt1.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                txt1.setText("");
                return  true;
            }
        });
        txt2.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                txt2.setText("");
                return  true;
            }
        });

        txt3.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                txt3.setText("");
                return  true;
            }
        });

        txt4.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                txt4.setText("");
                return  true;
            }
        });






        return v;
    }


}
