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

public class NoofTab extends AppCompatActivity {
    Spinner spinner;
    Button bt1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_noof_tab);

        spinner=findViewById(R.id.spinner2);
        bt1=findViewById(R.id.button);

        ArrayAdapter arrayAdapter=ArrayAdapter.createFromResource(this,R.array.No_of_Tables,R.layout.support_simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(spinner.getSelectedItemPosition()>0) {
                    Intent intent = new Intent(NoofTab.this, Tablebook.class);
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
