package droidudes.fix.it.authenticate;

import android.os.Bundle;
import android.support.annotation.Nullable;

import droidudes.fix.it.R;
import droidudes.fix.it.parentbase.BaseActivity;

/**
 * Created by Zare Ahmed on 11/8/2016.
 */
public class AuthenticateActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_frame_layout);


        addAFragment(new LogInFragment());
        ///Activities.replaceAFragment(AuthenticateActivity.this , new LogInFragment());
        //getSupportFragmentManager().beginTransaction().replace(R.id.frame_container,
        // new LogInFragment()).commit();
    }
}
