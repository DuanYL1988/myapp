package com.app.expriment;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

@SuppressWarnings("deprecation")
public class TomcatConnectRest {

    private HttpClient client;

    private static final String URL = "http://localhost:8080/myapp/todos";

    public void httpClient() {
        try {
            client = new DefaultHttpClient();
            HttpGet getReq = new HttpGet(URL);
            HttpResponse response = client.execute(getReq);
            HttpEntity entity = response.getEntity();
            InputStream is = entity.getContent();
            BufferedReader buffer = new BufferedReader(
                    new InputStreamReader(is));
            StringBuffer bs = new StringBuffer();
            String l = null;
            while ((l = buffer.readLine()) != null) {
                bs.append(l).append("/n");
            }
            System.out.println(bs.toString());
            System.out.println("---------------------------");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
