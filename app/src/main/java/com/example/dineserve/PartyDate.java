package com.example.dineserve;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Spinner;
import android.widget.TextView;

public class PartyDate extends AppCompatActivity {
    Spinner spinner;
    Button bt2;
    TextView tv;

    CalendarView calenderView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_party_date);
        bt2 = findViewById(R.id.price);
        calenderView = findViewById(R.id.calendarView);
        tv = findViewById(R.id.tv);
        spinner = findViewById(R.id.spinner);
        ArrayAdapter arrayAdapter = ArrayAdapter.createFromResource(this, R.array.Range_of_Party_in_members
                , R.layout.support_simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);


        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(spinner.getSelectedItemPosition() >0) {

                    Intent intent=new Intent(PartyDate.this,successfull.class);
                    startActivity(intent);


                }
                else
                {
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
