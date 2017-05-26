package droidudes.fix.it.modules.livewall.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.List;
import droidudes.fix.it.R;
import droidudes.fix.it.common.interfaces.OnRecyclerItemClick;
import droidudes.fix.it.modules.livewall.models.LiveWallPostBO;

/**
 * Created by Zare Ahmed on 12/15/2016.
 */

public class LiveWallAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context mContext;
    private List<LiveWallPostBO> items;
    private OnRecyclerItemClick onRecyclerItemClick;

    public static final int GENERAL_POST_VIEW = 0;
    public static final int HEADER_POST_VIEW = 1;

    public LiveWallAdapter(Context mContext , List<LiveWallPostBO> dataArray){
        this.mContext = mContext;
        this.items = dataArray;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View mView;
        if(viewType == GENERAL_POST_VIEW){
            mView = LayoutInflater.from(mContext).inflate(R.layout.item_live_wall,parent,false);
            return new GeneralPostViewHolder(mView);
        }
        else if(viewType == HEADER_POST_VIEW){
            mView = LayoutInflater.from(mContext).inflate(R.layout.item_live_wall,parent,false);
            return new HeaderViewHolder(mView);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if(holder instanceof GeneralPostViewHolder){

        }
        else if(holder instanceof HeaderViewHolder){

        }

    }

    @Override
    public int getItemViewType(int position) {
        return  items.get(position).getTypeOfPost();
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void setOnRecyclerItemClick(OnRecyclerItemClick onRecyclerItemClick) {
        this.onRecyclerItemClick = onRecyclerItemClick;
    }

    public class GeneralPostViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private LinearLayout picsLL;
        private TextView titleTv,descriptionTv;

        public GeneralPostViewHolder(View itemView) {
            super(itemView);

            picsLL = (LinearLayout) itemView.findViewById(R.id.ll_pics);
            titleTv = (TextView) itemView.findViewById(R.id.tv_title);
            descriptionTv = (TextView) itemView.findViewById(R.id.tv_description);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {

        }

        public void bindData(LiveWallPostBO liveWallPostBO){

        }
    }

    public class HeaderViewHolder extends RecyclerView.ViewHolder {

        private TextView headerTv;

        public HeaderViewHolder(View itemView) {
            super(itemView);
            headerTv = (TextView) itemView.findViewById(R.id.tv_item_header);
        }
    }
}
