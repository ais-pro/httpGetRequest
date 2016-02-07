package com.example.root.httprequest2;

import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.net.URI;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        TextView text=(TextView)findViewById(R.id.text1);

        
        BufferedReader in = null;
        String data = null;

        try{
            HttpClient httpclient = new DefaultHttpClient();

            HttpGet request = new HttpGet();
            URI website = new URI("http://androidexample.com/media/webservice/httpget.php?user=info&name=hello&email=info@aisuvro.com&pass=123");
            request.setURI(website);


            ResponseHandler<String> responseHandler = new BasicResponseHandler();
            data = httpclient.execute(request, responseHandler);


            text.setText(data);
        }catch(Exception e){
            Log.e("log_tag", "Error in http connection "+e.toString());
            text.append(e.toString());
        }
    }









}
