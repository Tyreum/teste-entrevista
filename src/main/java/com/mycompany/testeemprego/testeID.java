/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.testeemprego;

import org.apache.commons.io.IOUtils;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;

public class testeID {
    String lala;
    public String request() throws IOException {
	URL url = new URL("https://test.oppwa.com/v1/payments");

	HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
	conn.setRequestMethod("POST");
        conn.setRequestProperty("Authorization", System.getenv("AUTHENTICATION"));
	conn.setDoInput(true);
	conn.setDoOutput(true);
        
	String data = ""
		+ "entityId=8ac7a4ca6db97ef1016dbe9214e70aac"
		+ "&amount=92.00"
		+ "&currency=BRL"
		+ "&paymentBrand=VISA"
		+ "&paymentType=PA"
		+ "&card.number=4200000000000000"
		+ "&card.holder=Gustavo Oliveira"
		+ "&card.expiryMonth=05"
		+ "&card.expiryYear=2020"
		+ "&card.cvv=123"
		+ "&customer.identificationDocType=TAXSTATEMENT"
		+ "&customer.identificationDocId=96072848010";

	DataOutputStream wr = new DataOutputStream(conn.getOutputStream());
	wr.writeBytes(data);
	wr.flush();
	wr.close();
	int responseCode = conn.getResponseCode();
	InputStream is;
        
        if (responseCode >= 400) is = conn.getErrorStream();
	else is = conn.getInputStream();

	return IOUtils.toString(is).substring(7, 39);
}
   
}
