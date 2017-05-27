package droidudes.fix.it.dashboard.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import droidudes.fix.it.MainDrawerActivity;
import droidudes.fix.it.R;
import droidudes.fix.it.dashboard.OnModuleChangeListener;
import droidudes.fix.it.dashboard.adapters.DashBoardAdapter;
import droidudes.fix.it.parentbase.BaseFragment;
import droidudes.fix.it.utilities.EnumUtils;

/**
 * Created by Zare Ahmed on 11/8/2016.
 */
public class DashboardFragment extends BaseFragment {

    private Context mContext;
    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private DashBoardAdapter mAdapter;
    private OnModuleChangeListener onModuleChangeListener;
    private MainDrawerActivity activityInstance;

    public static DashboardFragment newInstance() {
        
        Bundle args = new Bundle();
        
        DashboardFragment fragment = new DashboardFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mContext = getActivity();

        activityInstance = (MainDrawerActivity) getActivity();

        mTabLayout = (TabLayout) view.findViewById(R.id.tab_layout);
        mViewPager = (ViewPager) view.findViewById(R.id.view_pager);

        final List<EnumUtils.Module> moduleToShow = getModuleToShowList();
        mViewPager.setOffscreenPageLimit(moduleToShow.size());

        for(EnumUtils.Module module :moduleToShow)
            mTabLayout.addTab(mTabLayout.newTab().setText(EnumUtils.Module.getTabText(module)));

        updateTabPagerAndMenu(0 , moduleToShow);

        mAdapter = new DashBoardAdapter(getFragmentManager(), moduleToShow);
        mViewPager.setOffscreenPageLimit(mAdapter.getCount());

        mViewPager.setAdapter(mAdapter);

        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(final TabLayout.Tab tab) {
                mViewPager.post(new Runnable() {
                    @Override
                    public void run() {
                        mViewPager.setCurrentItem(tab.getPosition());
                    }
                });
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });

        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                //added to redraw menu on scroll
            }

            @Override
            public void onPageSelected(int position) {
                updateTabPagerAndMenu(position , moduleToShow);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
    }

    //pass -1 if you want to get it via pager
    public Fragment getFragmentFromViewpager(int position) {
        if (position == -1)
            position = mViewPager.getCurrentItem();
        return ((Fragment) (mAdapter.instantiateItem(mViewPager, position)));
    }

    public void setOnModuleChangeListener(OnModuleChangeListener onModuleChangeListener) {
        this.onModuleChangeListener = onModuleChangeListener;
    }

    //also validate other checks and this method should be in SharedPrefs...
    public static List<EnumUtils.Module> getModuleToShowList(){
        List<EnumUtils.Module> moduleToShow = new ArrayList<>();

        moduleToShow.add(EnumUtils.Module.FEATURED);
        moduleToShow.add(EnumUtils.Module.LIVEWALL);

        return moduleToShow;
    }

    private Fragment getCurrentFragment(){
        return mAdapter.getCurrentFragment();
    }

    private void updateTabPagerAndMenu(int position , List<EnumUtils.Module> moduleToShow){
        //it helps to change menu on scroll
        //http://stackoverflow.com/a/27984263/3496570
        //No effect after changing below statement
        ActivityCompat.invalidateOptionsMenu(getActivity());
        if(mTabLayout != null)
            mTabLayout.getTabAt(position).select();

        if(onModuleChangeListener != null){

            if(activityInstance != null){
                activityInstance.updateStatusBarColor(moduleToShow.get(position));
            }
            onModuleChangeListener.onModuleChanged(moduleToShow.get(position));

            mTabLayout.setSelectedTabIndicatorColor(EnumUtils.Module.getModuleColor(mContext, moduleToShow.get(position)));
            /*mTabLayout.setTabTextColors(ContextCompat.getColor(mContext,android.R.color.black)
                    , EnumUtils.Module.getModuleColor(moduleToShow.get(position)));*/
        }
    }

    @Override
    public int setResourceLayoutID() {
        return R.layout.dashboard_fragment;
    }

    @Override
    public int setMenuID() {
        return 0;
    }
}
