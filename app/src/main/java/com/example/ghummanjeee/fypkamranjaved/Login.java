package com.example.ghummanjeee.fypkamranjaved;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Login extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener firebaseAuthListener;
    private static final String TAG = "LoginActivity";

    Button login;
    EditText _emailText,_passwordText;


    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mAuth = FirebaseAuth.getInstance();
        firebaseAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                if (user != null) {
                    Intent intent = new Intent(Login.this,Event_Manu.class);
                    startActivity(intent);
                    finish();
                    return;
                } else {

                    Toast.makeText(Login.this, "Please First Registration", Toast.LENGTH_SHORT).show();
                }

            }
        };

        _emailText=(EditText)findViewById(R.id.login_email);
        _passwordText=(EditText)findViewById(R.id.login_pass);
        login=(Button)findViewById(R.id.login_btn);
        TextView registration=(TextView)findViewById(R.id.login_text2);

        registration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Login.this,Registration.class);
                startActivity(intent);
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    final String email = _emailText.getText().toString();
                    final String password = _passwordText.getText().toString();
                    mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(Login.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (!task.isSuccessful()) {
                                Toast.makeText(Login.this, "sign in error", Toast.LENGTH_SHORT).show();
                            }
                        }

                    });
                user_login();
            }

        });

    }
    public void user_login(){

        if (TextUtils.isEmpty(_emailText.toString().trim()) || TextUtils.isEmpty(_emailText.toString().trim())){

            _emailText.setError("Field should not be Empty");
            _passwordText.setError("Field should not be Empty");
        }
        else{
                Intent intent=new Intent(Login.this,Home.class);
                startActivity(intent);
        }
    }

}
