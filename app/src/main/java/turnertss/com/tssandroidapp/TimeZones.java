package turnertss.com.tssandroidapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

public class TimeZones extends AppCompatActivity {

    private ImageView mBackButton;
    private TextView mUtcTextView;
    private TextView mPstTextView;
    private TextView mEdtTextView;
    private TextView mCstTextView;
    private TextView mMstTextView;
    private TextView mBstTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.time_zones_activity);

        mBackButton = findViewById(R.id.time_zones_bb);
        mUtcTextView = findViewById(R.id.current_utc_time_text);
        mPstTextView = findViewById(R.id.current_pst_time_text);
        mEdtTextView = findViewById(R.id.current_edt_time_text);
        mCstTextView = findViewById(R.id.current_cst_time_text);
        mBstTextView = findViewById(R.id.current_bst_time_text);
        mMstTextView = findViewById(R.id.current_mst_time_text);



        mBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDashboard();
            }
        });

        Thread thread = new Thread() {
            @Override
            public void run() {
                try {
                    while (!isInterrupted()) {
                        Thread.sleep(1000);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                TimeZone timeZone = TimeZone.getTimeZone("UTC");
                                Calendar calendar = Calendar.getInstance(timeZone);
                                SimpleDateFormat simpleDateFormat =
                                        new SimpleDateFormat("EE MMM dd yyyy HH:mm:ss zzz", Locale.US);
                                simpleDateFormat.setTimeZone(timeZone);
                                String currenttime = simpleDateFormat.format(calendar.getTime());
                                mUtcTextView.setText(currenttime);
                            }
                        });
                    }
                } catch (Exception e) {
                    mUtcTextView.setText(R.string.app_name);
                }
            }
        };
        Thread thread2 = new Thread() {
            @Override
            public void run() {
                try {
                    while (!isInterrupted()) {
                        Thread.sleep(1000);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                TimeZone timeZone = TimeZone.getTimeZone("America/Los_Angeles");
                                Calendar calendar = Calendar.getInstance(timeZone);
                                SimpleDateFormat simpleDateFormat =
                                        new SimpleDateFormat("EE MMM dd yyyy HH:mm:ss zzz", Locale.US);
                                simpleDateFormat.setTimeZone(timeZone);
                                String currenttime = simpleDateFormat.format(calendar.getTime());
                                mPstTextView.setText(currenttime);
                            }
                        });
                    }
                } catch (Exception e) {
                    mPstTextView.setText(R.string.app_name);
                }
            }
        };
        Thread thread3 = new Thread() {
            @Override
            public void run() {
                try {
                    while (!isInterrupted()) {
                        Thread.sleep(1000);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                TimeZone timeZone = TimeZone.getTimeZone("America/New_York");
                                Calendar calendar = Calendar.getInstance(timeZone);
                                SimpleDateFormat simpleDateFormat =
                                        new SimpleDateFormat("EE MMM dd yyyy HH:mm:ss zzz", Locale.US);
                                simpleDateFormat.setTimeZone(timeZone);
                                String currenttime = simpleDateFormat.format(calendar.getTime());
                                mEdtTextView.setText(currenttime);
                            }
                        });
                    }
                } catch (Exception e) {
                    mEdtTextView.setText(R.string.app_name);
                }
            }
        };
        Thread thread4 = new Thread() {
            @Override
            public void run() {
                try {
                    while (!isInterrupted()) {
                        Thread.sleep(1000);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                TimeZone timeZone = TimeZone.getTimeZone("America/Chicago");
                                Calendar calendar = Calendar.getInstance(timeZone);
                                SimpleDateFormat simpleDateFormat =
                                        new SimpleDateFormat("EE MMM dd yyyy HH:mm:ss zzz", Locale.US);
                                simpleDateFormat.setTimeZone(timeZone);
                                String currenttime = simpleDateFormat.format(calendar.getTime());
                                mCstTextView.setText(currenttime);
                            }
                        });
                    }
                } catch (Exception e) {
                    mCstTextView.setText(R.string.app_name);
                }
            }
        };
        Thread thread5 = new Thread() {
            @Override
            public void run() {
                try {
                    while (!isInterrupted()) {
                        Thread.sleep(1000);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                TimeZone timeZone = TimeZone.getTimeZone("Europe/London");
                                Calendar calendar = Calendar.getInstance(timeZone);
                                SimpleDateFormat simpleDateFormat =
                                        new SimpleDateFormat("EE MMM dd yyyy HH:mm:ss zzz", Locale.UK);
                                simpleDateFormat.setTimeZone(timeZone);
                                String currenttime = simpleDateFormat.format(calendar.getTime());
                                mBstTextView.setText(currenttime);
                            }
                        });
                    }
                } catch (Exception e) {
                    mBstTextView.setText(R.string.app_name);
                }
            }
        };
        Thread thread6 = new Thread() {
            @Override
            public void run() {
                try {
                    while (!isInterrupted()) {
                        Thread.sleep(1000);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                TimeZone timeZone = TimeZone.getTimeZone("America/Denver");
                                Calendar calendar = Calendar.getInstance(timeZone);
                                SimpleDateFormat simpleDateFormat =
                                        new SimpleDateFormat("EE MMM dd yyyy HH:mm:ss zzz", Locale.US);
                                simpleDateFormat.setTimeZone(timeZone);
                                String currenttime = simpleDateFormat.format(calendar.getTime());
                                mMstTextView.setText(currenttime);
                            }
                        });
                    }
                } catch (Exception e) {
                    mMstTextView.setText(R.string.app_name);
                }
            }
        };

        thread.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
        thread6.start();

    }

    public void openDashboard () {
        Intent intent = new Intent(this, Dashboard.class);
        startActivity(intent);
    }

}
