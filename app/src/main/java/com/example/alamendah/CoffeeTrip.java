package com.example.alamendah;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class CoffeeTrip extends AppCompatActivity implements AdapterView.OnItemSelectedListener
{
    Button PaymentCoffeeTrip;
    TextView namaPaket;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coffee_trip);

        namaPaket = (TextView)findViewById(R.id.NamaPaketCoffeeTrip);

        Spinner spinnerCoffeTrip = findViewById(R.id.spinnerCoffeTrip);
        ArrayAdapter<CharSequence> adapterCoffeTrip = ArrayAdapter.createFromResource(this, R.array.PaketWisata, android.R.layout.simple_spinner_item);
        adapterCoffeTrip.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCoffeTrip.setAdapter(adapterCoffeTrip);
        spinnerCoffeTrip.setOnItemSelectedListener(this);

        PaymentCoffeeTrip  = findViewById(R.id.paymentCoffeeTrip);
        PaymentCoffeeTrip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IntenpaymentCoffeeTrip();
            }
        });
    }

    public void IntenpaymentCoffeeTrip()
    {
        Intent paymentCoffeeTripIntent = new Intent(this, Payment.class);
        String NamaPaket = namaPaket.getText().toString();
        paymentCoffeeTripIntent.putExtra("Nama Paket", NamaPaket);
        paymentCoffeeTripIntent.putExtra("Price", 205000);
        startActivity(paymentCoffeeTripIntent);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
    {
        switch (position)
        {
            case 1:
                startActivity(new Intent(getApplicationContext(), AlamendahTrip.class));
                break;
            case 2:
                startActivity(new Intent(getApplicationContext(), NgagoesUlinKalembur.class));
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent)
    {
    }
}
