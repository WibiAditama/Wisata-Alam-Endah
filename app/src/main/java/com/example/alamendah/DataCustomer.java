package com.example.alamendah;

import com.midtrans.sdk.corekit.core.TransactionRequest;
import com.midtrans.sdk.corekit.models.BankType;
import com.midtrans.sdk.corekit.models.CustomerDetails;
import com.midtrans.sdk.corekit.models.ItemDetails;
import com.midtrans.sdk.corekit.models.snap.CreditCard;

import java.util.ArrayList;

public class DataCustomer
{
    public static String NAME ="Wibi";
    public static String PHONE ="082229668301";
    public static String EMAIL ="wibiaditama78@gmail.com";

    public static CustomerDetails customerDetails()
    {
        CustomerDetails cd = new CustomerDetails();
        cd.setFirstName(NAME);
        cd.setPhone(PHONE);
        cd.setEmail(EMAIL);
        return cd;
    }

    public static TransactionRequest transactionRequest(String id, int price, int qty, String name)
    {
        TransactionRequest request = new TransactionRequest(System.currentTimeMillis() + "", 20000);
        request.setCustomerDetails(customerDetails());
        ItemDetails details = new ItemDetails(id, price, qty, name);

        ArrayList<ItemDetails> itemDetails = new ArrayList<>();
        itemDetails.add(details);
        request.setItemDetails(itemDetails);

        CreditCard creditCard = new CreditCard();
        creditCard.setSaveCard(false);
        creditCard.setAuthentication(CreditCard.AUTHENTICATION_TYPE_RBA);
        creditCard.setBank(BankType.MANDIRI);
        request.setCreditCard(creditCard);

        return request;
    }
}
