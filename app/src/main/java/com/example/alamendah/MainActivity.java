package com.example.alamendah;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
    RelativeLayout CoffeeTrip,Ngagoes,AlamEndahTrip;
    TextView CoffeeTripPrice, NgagoesPrice, AlamendahTripPrice;

    public static final String COFFEE_TRIP_PRICE = " ";
    public static final String NGAGOES_PRICE = " ";
    public static final String ALAMENDAH_TRIP_PRICE = " ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CoffeeTrip = (RelativeLayout)findViewById(R.id.coffeTrip);
        Ngagoes = (RelativeLayout)findViewById(R.id.Ngagoes);
        AlamEndahTrip = (RelativeLayout)findViewById(R.id.alamEndahTrip);
        CoffeeTripPrice = (TextView)findViewById(R.id.priceCoffeeTrip);
        NgagoesPrice = (TextView)findViewById(R.id.priceNgagoes);
        AlamendahTripPrice = (TextView)findViewById(R.id.priceAlamendahTrip);

        CoffeeTrip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                startActivity(new Intent(getApplicationContext(), com.example.alamendah.CoffeeTrip.class));
                Intent CoffeeTripIntent = new Intent(MainActivity.this, CoffeeTrip.class);
                CoffeeTripPrice.getText();
                CoffeeTripIntent.putExtra(COFFEE_TRIP_PRICE, 205000);
                startActivity(CoffeeTripIntent);
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
