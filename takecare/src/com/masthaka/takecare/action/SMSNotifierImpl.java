package com.masthaka.takecare.action;

import java.util.Random;

import com.masthaka.takecare.ImhApplication;

import winterwell.jtwitter.Twitter;

import android.content.Context;
import android.os.Message;
import android.telephony.SmsManager;
import android.text.TextUtils;
import android.util.Log;

public class SMSNotifierImpl implements ImhINotifier {

	private static final String TAG = "SMSNotifierImpl";
	static Twitter twitter;
	static{
		twitter = new Twitter("student", "password");
		twitter.setAPIRootUrl("http://yamba.marakana.com/api");
		
	}

	@Override
	public void execute(Context context) {
		SmsManager smsManager = SmsManager.getDefault();

		double lat = ((ImhApplication)context.getApplicationContext()).getLocation().getLatitude();
		double lng = ((ImhApplication)context.getApplicationContext()).getLocation().getLongitude();
		Log.d(TAG, "############## Sms Sent lat=" + lat + " lng=" + lng);

		sendNotification("Test! i'am @ https://maps.google.com/maps?q=" + lat
				+ "," + lng);

		// smsManager.sendTextMessage("9686682256", null, new Random().nextInt()
		// + "", null, null);
	}

	public synchronized void sendNotification(String loc) {
		
		twitter.updateStatus(loc);

	}

}