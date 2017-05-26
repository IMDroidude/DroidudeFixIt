package droidudes.fix.it.sharedprefs;

/**
 * Created by Zare Ahmed on 11/8/2016.
 */
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.reflect.TypeToken;

import java.util.List;

import droidudes.fix.it.MainApplication;

/**
 * Created by Awais on 8/13/2016.
 */
public class SharedPrefs {

    //shared preference method to store integer value ..
    public static int read(String valueKey, int valueDefault) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(MainApplication.applicationContext);
        return prefs.getInt(valueKey, valueDefault);
    }

    //shared preference method to store integer value ..
    public static void save(String valueKey, int value) {
        SharedPreferences prefs = PreferenceManager
                .getDefaultSharedPreferences(MainApplication.applicationContext);
        SharedPreferences.Editor edit = prefs.edit();
        edit.putInt(valueKey, value);
        edit.commit();
    }

    //shared preference method to store boolean value ..
    public static boolean read(String valueKey, boolean flag) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(MainApplication.applicationContext);
        return prefs.getBoolean(valueKey, flag);
    }

    //shared preference method to store string value ..
    public static void save(String valueKey, boolean flag) {
        SharedPreferences prefs = PreferenceManager
                .getDefaultSharedPreferences(MainApplication.applicationContext);
        SharedPreferences.Editor edit = prefs.edit();
        edit.putBoolean(valueKey, flag);
        edit.commit();
    }

    //shared preference method to store string value ..
    public static String read(String valueKey, String valueDefault) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(MainApplication.applicationContext);
        return prefs.getString(valueKey, valueDefault);
    }

    //shared preference method to store string value ..
    public static void save(String valueKey, String value) {
        SharedPreferences prefs = PreferenceManager
                .getDefaultSharedPreferences(MainApplication.applicationContext);
        SharedPreferences.Editor edit = prefs.edit();
        edit.putString(valueKey, value);
        edit.commit();
    }

    public static <T> void saveAnyTypeOfList(String key, List<T> value) {
        Gson gson = new GsonBuilder().create();
        JsonArray jsonArray = gson.toJsonTree(value).getAsJsonArray();
        SharedPrefs.save(key, jsonArray.toString());
    }

    public static <T> List<T> readAnyTypeOfList(String key, TypeToken<List<T>> tt) {
        Gson gson = new Gson();
        return (gson.fromJson(SharedPrefs.read(key, "[]"), tt.getType()));
    }
}


