package droidudes.fix.it.common;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by Zare Ahmed on 4/24/2017.
 */
public abstract class SingleItemCommonAdapter<T> extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context mContext;
    private List<T> itemList;

    public SingleItemCommonAdapter(Context mContext, List<T> itemList) {
        this.mContext = mContext;
        this.itemList = itemList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return setViewHolder(parent);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if(itemList != null && itemList.size() > position)
        onBindData(holder, itemList.get(position));
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public abstract RecyclerView.ViewHolder setViewHolder(ViewGroup container);
    public abstract void onBindData(RecyclerView.ViewHolder holder,T data);
}
