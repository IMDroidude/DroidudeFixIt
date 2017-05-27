package droidudes.fix.it.modules.featured.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import droidudes.fix.it.R;
import droidudes.fix.it.modules.featured.adapters.BannerAdapter;
import droidudes.fix.it.parentbase.BaseFragment;

/**
 * Created by Zare Ahmed on 4/24/2017.
 */
public class FeaturedFragment extends BaseFragment {

    private Context mContext;
    private ViewPager mViewPager;
    private BannerAdapter mAdapter;
    private List<String> imageUrls = new ArrayList<>();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        imageUrls.add("http://thegiftplanner.com/blog/wp-content/uploads/2013/10/Special_Occasions-300x150.jpg");
        imageUrls.add("http://www.meetrv.com/wp-content/uploads/2016/07/4-Things-You-Need-To-Know-When-You-Buy-Birthday-Gifts-300x150.jpg");
        imageUrls.add("http://cdn-0.bestbirthdaygiftsideas.com/wp-content/uploads/bfi_thumb/5-Online-gift-shops-2wuxsohaqyu1fsfeb0kave.jpg");
        imageUrls.add("https://s-media-cache-ak0.pinimg.com/originals/7a/1b/d1/7a1bd1766b1ce605fd9c3d17009eafcf.jpg");
    }

    @Override
    public int setResourceLayoutID() {
        return R.layout.fragment_featured;
    }

    @Override
    public int setMenuID() {
        return 0;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mContext = getActivity();
        initViews(view);
    }

    private void initViews(View mView) {
        mViewPager = (ViewPager) mView.findViewById(R.id.view_pager);

        if (mAdapter == null)
            mAdapter = new BannerAdapter(mContext, imageUrls);

        mViewPager.setAdapter(mAdapter);
    }
}
