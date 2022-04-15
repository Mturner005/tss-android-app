package turnertss.com.tssandroidapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Movie;
import android.net.Uri;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.iterable.iterableapi.IterableActionContext;
import com.iterable.iterableapi.IterableUrlHandler;

import java.net.MalformedURLException;
import java.net.URL;

import static androidx.core.content.ContextCompat.startActivity;

public class turnerUrlHandler extends AppCompatActivity implements IterableUrlHandler {

    Context turnerContext;

    @Override
    public boolean handleIterableURL(@NonNull Uri uri, @NonNull IterableActionContext actionContext) {

        //if uri.host = links.turnertechsupport.com

        if (uri.getPath().contains("movies")) {
            Log.d("turnerTesting", "movies is working!!!");
            navigateToMovieScreen();
            return true;
        } else {
            return false;
        }


//        String authority = uri.getAuthority();
//        Log.d("turnerTesting", "handleIterableURL: " + authority);
//        String host = uri.getHost();
//        Log.d("turnerTesting", "handleIterableURL: " + host);
//        String path = uri.getPath();
//        Log.d("turnerTesting", "handleIterableURL: " + path);
//        String encodedPath = uri.getEncodedPath();
//        Log.d("turnerTesting", "handleIterableURL: " + encodedPath);
//        Log.d("turnerTesting", "handleIterableURL: " + uri);

        //int duration = Toast.LENGTH_LONG;
        //Context context = context.getApplicationContext();
        //Toast toast = Toast.makeText(context, uri.getHost(), duration);
        //toast.show();

    }

    public void navigateToMovieScreen () {
        Intent intent = new Intent(getApplicationContext(), Movies.class);
        startActivity(intent);

    }

}
