package com.example.ghummanjeee.fypkamranjaved;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class main extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button registration,login;

        registration=(Button)findViewById(R.id.reg_btn);
        login=(Button)findViewById(R.id.login_btn1);

    //Registration button//

       registration.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
              Intent intent=new Intent(main.this,Registration.class);
               startActivity(intent);
           }
       });

        //Login Button//

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(main.this,Login.class);
                startActivity(intent);
            }
        });
    }
}
