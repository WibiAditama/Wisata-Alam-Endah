package com.example.alamendah;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class CoffeeTrip extends AppCompatActivity implements AdapterView.OnItemSelectedListener
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coffee_trip);

        Spinner spinnerCoffeTrip = findViewById(R.id.spinnerCoffeTrip);
        ArrayAdapter<CharSequence> adapterCoffeTrip = ArrayAdapter.createFromResource(this, R.array.PaketWisata, android.R.layout.simple_spinner_item);
        adapterCoffeTrip.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCoffeTrip.setAdapter(adapterCoffeTrip);
        spinnerCoffeTrip.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
    {
        switch (position)
        {
            case 0:
                startActivity(new Intent(getApplicationContext(), AlamendahTrip.class));
                break;
            case 1:
                startActivity(new Intent(getApplicationContext(), NgagoesUlinKalembur.class));
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent)
    {
    }
}
