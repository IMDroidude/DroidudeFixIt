package droidudes.fix.it.customviews;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.Log;

/**
 * Created by Zare Ahmed on 4/24/2017.
 */
public class LoadMoreRecyclerView extends RecyclerView {

    private boolean loading = true;
    int pastVisiblesItems, visibleItemCount, totalItemCount;
    //WrapperLinearLayout is for handling crash in RecyclerView
    private WrapperLinearLayout mLayoutManager;
    private Context mContext;
    private OnLoadMoreListener onLoadMoreListener;

    public LoadMoreRecyclerView(Context context) {
        super(context);
        mContext = context;
        init();
    }

    public LoadMoreRecyclerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        init();
    }

    public LoadMoreRecyclerView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        mContext = context;
        init();
    }

    private void init(){
        mLayoutManager = new WrapperLinearLayout(mContext, LinearLayoutManager.VERTICAL,false);
        this.setLayoutManager(mLayoutManager);
        this.setItemAnimator(new DefaultItemAnimator());
        this.setHasFixedSize(true);
    }

    @Override
    public void onScrolled(int dx, int dy) {
        super.onScrolled(dx, dy);

        if(dy > 0) //check for scroll down
        {
            visibleItemCount = mLayoutManager.getChildCount();
            totalItemCount = mLayoutManager.getItemCount();
            pastVisiblesItems = mLayoutManager.findFirstVisibleItemPosition();

            if (loading)
            {
                if ( (visibleItemCount + pastVisiblesItems) >= totalItemCount)
                {
                    loading = false;
                    Log.v("...", "Call Load More !");
                    if(onLoadMoreListener != null){
                        onLoadMoreListener.onLoadMore();
                    }
                    //Do pagination.. i.e. fetch new data
                }
            }
        }
    }

    public void enableLoadMore(boolean moreLoading){
        loading = moreLoading;
    }

    public void setOnLoadMoreListener(OnLoadMoreListener onLoadMoreListener) {
        this.onLoadMoreListener = onLoadMoreListener;
    }

    public interface OnLoadMoreListener{
        void onLoadMore();
    }
}
