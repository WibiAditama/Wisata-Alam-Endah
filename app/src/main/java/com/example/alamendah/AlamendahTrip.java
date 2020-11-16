package com.example.alamendah;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class AlamendahTrip extends AppCompatActivity implements AdapterView.OnItemSelectedListener
{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alamendah_trip);

        Spinner spinnerAlamEndahTrip = findViewById(R.id.spinnerAlamendahTrip);
        ArrayAdapter<CharSequence> adapterAlamendahTrip = ArrayAdapter.createFromResource(this, R.array.PaketWisata, android.R.layout.simple_spinner_item);
        adapterAlamendahTrip.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerAlamEndahTrip.setAdapter(adapterAlamendahTrip);
        spinnerAlamEndahTrip.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
    {
        switch (position)
        {
            case 1:
                startActivity(new Intent(getApplicationContext(), NgagoesUlinKalembur.class));
                break;
            case 2:
                startActivity(new Intent(getApplicationContext(), CoffeeTrip.class));
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent)
    {
    }
}
