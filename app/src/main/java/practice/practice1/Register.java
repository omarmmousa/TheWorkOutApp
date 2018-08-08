package practice.practice1;

import android.os.Bundle;
import android.content.Intent;
import android.provider.BaseColumns;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.text.TextUtils;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.database.Cursor;
import java.util.List;

public class Register extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        final DbHandler db = new DbHandler(this);



        final EditText fName = (EditText) findViewById(R.id.fName);
        final EditText lName = (EditText) findViewById(R.id.lName);
        final EditText email = (EditText) findViewById(R.id.Email);
        final EditText passwd = (EditText) findViewById(R.id.password);

        final Button reg = (Button) findViewById(R.id.reg);



        reg.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(fName.getText())){fName.setError("Required Field");}
                else if (TextUtils.isEmpty(lName.getText())){lName.setError("Required Field");}
                else if (TextUtils.isEmpty(email.getText())){email.setError("Required Field");}
                else if (TextUtils.isEmpty(passwd.getText())){passwd.setError("Required Field");}
                else{Intent regIntent = new Intent(Register.this, Welcome.class);
                    Log.d("Insert:" , "Inserting ... ");
                    String fName1 = fName.getText().toString();
                    String lName1 = lName.getText().toString();
                    String email1 = email.getText().toString();
                    String passwd1 = passwd.getText().toString();
                    db.addUser(new User(fName1, lName1, email1, passwd1));
                    Register.this.startActivity(regIntent);}
                    finish();
            }
        });
    }
}

