package com.example.logindemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText Name;
    private EditText Password;
    private TextView info;
    private Button Login;
    private int attempts=5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Name=(EditText)findViewById(R.id.etName);
        Password=(EditText) findViewById(R.id.etPassword);
        info=(TextView) findViewById(R.id.tvinfo);
        Login=(Button)findViewById(R.id.btn);
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate(Name.getText().toString(),Password.getText().toString());


            }
        });

    }
    private void validate(String userName,String userPassword){
        if((userName.equals("Admin"))&&(userPassword.equals("1234"))){
            Intent i=new Intent(this,secondActivity.class);
            startActivity(i);
        }
        else{
            attempts--;
            info.setText(String.valueOf(attempts));
            if(attempts==0){
                Login.setEnabled(false);
            }
        }
    }
}
