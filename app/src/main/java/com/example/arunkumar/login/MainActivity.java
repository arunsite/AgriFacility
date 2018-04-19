package com.example.arunkumar.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.jar.Attributes;

public class MainActivity extends AppCompatActivity {

    private EditText User;
    private EditText Password;
    private Button Login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        User = (EditText)findViewById(R.id.etUser);
        Password = (EditText)findViewById(R.id.etPW);
        Login = (Button) findViewById(R.id.btnLogin);

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate(User.getText().toString(),Password.getText().toString());
            }
        });

    }

    private void validate(String userName, String userPassword){
        if((userName.equals("Admin")) && (userPassword.equals("12345"))){
            Intent intent = new Intent(MainActivity.this, MapPageActivity.class);
            startActivity(intent);
        }
    }
}
