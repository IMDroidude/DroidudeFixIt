package droidudes.fix.it.modules.featured.adapters;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.List;

import droidudes.fix.it.R;

/**
 * Created by Zare Ahmed on 4/24/2017.
 */
public class BannerAdapter extends PagerAdapter {

    private Context mContext;
    private List<String> imageUrls;

    public BannerAdapter(Context mContext, List<String> imageUrls) {
        this.mContext = mContext;
        this.imageUrls = imageUrls;
    }

    @Override
    public int getCount() {
        return imageUrls.size();
    }


    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        View mView = LayoutInflater.from(mContext).
                inflate(R.layout.item_banner_image,container,false);

        final ImageView imageView = (ImageView) mView.findViewById(R.id.featured_image);

        /*Glide.with(mContext)
                .load(imageUrls.get(position))
                .into(new SimpleTarget<Drawable>() {
                    @Override
                    public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                        imageView.setImageDrawable(resource);
                    }
                });*/

        Glide.with(mContext)
                .load(imageUrls.get(position))
                .into(imageView);

        container.addView(mView, 0);
        return mView;
        ///return super.instantiateItem(container, position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
        ///super.destroyItem(container, position, object);
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
        ///return super.isViewFromObject(view, object);
    }
}
