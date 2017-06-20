package droidudes.fix.it;

import android.app.Application;
import android.content.Context;

/**
 * Created by Zare Ahmed on 5/26/2017.
 */
public class MainApplication extends Application {

    public static Context applicationContext;
    //also initialzie Admob ad here...

    @Override
    public void onCreate() {
        super.onCreate();

        applicationContext = getApplicationContext();
    }
}
