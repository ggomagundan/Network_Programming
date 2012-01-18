package kr.sprout.android;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.Gravity;
import android.widget.Toast;

public class C2dm_BroadcastReceiver extends BroadcastReceiver{
    /** Called when the activity is first created. */
static String registration_id = null;
static String c2dm_msg = "";
    @Override
    public void onReceive(Context context, Intent intent) {
     if (intent.getAction().equals("com.google.android.c2dm.intent.REGISTRATION")) {
    
     handleRegistration(context, intent);
    
     } else if (intent.getAction().equals("com.google.android.c2dm.intent.RECEIVE")) {
    
     c2dm_msg = intent.getExtras().getString("msg");
    
     System.out.println("c2dm_msg======>"+c2dm_msg);
     Toast toast = Toast.makeText(context, "메시지 도착!\n"+c2dm_msg, Toast.LENGTH_SHORT );
  toast.setGravity( Gravity.TOP | Gravity.CENTER, 0, 150 );
  toast.show();
    
     }
    }
    
    private void handleRegistration(Context context, Intent intent) {
    
     registration_id = intent.getStringExtra("registration_id");
    
     System.out.println("registration_id====>"+registration_id);
    
     if (intent.getStringExtra("error") != null) {
    
     Log.v("C2DM_REGISTRATION",">>>>>" + "Registration failed, should try again later." + "<<<<<");
    
     } else if (intent.getStringExtra("unregistered") != null) {

     Log.v("C2DM_REGISTRATION",">>>>>" + "unregistration done, new messages from the authorized sender will be rejected" + "<<<<<");
    
     } else if (registration_id != null) {
    
     System.out.println("registration_id complete!!");
     }
    }
    
    
}