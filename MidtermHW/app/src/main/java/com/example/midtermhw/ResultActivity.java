package com.example.midtermhw;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        // 從Intent中獲取MainActivity中的lblOutput的內容
        String outputText = getIntent().getStringExtra("outputText");

        // 將內容設置到resultTxv中
        TextView resultTxv = findViewById(R.id.resultTxv);
        resultTxv.setText(outputText);

        Button btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 創建一個Intent物件來切換到MainActivity
                Intent intent = new Intent(ResultActivity.this, MainActivity.class);
                startActivity(intent); // 啟動MainActivity
            }
        });
    }
}
