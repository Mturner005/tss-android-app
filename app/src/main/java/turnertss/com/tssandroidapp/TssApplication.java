package turnertss.com.tssandroidapp;

import android.app.Application;
import android.net.Uri;
import android.util.Log;

import androidx.annotation.NonNull;

import com.iterable.iterableapi.IterableActionContext;
import com.iterable.iterableapi.IterableApi;
import com.iterable.iterableapi.IterableConfig;
import com.iterable.iterableapi.IterableHelper;
import com.iterable.iterableapi.IterablePushActionReceiver;
import com.iterable.iterableapi.IterableUrlHandler;

public class TssApplication  extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        IterableConfig config = new IterableConfig.Builder()
                .setPushIntegrationName("turnertss.com.tssandroidapp")
                .setLogLevel(Log.VERBOSE)
                .setUrlHandler(new turnerUrlHandler())
                .build();
        IterableApi.initialize(this, "e67df65ac2914509a71d833206a3bbc8", config);

        IterableApi.getInstance().getInAppManager().setAutoDisplayPaused(true);

    }

}


//   IterableConfig config = new IterableConfig.Builder().build();
//   IterableApi.initialize(this, "e67df65ac2914509a71d833206a3bbc8", config);