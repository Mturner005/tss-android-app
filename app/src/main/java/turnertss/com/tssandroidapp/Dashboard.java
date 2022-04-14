package turnertss.com.tssandroidapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.iterable.iterableapi.IterableApi;
import com.iterable.iterableapi.IterableConstants;
import com.iterable.iterableapi.ui.inbox.IterableInboxActivity;

public class Dashboard extends AppCompatActivity implements View.OnClickListener {

    private CardView weatherCard;
    private CardView logsCard;
    private CardView jokesCard;
    private CardView timeZoneCard;
    private CardView mobileInboxCard;
    private CardView moviesCard;
    private CardView randomFactsCard;
    private CardView customEventsCard;
    private ImageView userIcon;
    private FirebaseUser user;
    private DatabaseReference reference;
    private String userID;

    SharedPreferences sharedPreferences;

    private static final String SHARED_PREF_NAME = "mypref";
    private static final String KEY_EMAIL = "sharedEmail";
    private static final String KEY_PASS = "sharedPass";

    Window window;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard);

        window = this.getWindow();
        window.setStatusBarColor(this.getResources().getColor(R.color.LightBlue));

        weatherCard = findViewById(R.id.weather_card);
        weatherCard.setOnClickListener(this);
        logsCard = findViewById(R.id.logs_card);
        logsCard.setOnClickListener(this);
        jokesCard = findViewById(R.id.jokes_card);
        jokesCard.setOnClickListener(this);
        timeZoneCard = findViewById(R.id.time_zones_card);
        timeZoneCard.setOnClickListener(this);
        mobileInboxCard = findViewById(R.id.mobile_inbox_card);
        mobileInboxCard.setOnClickListener(this);
        moviesCard = findViewById(R.id.movies_card);
        moviesCard.setOnClickListener(this);
        randomFactsCard = findViewById(R.id.random_facts_card);
        randomFactsCard.setOnClickListener(this);
        customEventsCard = findViewById(R.id.custom_events_card);
        customEventsCard.setOnClickListener(this);
        userIcon = findViewById(R.id.profileIcon);
        userIcon.setOnClickListener(this);

        user = FirebaseAuth.getInstance().getCurrentUser();
        reference = FirebaseDatabase.getInstance().getReference("Users");
        userID = user.getUid();

        final TextView userNameText = findViewById(R.id.blankUserName);

        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME,MODE_PRIVATE);

        IterableApi.getInstance().getInAppManager().setAutoDisplayPaused(false);

        reference.child(userID).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                User userProfile = snapshot.getValue(User.class);

                if(userProfile != null){
                    String userName = userProfile.userName;

                    userNameText.setText(userName);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.weather_card:
                startActivity(new Intent(this, Weather.class));
                break;
            case R.id.time_zones_card:
                startActivity(new Intent(this, TimeZones.class));
                break;
            case R.id.random_facts_card:
                startActivity(new Intent(this, RandomFacts.class));
                break;
            case R.id.movies_card:
                startActivity(new Intent(this, Movies.class));
                break;
            case R.id.mobile_inbox_card:
                startActivity(
                        new Intent(getApplicationContext(),IterableInboxActivity.class)
                                .putExtra("activityTitle", "My Inbox")
                                .putExtra(IterableConstants.NO_MESSAGES_TITLE,"No saved messages")
                                .putExtra(IterableConstants.NO_MESSAGES_BODY,"Check again later!")
                );
//                Intent intent = new Intent(this, IterableInboxActivity.class);
//                intent.putExtra("activityTitle", "My Inbox");
//                intent.putExtra("itemLayoutId", R.layout.iterable_inbox_item);
//                startActivity(intent);
                break;
            case R.id.logs_card:
                startActivity(new Intent(this, Logs.class));
                break;
            case R.id.jokes_card:
                startActivity(new Intent(this, Jokes.class));
                break;
            case R.id.custom_events_card:
                startActivity(new Intent(this, CustomEvents.class));
                break;
            case R.id.profileIcon:
                AlertDialog.Builder alert = new AlertDialog.Builder(this);
                alert.setTitle("Log Out?");
                alert.setCancelable(true);
                alert.setMessage("Are you sure you want to log out?");
                alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Log.d("LogOutMessage", "onClick: Yes Button Was Clicked");
                        //log user out of Firebase
                        FirebaseAuth.getInstance().signOut();
                        //devices.endpointEnabled gets set to false
                        IterableApi.getInstance().setEmail(null);
                        //clear everything out of shared preferences
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.clear();
                        editor.commit();
                        finish();
                        //send user to the Login page
                        Intent intent = new Intent(Dashboard.this,LoginActivity.class);
                        startActivity(intent);
                    }
                });
                alert.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Log.d("LogOutMessage", "onClick: No Button Was Clicked");
                    }
                });
                alert.show();
                break;
        }

    }


}



