package com.example.dineserve;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class diffresto extends AppCompatActivity {
    CardView cardView1,cardView2,cardView3,cardView4,cardView5,cardView6,cardView7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diffresto);


        cardView1=findViewById(R.id.cv1);
        cardView2=findViewById(R.id.cv2);
        cardView3=findViewById(R.id.cv3);
        cardView4=findViewById(R.id.cv4);
        cardView5=findViewById(R.id.cv5);
        cardView6=findViewById(R.id.cv6);
        cardView7=findViewById(R.id.cv7);



        cardView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(diffresto.this,NoofTab.class);
                startActivity(intent);

            }
        });
        cardView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(diffresto.this,NoofTab.class);
                startActivity(intent);

            }
        });
        cardView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(diffresto.this,NoofTab.class);
                startActivity(intent);

            }
        });
        cardView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(diffresto.this,NoofTab.class);
                startActivity(intent);

            }
        });
        cardView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(diffresto.this,NoofTab.class);
                startActivity(intent);

            }
        });

        cardView6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(diffresto.this,NoofTab.class);
                startActivity(intent);

            }
        });

        cardView7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(diffresto.this,NoofTab.class);
                startActivity(intent);

            }
        });


    }
}
