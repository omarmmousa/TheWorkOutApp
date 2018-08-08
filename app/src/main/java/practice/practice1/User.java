package practice.practice1;

import android.content.Context;
import android.widget.EditText;
import java.lang.String;

public class User {

    int id;
    String fName;
    String lName;
    String email;
    String passwd;

    public User(){}

    public User(int id, String fName, String lName, String email, String passwd){
        this.id = id;
        this.fName = fName;
        this.lName = lName;
        this.email = email;
        this.passwd = passwd;
    }

    public User(String fName, String lName, String email, String passwd){
        this.fName = fName;
        this.lName = lName;
        this.email = email;
        this.passwd = passwd;
    }


    //ID setters and getters
    public int getId(){return this.id;}
    public void setId(int id){this.id = id;}

    //First Name Setters and Getters
    public String getFname(){return this.fName;}
    public void setFname(String fName){this.fName = fName;}

    //Last Name Setters and Getters
    public String getLname(){return this.lName;}
    public void setLname(String lName){this.lName = lName;}

    //Email setters and getters
    public String getEmail(){return this.email;}
    public void setEmail(String email){this.email = email;}

    //Password setters and getters
    public String getPasswd(){return this.passwd;}
    public void setPasswd(String passwd){this.passwd = passwd;}
}
