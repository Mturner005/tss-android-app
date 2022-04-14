package turnertss.com.tssandroidapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.iterable.iterableapi.IterableApi;

import org.json.JSONException;
import org.json.JSONObject;

public class CustomEvents extends AppCompatActivity {

    Button mRedButton, mYellowButton, mBlueButton, mOrangeButton, mGreenButton, mPurpleButton;
    ImageView mBackButon;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.custom_events);

        mRedButton = findViewById(R.id.red_button);
        mYellowButton = findViewById(R.id.yellow_button);
        mBlueButton = findViewById(R.id.blue_button);
        mOrangeButton = findViewById(R.id.orange_button);
        mGreenButton = findViewById(R.id.green_button);
        mPurpleButton = findViewById(R.id.purple_button);
        mBackButon = findViewById(R.id.custom_events_bb);

        mRedButton.setOnClickListener(new Click());
        mYellowButton.setOnClickListener(new Click());
        mBlueButton.setOnClickListener(new Click());
        mOrangeButton.setOnClickListener(new Click());
        mGreenButton.setOnClickListener(new Click());
        mPurpleButton.setOnClickListener(new Click());

        mBackButon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDashboard();
            }
        });

    }

    public class Click implements View.OnClickListener{

        @Override
        public void onClick(View v){

            switch (v.getId()){
                case R.id.red_button:
                    JSONObject eventData = new JSONObject();
                    try {
                        eventData.put("buttonColor", "red");
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    IterableApi.getInstance().track("coloredButtonClicked", eventData);
                    break;
                case R.id.yellow_button:
                    JSONObject eventData2 = new JSONObject();
                    try {
                        eventData2.put("buttonColor", "yellow");
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    IterableApi.getInstance().track("coloredButtonClicked", eventData2);
                    break;
                case R.id.blue_button:
                    JSONObject eventData3 = new JSONObject();
                    try {
                        eventData3.put("buttonColor", "blue");
                        Log.d("payload : ", (IterableApi.getInstance().getPayloadData().toString()));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    IterableApi.getInstance().track("coloredButtonClicked", eventData3);
                    break;
                case R.id.orange_button:
                    JSONObject eventData4 = new JSONObject();
                    try {
                        eventData4.put("buttonColor", "orange");
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    IterableApi.getInstance().track("coloredButtonClicked", eventData4);
                    break;
                case R.id.green_button:
                    JSONObject eventData5 = new JSONObject();
                    try {
                        eventData5.put("buttonColor", "green");
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    IterableApi.getInstance().track("coloredButtonClicked", eventData5);
                    break;
                case R.id.purple_button:
                    JSONObject eventData6 = new JSONObject();
                    try {
                        eventData6.put("buttonColor", "purple");
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    IterableApi.getInstance().track("coloredButtonClicked", eventData6);
                    break;
            }
        }

    }

    public void openDashboard(){
        Intent intent = new Intent(this, Dashboard.class);
        startActivity(intent);
    }


}
