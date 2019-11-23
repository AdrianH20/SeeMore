package com.example.seemore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public String usernamesLogin[] = {"adrian","cristi","seba","victor"};
    public String passwordsLogin[] = {"1234","1234","1234","1234"};

    TextView usernameTextView;
    TextView passwordTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usernameTextView =  findViewById(R.id.usernameId);
        passwordTextView =  findViewById(R.id.passwordId);



    }



    public void checkSignIn(View view) {

        Intent intent = new Intent(this, SeeMoreActivity.class);
        for(int i = 0; i<usernamesLogin.length; i++)
        {

            if(usernamesLogin[i].equals(usernameTextView.getText().toString()) && passwordsLogin[i].equals(passwordTextView.getText().toString()))
            {
                startActivity(intent);
                break;
            }

        }



    }
}
