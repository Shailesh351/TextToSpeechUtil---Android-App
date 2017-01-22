package me.shell.texttospeechutil;

import android.app.Service;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.view.Gravity;
import android.view.WindowManager;

/**
 * Created by shell on 18/1/17.
 */

public class CopyDropService extends Service {

    public e i;
    public l l;

    @Override
    public void onCreate() {
        super.onCreate();
        this.l = new l(this);
        this.l.showPopupView();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        this.l.removePopupView();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
