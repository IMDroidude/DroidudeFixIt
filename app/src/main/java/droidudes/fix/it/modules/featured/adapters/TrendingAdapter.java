package droidudes.fix.it.modules.featured.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.List;

import droidudes.fix.it.modules.featured.model.ItemBO;
import droidudes.fix.it.modules.featured.viewholder.TrendingViewHolder;


/**
 * Created by Zare Ahmed on 6/11/2017.
 */
public class TrendingAdapter extends RecyclerView.Adapter<TrendingViewHolder> {
    private Context mContext;
    private List<ItemBO> itemList;

    public TrendingAdapter(Context mContext, List<ItemBO> itemList) {
        this.mContext = mContext;
        this.itemList = itemList;
    }

    @Override
    public TrendingViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(TrendingViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }
}
