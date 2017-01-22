package me.shell.texttospeechutil.copydrop;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.util.Log;
import android.view.Gravity;
import android.view.WindowManager;

/**
 * Created by shell on 22/1/17.
 */

public class l implements ClipboardManager.OnPrimaryClipChangedListener {
    public CopyDropService localCopydropService;
    public e locale;

    l(CopyDropService copyDropService) {
        this.localCopydropService = copyDropService;
        this.localCopydropService.i = new e(localCopydropService);
        this.locale = localCopydropService.i;
    }

    @Override
    public void onPrimaryClipChanged() {
        Log.d("test", "primary clip changed");
        String str;
        do {
            ClipData localClipData;
            localClipData = this.localCopydropService.mClipboardManager.getPrimaryClip();
            str = localClipData.getItemAt(0).coerceToText(this.localCopydropService.getApplicationContext()).toString();
            Log.d("test", "string : " + str);
        } while (!this.localCopydropService.a(str));

        showPopupView();
    }

    public void showPopupView() {
        WindowManager.LayoutParams localLayoutParams = locale.d;
        localLayoutParams.gravity = Gravity.TOP | Gravity.LEFT;
        locale.c = ((WindowManager) locale.a.getSystemService(Context.WINDOW_SERVICE));
        localLayoutParams.x = locale.c.getDefaultDisplay().getWidth();
        localLayoutParams.y = 550;
        if (locale.b != null && !locale.b.isAttachedToWindow()) {
            locale.c.addView(locale.b, localLayoutParams);
            locale.b.startAnimation();
        }
        Log.d("test", "Pop up showed");
    }

    public void removePopupView() {
        locale.c = ((WindowManager) locale.a.getSystemService(Context.WINDOW_SERVICE));
        if (locale.b != null && locale.b.isAttachedToWindow()) {
            locale.c.removeView(locale.b);
        }
    }
}
