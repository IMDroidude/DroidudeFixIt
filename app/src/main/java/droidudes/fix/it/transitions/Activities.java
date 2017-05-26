package droidudes.fix.it.transitions;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import droidudes.fix.it.MainDrawerActivity;
import droidudes.fix.it.R;
import droidudes.fix.it.parentbase.BaseActivity;

/**
 * Created by Zare Ahmed on 11/8/2016.
 */
public class Activities {

    public static void goToBaseFragment(Context context, Fragment fragment){
    }

    public static void replaceAFragment(Context context, Fragment fragment){
        AppCompatActivity activity = ((AppCompatActivity)context);

        if(activity instanceof BaseActivity){
            activity.getSupportFragmentManager().beginTransaction().
                    replace(R.id.frame_container , fragment).commit();
        }
        else if(activity instanceof MainDrawerActivity){
            activity.getSupportFragmentManager().beginTransaction().
                    replace(R.id.frame_container , fragment).commit();
        }
        else {
            activity.getSupportFragmentManager().beginTransaction().
                    replace(R.id.frame_container , fragment).commit();
        }
    }

    public static void addAFragment(Context context, Fragment fragment){
        AppCompatActivity activity = ((AppCompatActivity)context);
        activity.getSupportFragmentManager().beginTransaction().
                add(R.id.frame_container , fragment).commit();
    }

    public static void goBackFragment(Context context,int backStepCount){
        AppCompatActivity activity = ((AppCompatActivity)context);

        if(activity instanceof BaseActivity){
            while (backStepCount > 0) {
                activity.getSupportFragmentManager().popBackStack();
                backStepCount--;
            }
        }
    }

    public static String updateActionBarTitle(){

        return "";
    }
}
