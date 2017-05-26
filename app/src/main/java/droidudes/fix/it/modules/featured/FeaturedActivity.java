package droidudes.fix.it.modules.featured;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import droidudes.fix.it.R;
import droidudes.fix.it.modules.featured.fragments.FeaturedFragment;
import droidudes.fix.it.parentbase.BaseDrawerActivity;

/**
 * Created by Zare Ahmed on 4/26/2017.
 */
public class FeaturedActivity extends BaseDrawerActivity
{
    private Context mContext;
    private ActionBarDrawerToggle toggle;
    private DrawerLayout mDrawerLayout = null;

    @Override
    public Fragment setFragment() {
        return new FeaturedFragment();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mContext = FeaturedActivity.this;
    }

    @Override
    protected void onResume() {
        super.onResume();

        if(toggle == null || mDrawerLayout ==  null){
            mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
            mToolbar = (Toolbar) findViewById(R.id.toolbar);
            super.updateToolBarEtc(mToolbar,"title");
        }

    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        Fragment fragment = null;

        /*if (id == R.id.country_list) {
            // Handle the camera action
            fragment = new CountryListFragment();
        } else if (id == R.id.country_detail) {
            fragment = new CountryPagerFragment();
        } else if (id == R.id.country_quiz) {
            fragment = new QuizLevelsFragment();
        } else if (id == R.id.more_apps) {
            fragment = new MoreAppsFragment();
        } else if (id == R.id.share_it) {
            //fragment = new GameShareFragment();

            Intent sendIntent = new Intent();
            sendIntent.setAction(Intent.ACTION_SEND);
            sendIntent.putExtra(Intent.EXTRA_TEXT, "Share this app");
            sendIntent.setType("text/plain");
            startActivity(Intent.createChooser(sendIntent, getResources().getText(R.string.send_to)));
        }*/

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (fragment != null) {

            if (item.isChecked()) {
                if (getSupportFragmentManager().getBackStackEntryCount() == 0) {
                    drawer.closeDrawers();
                } else {
                    removeAllFragments();
                    getSupportFragmentManager().beginTransaction().setTransition(FragmentTransaction.TRANSIT_FRAGMENT_CLOSE).replace(R.id.frame_container, fragment).commit();
                    drawer.closeDrawer(GravityCompat.START);
                }

            } else {
                removeAllFragments();
                getSupportFragmentManager().beginTransaction().setTransition(FragmentTransaction.TRANSIT_FRAGMENT_CLOSE).replace(R.id.frame_container, fragment).commit();
                drawer.closeDrawer(GravityCompat.START);
            }
        }


        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
