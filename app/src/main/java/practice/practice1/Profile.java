package practice.practice1;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Button;
import android.view.View;
import android.view.View.OnClickListener;
import android.text.TextUtils;
import android.widget.ListView;
import android.database.Cursor;
import android.widget.Toast;
import android.widget.ListAdapter;
import android.util.Log;

import java.lang.reflect.Array;
import java.util.List;
import java.util.ArrayList;


public class Profile extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        ListView users = (ListView) findViewById(R.id.Profile);
        DbHandler db = new DbHandler(this);

        ArrayList<String> userList = new ArrayList<>();
        Cursor userInfo = db.getUserinfo();
        if(userInfo.getCount() == 0) {
            Toast.makeText(this, "There are no users in the db", Toast.LENGTH_LONG).show();
        }else{
            while(userInfo.moveToNext()){
                userList.add(userInfo.getString(1));
                ListAdapter list = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, userList);
                users.setAdapter(list);
            }
        }
    }
}
