package sebastianalarcon.com.masterdetail_arboletes.dummy;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.content.Intent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import sebastianalarcon.com.masterdetail_arboletes.R;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p/>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class DummyContent{
    /**
     * An array of sample (dummy) items.
     */
    public static List<DummyItem> ITEMS = new ArrayList<DummyItem>();

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static Map<String, DummyItem> ITEM_MAP = new HashMap<String, DummyItem>();

    /*static {
        // Add 3 sample items.
        addItem(new DummyItem("1",R.string.title_activity_aboutus));
        addItem(new DummyItem("2",R.string.title_activity_sitios));
        addItem(new DummyItem("3", R.string.title_activity_hoteles));
    }*/

    public static void addItem(DummyItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }



    /**
     * A dummy item representing a piece of content.
     */
    public static class DummyItem {
        public String id;
        public String item_name;
        private Context context;

        public DummyItem(String id, String item_string) {
            this.id = id;
            this.item_name = item_string;
        }

        @Override
        public String toString() {
            return item_name;
        }
    }
}

