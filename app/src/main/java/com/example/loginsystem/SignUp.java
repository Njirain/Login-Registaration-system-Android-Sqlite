package com.example.loginsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class SignUp extends AppCompatActivity {
    DbCode dbCode = new DbCode(this);
  private Button btnsign;
  private EditText user,pass,email,password2;
 private RadioButton male,female;
   String gender;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        btnsign = (Button) findViewById(R.id.btnsign);
        btnsign.setOnClickListener(v -> {
             Register();
        });
    }
    private void Register(){
        user = (EditText) findViewById(R.id.getuser);
        pass = (EditText)findViewById(R.id.getpass);
        password2 = (EditText) findViewById(R.id.getpass2);
        email = (EditText) findViewById(R.id.getemail);
        male = (RadioButton) findViewById(R.id.radiomale);
        female = (RadioButton) findViewById(R.id.radiofemale);
       if (male.isChecked()){
           gender = "Male";
       }
       else if (female.isChecked()){
           gender = "Female";
       }
       String username = user.getText().toString();
       String passfile = ConfirmPass(pass.getText().toString(),password2.getText().toString());
       String mail = email.getText().toString();
       if(dbCode.insertData(username,passfile,mail,gender)){
           Toast.makeText(getApplicationContext(),"ACCOUNT CREATED SUCCESSFULY",Toast.LENGTH_LONG).show();
       }
       else {
           Toast.makeText(getApplicationContext(),"Unable to create your Account!!",Toast.LENGTH_LONG).show();
       }
    }
    public String ConfirmPass(String pass1,String pass2){
        String password;
        if(pass1.equals(pass2)){
            password = pass.getText().toString();
        }else{
            password = "Password mismatch!!";
        }
        return password;
    }
}