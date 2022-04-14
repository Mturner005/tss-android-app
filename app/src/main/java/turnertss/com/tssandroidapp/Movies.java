package turnertss.com.tssandroidapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Random;

public class Movies extends AppCompatActivity {

    private ImageView mBackButton;
    private ImageView moviePoster;
    private TextView movieName;
    private Button suggest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.movies_activity);

        moviePoster = findViewById(R.id.moviePoster);
        movieName = findViewById(R.id.movieName);
        suggest = findViewById(R.id.suggest);
        mBackButton = findViewById(R.id.movies_bb);

        mBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDashboard();
            }
        });

        RequestQueue queue = Volley.newRequestQueue(this);

        suggest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //random number generator for page, and convert it to string, in string URL
                Random r2 = new Random();
                int randomInt2 = r2.nextInt(5) + 1;
                String page = String.valueOf(randomInt2);

                //number generator for index of results array
                Random r = new Random();
                int randomInt = r.nextInt(20);

                //http request and changing layout of info in app
                String url = "https://api.themoviedb.org/4/list/7070509?page="+ page + "&api_key=f2a0a5d696643f2469707bd7c80755dc";

                JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                        new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject response) {
                                try {
                                    JSONArray jsonArray = response.getJSONArray("results");
                                    JSONObject finalResult = jsonArray.getJSONObject(randomInt);
                                    String finalMovieName = finalResult.getString("original_title");
                                    String finalMoviePoster = "https://image.tmdb.org/t/p/w500" + finalResult.getString("poster_path");

                                    Glide.with(moviePoster).load(finalMoviePoster).into(moviePoster);
                                    movieName.setText(finalMovieName);
                                } catch (JSONException jsonException) {
                                    jsonException.printStackTrace();
                                }
                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        error.printStackTrace();
                    }
                });
                queue.add(request);
            }
        });


}

    public void openDashboard(){
        Intent intent = new Intent(this, Dashboard.class);
        startActivity(intent);
    }

}
