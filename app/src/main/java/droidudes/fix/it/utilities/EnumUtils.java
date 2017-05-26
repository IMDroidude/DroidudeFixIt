package droidudes.fix.it.utilities;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;

import droidudes.fix.it.R;
import droidudes.fix.it.modules.contacts.DashboardContacts;
import droidudes.fix.it.modules.featured.fragments.FeaturedFragment;
import droidudes.fix.it.modules.livewall.fragments.DashboardLiveWall;

/**
 * Created by Zare Ahmed on 5/7/2017.
 */
public class EnumUtils {

    public static enum Module{
        FEATURED,LIVEWALL,CONTACT,OTHER;

        public static String getTabText(Module moduleName){
            switch (moduleName){
                case FEATURED:
                    return "Featured";
                case LIVEWALL:
                    return "LiveWall";
                case OTHER:
                    return "Other";
                case CONTACT:
                    return "Contacts";
            }
            return "";
        }

        public static Fragment getDashboardFragment(Module moduleName){
            switch (moduleName){
                case FEATURED:
                    return new FeaturedFragment();
                case LIVEWALL:
                    return new DashboardLiveWall();
                case OTHER:
                    return new DashboardContacts();
                case CONTACT:
                    return new DashboardContacts();
            }
            return new FeaturedFragment();
        }

        public static int getModuleColor(Context context ,Module moduleName){
            int color = ContextCompat.getColor(context,getStatusBarColor(moduleName));

            switch (moduleName){
                case FEATURED:
                    color = ContextCompat.getColor(context,getStatusBarColor(moduleName));
                    break;
                case LIVEWALL:
                    color = ContextCompat.getColor(context,getStatusBarColor(moduleName));
                    break;
                case CONTACT:
                    color = ContextCompat.getColor(context,getStatusBarColor(moduleName));
                    break;
                case OTHER:
                    color = ContextCompat.getColor(context,getStatusBarColor(moduleName));
                    break;
            }
            return color;
        }

        public static int getStatusBarColor(Module moduleName){
            switch (moduleName){
                case FEATURED:
                    return R.color.blackish;
                case LIVEWALL:
                    return R.color.blackish;
                case OTHER:
                    return R.color.blackish;
                case CONTACT:
                    return R.color.blackish;
            }
            return R.color.blackish;
        }

    }
}
