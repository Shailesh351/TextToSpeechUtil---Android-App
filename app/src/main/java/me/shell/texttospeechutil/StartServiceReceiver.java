package me.shell.texttospeechutil;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by shell on 18/1/17.
 */

public class StartServiceReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        //Start service if App is Updated
        if(ServiceState.isServiceOn(context) && intent != null && intent.getAction() != null) {
            if (!intent.getAction().equals("android.intent.action.MY_PACKAGE_REPLACED")) {
                return;
            }
            context.startService(new Intent(context, CopyDropService.class));
            Log.d("test", "Service started from update");
        }

        while(!intent.getAction().equals("android.intent.action.BOOT_COMPLETED")){
            return;
        }

        //Start service when device has completed boot
        context.startService(new Intent(context, CopyDropService.class));
        Log.d("test", "Service started from boot");
    }
}
