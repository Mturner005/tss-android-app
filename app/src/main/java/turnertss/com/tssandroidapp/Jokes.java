package turnertss.com.tssandroidapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
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
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.google.firebase.database.snapshot.Index;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Jokes extends AppCompatActivity {

    private ImageView mBackButton;
    private Button mJokeButton;
    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.jokes_activity);

        mBackButton = findViewById(R.id.jokes_bb);
        mJokeButton = findViewById(R.id.joke_button);
        mTextView = findViewById(R.id.jokes_text);

        mBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDashboard();
            }
        });

        mJokeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                // Instantiate the RequestQueue.
                RequestQueue queue = Volley.newRequestQueue(Jokes.this);
                String url = "https://icanhazdadjoke.com/";

                JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {

                        String jokeId = null;
                        String jokeString = null;
                        try {
                            jokeId = response.getString("id");
                            jokeString = response.getString("joke");
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                        mTextView.setText(jokeString);
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(Jokes.this, error.toString(), Toast.LENGTH_LONG).show();
                    }
                })
                {
                    /** Passing request headers **/
                    @Override
                    public Map getHeaders() throws AuthFailureError {
                        HashMap headers = new HashMap();
                        headers.put("Accept","application/json");
                        return headers;
                    }
                };
//
                // Add the request to the RequestQueue.
                queue.add(request);

            }
        });

    }

    public void openDashboard(){
        Intent intent = new Intent(this, Dashboard.class);
        startActivity(intent);
    }

}
