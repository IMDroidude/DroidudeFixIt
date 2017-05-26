package droidudes.fix.it.modules.featured.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by Zare Ahmed on 4/24/2017.
 */
public class BannerAdapter extends FragmentPagerAdapter {

    private List<String> imageUrls;

    public BannerAdapter(FragmentManager fm , List<String> imageUrls) {
        super(fm);
        this.imageUrls = imageUrls;
    }

    @Override
    public int getCount() {
        return imageUrls.size();
    }

    @Override
    public Fragment getItem(int position) {
        return null;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        return super.instantiateItem(container, position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        super.destroyItem(container, position, object);
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
        ///return super.isViewFromObject(view, object);
    }
}
