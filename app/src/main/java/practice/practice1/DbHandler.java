package practice.practice1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;
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

     User getUser(int id){
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_NAME, new String[]{KEY_FIRST_NAME, KEY_LAST_NAME, KEY_EMAIL, KEY_PASSWORD}, KEY_ID + "=?",
                new String[]{String.valueOf(id)}, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        User user = new User(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4));
        return user;
    }

    public List<User> getUsers() {
        List<User> users = new ArrayList<User>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_NAME;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                User user = new User();
                user.setId(Integer.parseInt(cursor.getString(0)));
                user.setFname(cursor.getString(1));
                user.setLname(cursor.getString(2));
                user.setEmail(cursor.getString(3));
                user.setPasswd(cursor.getString(4));
                // Adding user to list
                users.add(user);
            } while (cursor.moveToNext());
        }

        // return contact list
        return users;
    }
}
