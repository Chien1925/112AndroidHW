package com.example.spandlv;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.view.View;
import android.widget.Button;

public class ResultActivity extends AppCompatActivity {

    private TextView txvMain, txvSide, txvDrink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        txvMain = findViewById(R.id.txvMain);
        txvSide = findViewById(R.id.txvSide);
        txvDrink = findViewById(R.id.txvDrink);
        Button btnBack = findViewById(R.id.btnBack);

        Intent intent = getIntent();
        String mainDish = intent.getStringExtra("MAIN_DISH");
        String sideDish = intent.getStringExtra("SIDE_DISH");
        String drink = intent.getStringExtra("DRINK");

        txvMain.setText(mainDish);
        txvSide.setText(sideDish);
        txvDrink.setText(drink);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ResultActivity.this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();
            }
        });
    }
}
