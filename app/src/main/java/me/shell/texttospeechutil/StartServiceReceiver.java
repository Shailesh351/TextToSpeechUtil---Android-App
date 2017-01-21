package me.shell.texttospeechutil;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by shell on 18/1/17.
 */

public class StartServiceReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        //Start service if App is Updated
        if(intent.getAction().equals("android.intent.action.MY_PACKAGE_REPLACED")){
            context.startService(new Intent(context, CopyDropService.class));
        }

        while(!intent.getAction().equals("android.intent.action.BOOT_COMPLETED")){
            return;
        }

        //Start service when device has completed boot
        context.startService(new Intent(context, CopyDropService.class));
    }
}
