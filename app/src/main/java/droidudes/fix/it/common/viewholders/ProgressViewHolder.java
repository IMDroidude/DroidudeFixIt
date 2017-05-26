package droidudes.fix.it.common.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

/**
 * Created by Zare Ahmed on 4/24/2017.
 */
public class ProgressViewHolder extends RecyclerView.ViewHolder {

    private ProgressBar mProgressBar;

    public ProgressViewHolder(View itemView) {
        super(itemView);
    }

    public void showProgress(boolean flag){
        mProgressBar.setIndeterminate(flag);
    }
}
