/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.testeemprego;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;
import org.apache.commons.io.IOUtils;

/**
 *
 * @author Biel
 */
public class testeCapture {
    public String request(String requestID) throws IOException {
        testeID ID = new testeID();
	URL url = new URL("https://test.oppwa.com/v1/payments/" + requestID);

	HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
	conn.setRequestMethod("POST");
        conn.setRequestProperty("Authorization", System.getenv("AUTHENTICATION"));
	conn.setDoInput(true);
	conn.setDoOutput(true);

	String data = ""
		+ "entityId=8a8294184e736012014e78a17a5615ac"
		+ "&amount=92.00"
		+ "&currency=BRL"
		+ "&paymentType=CP";

	DataOutputStream wr = new DataOutputStream(conn.getOutputStream());
	wr.writeBytes(data);
	wr.flush();
	wr.close();
	int responseCode = conn.getResponseCode();
	InputStream is;

	if (responseCode >= 400) is = conn.getErrorStream();
	else is = conn.getInputStream();

	return IOUtils.toString(is);
}

}
