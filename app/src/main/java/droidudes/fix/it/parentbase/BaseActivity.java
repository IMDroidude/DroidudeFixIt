package droidudes.fix.it.parentbase;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import droidudes.fix.it.R;

/**
 * Created by Zare Ahmed on 11/8/2016.
 */
public abstract class BaseActivity extends AppCompatActivity {

    public FragmentManager fragmentManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_frame_layout);

        fragmentManager = getSupportFragmentManager();
    }

    public void goBackFragment(int steps){
        if (getSupportFragmentManager().getBackStackEntryCount() >= steps) {
            for(int x = 0 ; x < steps ; x++)
                fragmentManager.popBackStack();
        }
    }

    public void addAFragment(Fragment fragment){
        fragmentManager.beginTransaction().add(R.id.frame_container,fragment)
                .addToBackStack(fragment.getClass().getSimpleName()).commit();
        /// FIXME: 6/11/2017 use Transition with it
        //fragmentManager.beginTransaction().setTransition(R.anim.)
    }

    public void addBaseFragment(Fragment fragment){
        fragmentManager.beginTransaction().add(R.id.frame_container,fragment).commit();
    }

    public void replaceAFragment(Fragment fragment){
        fragmentManager.beginTransaction().replace(R.id.frame_container,fragment)
                .addToBackStack(fragment.getClass().getSimpleName()).commit();
    }

    //I think I don't need this handling because I am adding fragment to BackStack
    //OS will handle backpressed it self.
    @Override
    public void onBackPressed() {
        ///super.onBackPressed();
        if (fragmentManager.getBackStackEntryCount() > 0) {
            Log.i("MainActivity", "popping backstack");
            fragmentManager.popBackStack();
        } else {
            Log.i("MainActivity", "nothing on backstack, calling super");
            super.onBackPressed();
        }

    }
}
