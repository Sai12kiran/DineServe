package com.example.dineserve;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class successfull extends AppCompatActivity {
   Spinner spinner;
   ArrayAdapter adapter;
   Button bt1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_successfull);
        bt1=findViewById(R.id.book);
        spinner=findViewById(R.id.spinner2);

        adapter=ArrayAdapter.createFromResource(this,R.array.Rate_per_plare,R.layout.support_simple_spinner_dropdown_item);
         spinner.setAdapter(adapter);

         bt1.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 if (spinner.getSelectedItemPosition() > 0) {

                     Toast.makeText(getApplicationContext(), "Your Party booked successfully,You are Moving to Payment",
                             Toast.LENGTH_LONG).show();
                     Intent intent = new Intent(successfull.this, Paytm.class);
                     startActivity(intent);
                 } else {
                     setError();
                 }
             }
         });

}

    private void setError() {

        if (spinner.getSelectedItemPosition() > 0) {
// get selected item value
            String itemvalue = String.valueOf(spinner.getSelectedItem());
        } else {
// set error message on spinner



            TextView errorText = (TextView) spinner.getSelectedView();
            errorText.setError("");
            errorText.setTextColor(Color.RED);//just to highlight that this is an error
            errorText.setText("select any range");
        }
    }
    }
