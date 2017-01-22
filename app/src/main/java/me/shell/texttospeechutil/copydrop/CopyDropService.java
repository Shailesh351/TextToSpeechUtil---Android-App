package me.shell.texttospeechutil.copydrop;

import android.app.Service;
import android.content.ClipDescription;
import android.content.ClipboardManager;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

/**
 * Created by shell on 18/1/17.
 */

public class CopyDropService extends Service {

    public ClipboardManager mClipboardManager;
    public ClipboardManager.OnPrimaryClipChangedListener e;
    public e i;

    final boolean a(String paramString) {
        ClipDescription localClipDescription = this.mClipboardManager.getPrimaryClipDescription();
        if (localClipDescription == null) {
            return false;
        }

        if ((!localClipDescription.hasMimeType("text/plain")) && (!localClipDescription.hasMimeType("text/html"))) {
            return false;
        }
        return true;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        this.mClipboardManager = ((ClipboardManager) getSystemService(CLIPBOARD_SERVICE));
        this.e = new l(this);
        this.mClipboardManager.addPrimaryClipChangedListener(this.e);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        this.mClipboardManager.removePrimaryClipChangedListener(this.e);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
