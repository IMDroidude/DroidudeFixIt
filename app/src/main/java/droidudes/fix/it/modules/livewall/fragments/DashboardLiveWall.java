package droidudes.fix.it.modules.livewall.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import droidudes.fix.it.R;
import droidudes.fix.it.modules.livewall.adapters.LiveWallAdapter;
import droidudes.fix.it.modules.livewall.models.LiveWallPostBO;
import droidudes.fix.it.parentbase.BaseFragment;

/**
 * Created by Zare Ahmed on 11/8/2016.
 */
public class DashboardLiveWall extends BaseFragment {

    private RecyclerView mRecyclerView;
    private LiveWallAdapter mAdapter;
    private Context mContext;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mContext = getActivity();

        mRecyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setHasFixedSize(true);

        if(mAdapter == null){
            mAdapter = new LiveWallAdapter(mContext,new ArrayList<LiveWallPostBO>());
            mRecyclerView.setAdapter(mAdapter);
        }
        else
            mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public int setResourceLayoutID() {
        return R.layout.livewall_fragment;
    }

    private void getLiveWallList(){
        List<LiveWallPostBO> wallPostBOList = new ArrayList<>();
        wallPostBOList.add(new LiveWallPostBO());
    }
}
