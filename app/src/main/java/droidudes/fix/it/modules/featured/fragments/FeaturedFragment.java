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
    public int setResourceLayoutID() {
        return R.layout.fragment_featured;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mContext = getActivity();
        initViews(view);
    }

    private void initViews(View mView){
        mViewPager = (ViewPager) mView.findViewById(R.id.view_pager);

        if(mAdapter == null)
            mAdapter = new BannerAdapter(getChildFragmentManager(),imageUrls);
        else
            mViewPager.setAdapter(mAdapter);
    }
}
