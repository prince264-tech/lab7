package com.example.lab7;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    private String cityName;
    private RequestQueue queue;
    private EditText editText;
    private Button getForecast;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        queue = Volley.newRequestQueue(this);
        editText = findViewById(R.id.editText);
        getForecast = findViewById(R.id.getForecast);

        getForecast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cityName = editText.getText().toString().trim();
                String url = "https://api.openweathermap.org/data/2.5/weather?q=" + "Toronto" + "&appid=a6decbfd01fc5342cf0fdd49e7aa2e29";
                JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                        new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject response) {
                                try {
                                    // Parse JSON response and update UI

                                } catch (Exception e) {
                                    throw new RuntimeException(e);
                                }


                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                error.printStackTrace();
                            }
                        });

                queue.add(request);
            }
        });
    }
}
