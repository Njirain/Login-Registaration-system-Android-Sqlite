package com.example.loginsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText editTextuser,editTextpass;
   private TextView textView;
    private Button btnlogin,btnsignup;
    DbCode dbCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dbCode = new DbCode(this);
        btnlogin = (Button)findViewById(R.id.btnlogin);
        btnsignup = (Button)findViewById(R.id.btnsignup);
        btnlogin.setOnClickListener(v->{
            Login();
        });
        btnsignup.setOnClickListener(v->{
            signup();
        });
    }

  public void Login(){
          editTextuser = (EditText) findViewById(R.id.editpass);
          editTextpass = (EditText) findViewById(R.id.editpass);
          textView = (TextView)findViewById(R.id.confirm);
          String username = editTextuser.getText().toString();
          String password = editTextpass.getText().toString();
          if(username.isEmpty()&&password.isEmpty()){
              textView.setText("username and password required!!");
          }else if(username.isEmpty()||password.isEmpty()){
              textView.setText("Fill in both fields!!..");
          }else {
             if( dbCode.CheckUserPass(username,password)){
                startActivity( new Intent(MainActivity.this,WelcomePage.class));
             }else{
                 Toast.makeText(getApplicationContext(),"Username and password mismath!!",Toast.LENGTH_LONG).show();
             }
          }
  }
  public  void signup(){
   startActivity(new Intent(MainActivity.this,SignUp.class));
  }

}