package me.shell.texttospeechutil;

import android.content.Context;
import android.graphics.PixelFormat;
import android.view.WindowManager;

/**
 * Created by shell on 22/1/17.
 */

public class e {

    public Context a;
    public InitialPopupView b;
    public WindowManager c;
    public final WindowManager.LayoutParams d = new WindowManager.LayoutParams(
            WindowManager.LayoutParams.WRAP_CONTENT,
            WindowManager.LayoutParams.WRAP_CONTENT,
            WindowManager.LayoutParams.TYPE_SYSTEM_ALERT,
            WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,
            PixelFormat.TRANSLUCENT);

    public e(Context context){
        this.a = context;
        this.b = new InitialPopupView(this.a,this.d);
    }
}
