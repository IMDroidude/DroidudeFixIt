package droidudes.fix.it.parentbase;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import droidudes.fix.it.R;

/**
 * Created by Zare Ahmed on 12/15/2016.
 */
public abstract class BaseDrawerActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener{

    public Toolbar mToolbar;
    private FragmentManager fragmentManager;

    private ActionBarDrawerToggle toggle;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;


    public abstract Fragment setFragment();
    ///public abstract void updateToolBar(Toolbar mToolbar);

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_drawer);

        fragmentManager = getSupportFragmentManager();

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        resetActionBar();

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        toggle = new ActionBarDrawerToggle(
                this, drawerLayout, mToolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        /*toggle.setToolbarNavigationClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (getSupportFragmentManager().getBackStackEntryCount() > 0)
                    onBackPressed();
            }
        });*/

        getSupportFragmentManager().beginTransaction().
                setTransition(FragmentTransaction.TRANSIT_FRAGMENT_CLOSE).replace(R.id.frame_container,
                setFragment()).commit();

    }


    @Override
    public void onBackPressed() {
        //super.onBackPressed();
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == android.R.id.home) {
            if (getSupportFragmentManager().getBackStackEntryCount() > 0)
                onBackPressed();
            else
                drawerLayout.openDrawer(navigationView);
            return true;
        } else if (id == R.id.action_settings) {
            //showSortAlert();
        }
        return super.onOptionsItemSelected(item);
    }



    public void resetActionBar() {
        //display home
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
    }

    public void updateToolBarEtc(Toolbar mToolbar,String tilte){

    }


    public void removeAllFragments() {
        getSupportFragmentManager().popBackStackImmediate(null,
                FragmentManager.POP_BACK_STACK_INCLUSIVE);
    }

    public void addBaseFragment(Fragment fragment){
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        ///fragmentTransaction.setCustomAnimations()
        fragmentTransaction.add(R.id.frame_container, fragment).commit();
    }

    public void addAFragment(Fragment fragment){
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        ///fragmentTransaction.setCustomAnimations()
        fragmentTransaction.add(R.id.frame_container, fragment).
                addToBackStack(fragment.getClass().getSimpleName()).commit();
    }

    public void replaceAFragment(Fragment fragment){
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        ///fragmentTransaction.setCustomAnimations()
        fragmentTransaction.replace(R.id.frame_container, fragment).
                addToBackStack(fragment.getClass().getSimpleName()).commit();
    }

    public void goBackFragment(int count){
        if(fragmentManager.getBackStackEntryCount() > count)
        for(int x =0 ;x < count; x++)
            fragmentManager.popBackStack();
    }
}
