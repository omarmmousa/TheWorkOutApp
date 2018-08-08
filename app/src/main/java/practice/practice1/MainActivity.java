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

        final Button register = (Button) findViewById(R.id.register);
        register.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                        Intent registerIntent = new Intent(MainActivity.this, Register.class);
                        MainActivity.this.startActivity(registerIntent);
                        finish();
                }
        });
    }
}
