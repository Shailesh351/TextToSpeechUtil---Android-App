package me.shell.texttospeechutil;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Switch mServiseOnOffSwitch;
    private ServiceState mServiceState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mServiceState = new ServiceState(getApplicationContext());

        mServiseOnOffSwitch = (Switch) findViewById(R.id.service_on_off_switch);

        if(mServiceState.isServiceOn()){
            mServiseOnOffSwitch.setChecked(true);
        }else {
            mServiseOnOffSwitch.setChecked(false);
        }

        mServiseOnOffSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if(isChecked == true){
                    startService(new Intent(getApplication(), CopyDropService.class));
                    mServiceState.setServiveState(true);
                    Log.d("test", "service started from start Service");
                    Toast.makeText(MainActivity.this, "service started",Toast.LENGTH_SHORT).show();
                }else {
                    stopService(new Intent(getApplication(), CopyDropService.class));
                    mServiceState.setServiveState(false);
                    Log.d("test", "service stoped from stop Service");
                    Toast.makeText(MainActivity.this, "service stoped",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
