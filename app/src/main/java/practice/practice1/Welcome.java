/**
 * The Welcome page that will appear after a successful login and registration
 */


package practice.practice1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.widget.Button;
import android.view.View;
import android.view.View.OnClickListener;


public class Welcome extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        Button userProfile = (Button) findViewById(R.id.Profile);
        DbHandler db = new DbHandler(this);

        userProfile.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent viewProfile = new Intent(Welcome.this, Profile.class);
                Welcome.this.startActivity(viewProfile);
            }
        });
    }
}
