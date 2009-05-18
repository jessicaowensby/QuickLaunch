package com.jros;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class QuickLaunch extends Activity {
	private static final int NOTIFY_ME_ID=1337;  
	  
	  @Override 
	  public void onCreate(Bundle savedInstanceState) { 
	    super.onCreate(savedInstanceState); 
	    setContentView(R.layout.main); 
	    
	    Button btn=(Button)findViewById(R.id.notify); 
	    
	    btn.setOnClickListener(new View.OnClickListener() { 
	      public void onClick(View view) {  
	    	  notifyMe();
	      } 
	    }); 
	    
	    btn=(Button)findViewById(R.id.cancel); 
	    
	    btn.setOnClickListener(new View.OnClickListener() { 
	      public void onClick(View view) { 
	          NotificationManager mgr= (NotificationManager)getSystemService(NOTIFICATION_SERVICE); 
	          mgr.cancel(NOTIFY_ME_ID); 
	          } 
	        }); 
	  } 
	      
	      private void notifyMe() { 
	        final NotificationManager mgr= 
	          (NotificationManager)getSystemService(NOTIFICATION_SERVICE); 
	        Notification note=new Notification(R.drawable.note, "", System.currentTimeMillis()); 
	        note.flags |= Notification.FLAG_NO_CLEAR;
	        PendingIntent i=PendingIntent.getActivity(this, 0, new Intent(this, QuickLaunch.class), 0); 
	        note.setLatestEventInfo(this, "Notification Title", 
	                               "This is the notification message", i); 
	        
	        mgr.notify(NOTIFY_ME_ID, note); 
	      }
}