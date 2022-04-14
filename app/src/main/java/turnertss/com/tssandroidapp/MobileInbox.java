package turnertss.com.tssandroidapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class MobileInbox extends AppCompatActivity {

    private ImageView mBackButton;
    Window window;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.iterable_inbox_item);

        window = this.getWindow();
        window.setStatusBarColor(this.getResources().getColor(R.color.LightBlue));

        mBackButton = findViewById(R.id.mobile_inbox_bb);

        mBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDashboard();
            }
        });

    }

    public void openDashboard(){
        Intent intent = new Intent(this, Dashboard.class);
        startActivity(intent);
    }

}
