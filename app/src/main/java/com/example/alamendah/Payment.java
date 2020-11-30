package com.example.alamendah;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.os.BuildCompat;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.midtrans.sdk.corekit.callback.TransactionFinishedCallback;
import com.midtrans.sdk.corekit.core.LocalDataHandler;
import com.midtrans.sdk.corekit.core.MidtransSDK;
import com.midtrans.sdk.corekit.core.PaymentMethod;
import com.midtrans.sdk.corekit.core.SdkCoreFlowBuilder;
import com.midtrans.sdk.corekit.core.TransactionRequest;
import com.midtrans.sdk.corekit.core.themes.CustomColorTheme;
import com.midtrans.sdk.corekit.models.BankTransfer;
import com.midtrans.sdk.corekit.models.BankType;
import com.midtrans.sdk.corekit.models.BillInfoModel;
import com.midtrans.sdk.corekit.models.CustomerDetails;
import com.midtrans.sdk.corekit.models.ItemDetails;
import com.midtrans.sdk.corekit.models.ShippingAddress;
import com.midtrans.sdk.corekit.models.UserAddress;
import com.midtrans.sdk.corekit.models.UserDetail;
import com.midtrans.sdk.corekit.models.snap.CreditCard;
import com.midtrans.sdk.corekit.models.snap.TransactionResult;
import com.midtrans.sdk.uikit.SdkUIFlowBuilder;

import java.util.ArrayList;

public class Payment extends AppCompatActivity implements TransactionFinishedCallback
{
    TextView Harga, wisata,TotalTiket, TotalHarga;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        Spinner spinnerJumlahTiket = findViewById(R.id.jumlahTiket);
        ArrayAdapter<CharSequence> adapterJumlahTiket = ArrayAdapter.createFromResource(this, R.array.Jumlahtiket, android.R.layout.simple_spinner_item);
        adapterJumlahTiket.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerJumlahTiket.setAdapter(adapterJumlahTiket);

        initMidtransSDK();
        init();
    }

    private void initMidtransSDK()
    {
        SdkUIFlowBuilder.init()
                .setContext(this)
                .setMerchantBaseUrl(BuildConfig.MERCHANT_BASE_URL)
                .setClientKey(BuildConfig.MERCHANT_CLIENT_KEY)
                .setTransactionFinishedCallback(this)
                .enableLog(true)
                .setColorTheme(new CustomColorTheme("#A1074D04", "#997BA178", "#D1074D04"))
                .buildSDK();
    }

    @SuppressLint("SetTextI18n")
    private void init()
    {
        Harga = findViewById(R.id.Harga);
        TotalTiket = findViewById(R.id.totalTiket);
        wisata = findViewById(R.id.wisata);
        TotalHarga = findViewById(R.id.totalHarga);
        wisata.setText(getIntent().getStringExtra("Nama Paket"));
        Harga.setText("Rp " + (getIntent().getIntExtra("Price", 0)));
        TotalTiket.setText(getIntent().getIntExtra("JumlahTiket", 1) + "Tiket");
        TotalHarga.setText("Rp " + (getIntent().getIntExtra("Price", 0)));


        findViewById(R.id.bayar).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                actionButton();
            }
        });
    }

    private void actionButton()
    {
        MidtransSDK.getInstance().setTransactionRequest(DataCustomer.transactionRequest("1", 20000, 1, "Coffee Trip"));
        MidtransSDK.getInstance().startPaymentUiFlow(this);
    }

    @Override
    public void onTransactionFinished(TransactionResult result)
    {
        if (result.getResponse() != null)
        {
            switch (result.getStatus())
            {
                case TransactionResult.STATUS_SUCCESS:
                    Toast.makeText(this, "Transaction Finished with ID :" + result.getResponse().getTransactionId(), Toast.LENGTH_SHORT).show();
                    break;
                case TransactionResult.STATUS_PENDING:
                    Toast.makeText(this, "Transaction Pending with ID :" + result.getResponse().getTransactionId(), Toast.LENGTH_SHORT).show();
                    break;
                case TransactionResult.STATUS_FAILED:
                    Toast.makeText(this, "Transaction Failed with ID :" + result.getResponse().getTransactionId(), Toast.LENGTH_SHORT).show();
                    break;
            }
            result.getResponse().getValidationMessages();
        }
        else if (result.isTransactionCanceled())
        {
            Toast.makeText(this, "Transaction Canceled", Toast.LENGTH_SHORT).show();
        }
        else
        {
            if (result.getStatus().equalsIgnoreCase(TransactionResult.STATUS_INVALID))
            {
                Toast.makeText(this, "Transaction Invalid", Toast.LENGTH_SHORT).show();
            }
            else
            {
                Toast.makeText(this, "Transaction Finished with Failure", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
