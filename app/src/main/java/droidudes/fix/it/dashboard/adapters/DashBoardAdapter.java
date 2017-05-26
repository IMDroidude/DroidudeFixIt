package droidudes.fix.it.dashboard.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

import java.util.List;

import droidudes.fix.it.utilities.EnumUtils;

/**
 * Created by Zare Ahmed on 11/8/2016.
 */
public class DashBoardAdapter extends FragmentPagerAdapter {

    private List<EnumUtils.Module> moduleList;
    private Fragment mCurrentFragment = null;

    public DashBoardAdapter(FragmentManager fm, List<EnumUtils.Module> moduleList){
        super(fm);
        //Initializing tab count
        this.moduleList = moduleList;
    }

    @Override
    public Fragment getItem(int position) {
        return EnumUtils.Module.getDashboardFragment(moduleList.get(position));
    }

    @Override
    public int getCount() {
        return moduleList.size();
    }

    @Override
    public void setPrimaryItem(ViewGroup container, int position, Object object) {
        if (getCurrentFragment() != object) {
            mCurrentFragment = ((Fragment) object);
        }
        super.setPrimaryItem(container, position, object);
    }

    public Fragment getCurrentFragment() {
        return mCurrentFragment;
    }
}