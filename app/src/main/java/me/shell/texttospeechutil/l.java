package me.shell.texttospeechutil;

import android.content.Context;
import android.view.Gravity;
import android.view.WindowManager;

/**
 * Created by shell on 22/1/17.
 */

public class l {
    public CopyDropService localCopydropService;
    public e locale;

    l(CopyDropService copyDropService){
        this.localCopydropService = copyDropService;
        this.localCopydropService.i = new e(localCopydropService);
        this.locale = localCopydropService.i;
    }

    public void showPopupView(){
        WindowManager.LayoutParams localLayoutParams = locale.d;
        localLayoutParams.gravity = Gravity.TOP | Gravity.LEFT;
        locale.c = ((WindowManager) locale.a.getSystemService(Context.WINDOW_SERVICE));
        localLayoutParams.x = locale.c.getDefaultDisplay().getWidth();
        localLayoutParams.y = 550;
        locale.c.addView(locale.b, localLayoutParams);
    }

    public void removePopupView(){
        locale.c = ((WindowManager) locale.a.getSystemService(Context.WINDOW_SERVICE));
        if(locale.b != null && locale.b.isAttachedToWindow()){
            locale.c.removeView(locale.b);
        }
    }

}
