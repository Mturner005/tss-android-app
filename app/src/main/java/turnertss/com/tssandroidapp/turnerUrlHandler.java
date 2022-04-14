package turnertss.com.tssandroidapp;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.iterable.iterableapi.IterableActionContext;
import com.iterable.iterableapi.IterableUrlHandler;

public class turnerUrlHandler implements IterableUrlHandler {


    @Override
    public boolean handleIterableURL(@NonNull Uri uri, @NonNull IterableActionContext actionContext) {

        //if uri.host = links.turnertechsupport.com
        Log.d("turnerTesting", "handleIterableURL: " + uri);
        //int duration = Toast.LENGTH_LONG;
        //Context context = context.getApplicationContext();
        //Toast toast = Toast.makeText(context, uri.getHost(), duration);
        //toast.show();
        return true;


    }
}
