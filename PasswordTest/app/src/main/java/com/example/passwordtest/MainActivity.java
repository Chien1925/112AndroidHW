package com.example.passwordtest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void  stringSend(View view){
        EditText edtAccount = (EditText) findViewById(R.id.edtAccount);
        EditText edtPassword = (EditText) findViewById(R.id.edtPassword);
        TextView txtShow=(TextView) findViewById(R.id.txtShow);
        String Account = edtAccount.getText().toString();
        String Password= edtPassword.getText().toString();
        if(Password.equals("SHU03807612")){
            txtShow.setText("Hello " + Account);
        }
        else {
            txtShow.setText("密碼錯誤!");
        }




    }

}