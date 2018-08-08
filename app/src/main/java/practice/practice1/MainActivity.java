/**
 * Author: Omar Mousa
 * Description: The Work Out app is a strength analyzer and allows people to monitor
 *              how strong they get by entering their workouts.
 *              Will be implementing trends and ML algorithms to build a regimen
 *              while the person monitors their weight.
 *
 * Date: 07-AUG-2018
 *
 *
 * The Main Splash Page
 */


package practice.practice1;

import android.os.Bundle;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends AppCompatActivity  {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Gets the activity_main.xml view
        setContentView(R.layout.activity_main);

        //Takes app to the registration activity on click
        final Button register = (Button) findViewById(R.id.register);
        //listens for the click and assigns and intent for what the buttons is used for
        register.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                        Intent registerIntent = new Intent(MainActivity.this, Register.class);
                        MainActivity.this.startActivity(registerIntent);
                        //ends the activity
                        finish();
                }
        });
    }
}
