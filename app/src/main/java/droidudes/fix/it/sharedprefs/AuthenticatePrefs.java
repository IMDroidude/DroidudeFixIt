package droidudes.fix.it.sharedprefs;

import droidudes.fix.it.common.Constants;

/**
 * Created by Zare Ahmed on 11/8/2016.
 */
public class AuthenticatePrefs {

    public static boolean isUserLoggedIn() {
        return SharedPrefs.read(Constants.LOGGED_IN_KEY, false);
    }

    public static void saveUserLoggedIn(boolean isUserLoggedIn) {
        SharedPrefs.save(Constants.LOGGED_IN_KEY, isUserLoggedIn);
    }
}
