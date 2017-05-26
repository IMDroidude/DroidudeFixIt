package droidudes.fix.it.modules.livewall;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.MenuItem;

import droidudes.fix.it.modules.livewall.fragments.DashboardLiveWall;
import droidudes.fix.it.parentbase.BaseDrawerActivity;
import droidudes.fix.it.transitions.Activities;

/**
 * Created by Zare Ahmed on 12/15/2016.
 */
public class LiveWallActivity extends BaseDrawerActivity {

    public static LiveWallActivity activity;
    private Context mContext;

    @Override
    public Fragment setFragment() {
        return new DashboardLiveWall();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mContext = LiveWallActivity.this;

        Activities.replaceAFragment(mContext , new DashboardLiveWall());

    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        return false;
    }
}
