package droidudes.fix.it.common.interfaces;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;

import droidudes.fix.it.R;
import droidudes.fix.it.common.viewholders.ProgressViewHolder;

/**
 * Created by Zare Ahmed on 4/24/2017.
 */
public abstract class SingleItemLoadMoreCommonAdapter<T> extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context mContext;
    private List<T> itemList;

    public static final int VIEW_TYPE_FOOTER = 0;
    public static final int VIEW_TYPE_ITEM = 1;

    public SingleItemLoadMoreCommonAdapter(Context mContext, List<T> itemList) {
        this.mContext = mContext;
        this.itemList = itemList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(viewType == VIEW_TYPE_FOOTER)
            return new ProgressViewHolder(LayoutInflater.from(mContext)
            .inflate(R.layout.item_progress_loader,parent,false));
        return setViewHolder(parent);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if(itemList != null && itemList.size() > position){
            if(holder instanceof ProgressViewHolder)
                ((ProgressViewHolder) holder).showProgress(true);
            //I think I don't need else condition..
            onBindData(holder, itemList.get(position));
        }
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    @Override
    public int getItemViewType(int position) {
        if(itemList != null ){
            if(itemList.get(position) == null ){
                return VIEW_TYPE_FOOTER;
            }
            else
                return VIEW_TYPE_ITEM;
        }
        return super.getItemViewType(position);
    }

    public abstract RecyclerView.ViewHolder setViewHolder(ViewGroup container);
    public abstract void onBindData(RecyclerView.ViewHolder holder,T data);
}
