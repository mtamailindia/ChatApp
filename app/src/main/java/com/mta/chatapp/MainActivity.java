package com.mta.chatapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.demach.konotor.Konotor;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button myFeedbackButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myFeedbackButton = (Button) findViewById(R.id.button);
        myFeedbackButton.setOnClickListener(this);
    }

    @Override
    protected void onResume() {
        String id = System.currentTimeMillis() + "ashish@domain.com";
        super.onResume();
        Konotor.getInstance(getApplicationContext())
                .withUserName("ashish")            // optional name by which to display the user
                .withIdentifier(id)            // optional unique identifier for your reference
                .withUserEmail("ashish@domain.com")        // optional email address of the user
                .withUserMeta("age", "25")            // optional metadata for your user
                .withLaunchMainActivityOnFinish(true) // to launch your app on hitting the back button on Konotor's inbox interface, in case the app was not running already
                .init(getString(R.string.APP_ID),getString(R.string.APP_KEY));
//                .update();

        Konotor.getInstance(getApplicationContext())
                .withSupportName("Ashish") // optional - custom user name for support/marketing messages
                .withFeedbackScreenTitle("Anurag pal") 	// optional - title to display when asking for feedback
                .withNoAudioRecording(true) // optional - set true to disable voice messaging
                .withNoPictureMessaging(true) // optional - set true to disable sending images from camera/gallery
                .withUsesCustomSupportImage(false) // optional - set to true to use a different image to represenent the app on the messaging screen. Replace konotor_support_image.png with your desired image
                .withCustomNotificationIcon((int)R.drawable.info) // optional - set this to an R.drawable's resource id to use an icon of your choice for notifications. Ideally create a notification icon that is in line with Android's new guidlines for notification icons (sillhouette-style)
                .withWelcomeMessage("Hi there !")		// optional - custom welcome message for your app
                .withLinking("yourapp://[a-z0-9A-Z]+", "yourapp") // optional - to enable Konotor to recognize a custom deep linking scheme for your app
                .withOneWayInbox(false) // optional - set to true to turn off two-way communication for the user (can only see messages from you. Cannot respond)
                .withNoNotificationSound(false) // optional - set to try to turn off notification sounds
                .withDefaultPriority(0) // optional - set the default notification priority - 0 by default
                .init(getString(R.string.APP_ID),getString(R.string.APP_KEY));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button :
                Konotor.getInstance(getApplicationContext()).launchFeedbackScreen(MainActivity.this);
                break;
        }
    }
}
