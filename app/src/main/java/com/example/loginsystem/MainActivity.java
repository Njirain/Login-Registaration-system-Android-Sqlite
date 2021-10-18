package com.example.loginsystem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
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
          editTextuser =  findViewById(R.id.edituser);
          editTextpass =  findViewById(R.id.editpass);
          textView = findViewById(R.id.confirm);
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected( MenuItem item) {
        // demo on one item
        // item.getItemId(); returns int value so I pass direct
        switch (item.getItemId()){
            case R.id.item1:
                Toast.makeText(getApplicationContext(),"Item1 selected",Toast.LENGTH_LONG).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}