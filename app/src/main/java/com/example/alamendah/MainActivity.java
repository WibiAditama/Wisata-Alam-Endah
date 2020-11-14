package com.example.alamendah;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    RelativeLayout CoffeeTrip,Ngagoes,AlamEndahTrip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CoffeeTrip = (RelativeLayout)findViewById(R.id.coffeTrip);
        Ngagoes = (RelativeLayout)findViewById(R.id.Ngagoes);
        AlamEndahTrip = (RelativeLayout)findViewById(R.id.alamEndahTrip);

        CoffeeTrip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), CoffeTrip.class));
            }
        });

        Ngagoes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), NgagoesUlinKalembur.class));
            }
        });

        AlamEndahTrip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), AlamendahTrip.class));
            }
        });
    }
}
