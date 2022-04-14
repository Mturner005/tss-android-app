package turnertss.com.tssandroidapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Calendar;

public class RandomFacts extends AppCompatActivity {

    private ImageView mBackButton;
    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.random_facts_activity);

        mBackButton = findViewById(R.id.random_facts_bb);
        mTextView = findViewById(R.id.random_fact_text);

        mBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDashboard();
            }
        });


        // Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(RandomFacts.this);
        String url = "https://uselessfacts.jsph.pl/today.json?language=en";

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                String randomFact = null;
                try {
                    randomFact = response.getString("text");
                    Log.d("response_text", "onResponse: " + randomFact);

                } catch (JSONException e) {
                    e.printStackTrace();
                }

                mTextView.setText(randomFact);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(RandomFacts.this, error.toString(), Toast.LENGTH_LONG).show();
            }
        });
//        {
//            /** Passing request headers **/
//            @Override
//            public Map getHeaders() throws AuthFailureError {
//                HashMap headers = new HashMap();
//                headers.put("Accept","application/json");
//                return headers;
//            }
           queue.add(request);
        };
//
        // Add the request to the RequestQueue.

    public void openDashboard(){
        Intent intent = new Intent(this, Dashboard.class);
        startActivity(intent);
    }


}
