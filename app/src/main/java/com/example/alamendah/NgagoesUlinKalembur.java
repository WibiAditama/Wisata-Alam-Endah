package com.example.alamendah;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class NgagoesUlinKalembur extends AppCompatActivity implements AdapterView.OnItemSelectedListener
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ngagoes_ulin_kalembur);

        Spinner spinnerNgagoes = findViewById(R.id.spinnerNgagoes);
        ArrayAdapter<CharSequence> adapterNgagoesUlinKalembur = ArrayAdapter.createFromResource(this, R.array.PaketWisata, android.R.layout.simple_spinner_item);
        adapterNgagoesUlinKalembur.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerNgagoes.setAdapter(adapterNgagoesUlinKalembur);
        spinnerNgagoes.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
    {
        switch (position)
        {
            case 1:
                startActivity(new Intent(getApplicationContext(), AlamendahTrip.class));
                break;
            case 3:
                startActivity(new Intent(getApplicationContext(), CoffeeTrip.class));
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent)
    {
    }
}
