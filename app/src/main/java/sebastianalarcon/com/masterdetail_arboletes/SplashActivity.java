package sebastianalarcon.com.masterdetail_arboletes;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.Window;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by SEBAS on 18/05/2015.
 */
public class SplashActivity extends Activity {

    private static final long SPLASH_DELAY = 3000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.splash);

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                Intent mainIntent = new Intent().setClass(SplashActivity.this, ItemListActivity.class);
                startActivity(mainIntent);
                finish();
            }
        };

        Timer timer= new Timer();
        timer.schedule(task, SPLASH_DELAY);
    }
}
