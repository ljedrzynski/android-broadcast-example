package pl.devone.android.broadcastsubscriber.broadcast;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import pl.devone.android.broadcastsubscriber.MainActivity;
import pl.devone.android.broadcastsubscriber.R;

import static android.content.Context.NOTIFICATION_SERVICE;

/**
 * Created by ljedrzynski on 26.11.2017.
 */

public class BroadcastMessageReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        try {
            Intent nextIntent = new Intent(context, MainActivity.class);

            PendingIntent pIntent = PendingIntent.getActivity(context, (int) System.currentTimeMillis(), nextIntent, 0);

            Notification messageReceived = new Notification.Builder(context)
                    .setContentTitle("Message Received")
                    .setContentText(intent.getStringExtra("msg"))
                    .setSmallIcon(R.drawable.ic_launcher_background)
                    .setContentIntent(pIntent)
                    .setAutoCancel(true)
                    .addAction(R.drawable.ic_launcher_foreground, "See", pIntent)
                    .build();

            NotificationManager notificationManager =
                    (NotificationManager) context.getSystemService(NOTIFICATION_SERVICE);

            notificationManager.notify(0, messageReceived);
        } catch (Exception e) {
            Log.e("ERROR", "Pretty bad bug:" + e.getLocalizedMessage());
        }
    }

}
