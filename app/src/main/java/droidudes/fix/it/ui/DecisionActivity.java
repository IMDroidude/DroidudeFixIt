package droidudes.fix.it.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import droidudes.fix.it.MainDrawerActivity;
import droidudes.fix.it.authenticate.AuthenticateActivity;
import droidudes.fix.it.sharedprefs.AuthenticatePrefs;

/**
 * Created by Zare Ahmed on 11/8/2016.
 */
// It is non UI Activity. It just make decision
public class DecisionActivity extends AppCompatActivity {

    private Context mContext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mContext = DecisionActivity.this;

        Intent intent = null;
        ///if user is already loggedIn . then take us ko
        if (AuthenticatePrefs.isUserLoggedIn())
            intent = new Intent(DecisionActivity.this, MainDrawerActivity.class);
        else
            intent = new Intent(DecisionActivity.this, AuthenticateActivity.class);

        startActivity(intent);
        finish();
    }
}
