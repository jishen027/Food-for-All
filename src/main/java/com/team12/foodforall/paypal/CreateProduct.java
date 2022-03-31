package com.team12.foodforall.paypal;

import com.paypal.base.rest.APIContext;
import com.paypal.base.rest.PayPalRESTException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

@Service
public class CreateProduct {

    @Autowired
    private APIContext apiContext;

    public String createProduct(Integer projectID,
                                String name,
                                String desc
                                ) throws IOException, PayPalRESTException {
        URL url = new URL("https://api-m.sandbox.paypal.com/v1/catalogs/products");
        HttpURLConnection http = (HttpURLConnection)url.openConnection();
        http.setRequestMethod("POST");
        http.setDoOutput(true);
        http.setRequestProperty("Content-Type", "application/json");
        http.setRequestProperty("Authorization", "Bearer {}".format(apiContext.fetchAccessToken()));
        http.setRequestProperty("PayPal-Request-Id", "{}".format(projectID.toString()));

        String data = String.format("{\n  \"name\": \"%s\",\n  \"description\": \"%s\",\n  \"type\": \"SERVICE\",\n  \"category\": \"CHARITY\"\n}", name, desc);

        byte[] out = data.getBytes(StandardCharsets.UTF_8);

        OutputStream stream = http.getOutputStream();
        stream.write(out);

        System.out.println(http.getResponseCode() + " " + http.getResponseMessage());
        http.disconnect();

        return http.getResponseMessage();

    }
}
