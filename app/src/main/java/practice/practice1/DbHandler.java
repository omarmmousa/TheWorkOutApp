package practice.practice1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.EditText;
import java.util.ArrayList;
import java.util.List;


public class DbHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "TheWorkOut";
    private static final String TABLE_NAME = "registered_users";
    private static final String KEY_ID = "id";
    private static final String KEY_FIRST_NAME = "first_name";
    private static final String KEY_LAST_NAME = "last_name";
    private static final String KEY_EMAIL = "email";
    private static final String KEY_PASSWORD = "password";

    public DbHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE_NAME = "CREATE TABLE " + TABLE_NAME + "("
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + KEY_FIRST_NAME
                + " TEXT," + KEY_LAST_NAME + " TEXT," + KEY_EMAIL + " TEXT," + KEY_PASSWORD
                + " TEXT " + ")";

        db.execSQL(CREATE_TABLE_NAME);
    }

    public Cursor getUser(SQLiteDatabase db) {
        String SELECT_USER = "SELECT * FROM " + TABLE_NAME;
        Log.d("User: ", "Users: ");
        return db.rawQuery(SELECT_USER, null);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);

        // Create tables again
        onCreate(db);
    }

    void addUser(User user) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(KEY_FIRST_NAME, user.getFname().toString()); // User First Name
        values.put(KEY_LAST_NAME, user.getLname().toString()); // User Last Name
        values.put(KEY_EMAIL, user.getEmail().toString());//user Email
        values.put(KEY_PASSWORD, user.getPasswd().toString());

        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    public Cursor getUserinfo(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor user = db.rawQuery("select * from " + TABLE_NAME, null);
        return user;
    }


}
