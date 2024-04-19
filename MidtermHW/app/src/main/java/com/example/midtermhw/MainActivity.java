package com.example.midtermhw;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 連結男生和女生單選按鈕元素
        RadioButton boy = findViewById(R.id.rdbBoy);
        RadioButton girl = findViewById(R.id.rdbGirl);

        // 連結票種按鈕元素
        RadioButton adult = findViewById(R.id.rdbAdult);
        RadioButton child = findViewById(R.id.rdbChild);
        RadioButton student = findViewById(R.id.rdbStudent);

        // 連結票種和性別選擇群組元素
        RadioGroup type = findViewById(R.id.rgType);
        RadioGroup gender = findViewById(R.id.rgGender);

        // 連結結果顯示文本框元素
        TextView output = findViewById(R.id.lblOutput);

        // 連結數字輸入框元素
        EditText numberInput = findViewById(R.id.edtNumber);

        // 設置全票按鈕的選擇監聽器
        adult.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                int price = 500 * Integer.parseInt(numberInput.getText().toString());
                output.setText(getGender(gender) + "全票\n" + numberInput.getText().toString() + "張，合計"+ price + "元" );
            }
        });

        // 設置兒童票按鈕的選擇監聽器
        child.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                int price = 250 * Integer.parseInt(numberInput.getText().toString());
                output.setText(getGender(gender) + "兒童票\n" + numberInput.getText().toString() + "張，合計"+ price + "元" );
            }
        });

        // 設置學生票按鈕的選擇監聽器
        student.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                int price = 400 * Integer.parseInt(numberInput.getText().toString());
                output.setText(getGender(gender) + "學生票\n" + numberInput.getText().toString() + "張，合計"+ price + "元" );
            }
        });

        // 設置票種和性別選擇群組的選擇監聽器
        type.setOnCheckedChangeListener((group, checkedId) -> {
            int price = 0;
            if (adult.isChecked()) {
                price = 500 * Integer.parseInt(numberInput.getText().toString());
            } else if (child.isChecked()) {
                price = 250 * Integer.parseInt(numberInput.getText().toString());
            } else if (student.isChecked()) {
                price = 400 * Integer.parseInt(numberInput.getText().toString());
            }
            output.setText(getGender(gender) + getTicketType(adult, child, student) + numberInput.getText().toString() + "張，合計"+ price + "元" );
        });

        gender.setOnCheckedChangeListener((group, checkedId) -> {
            int price = 0;
            if (adult.isChecked()) {
                price = 500 * Integer.parseInt(numberInput.getText().toString());
            } else if (child.isChecked()) {
                price = 250 * Integer.parseInt(numberInput.getText().toString());
            } else if (student.isChecked()) {
                price = 400 * Integer.parseInt(numberInput.getText().toString());
            }
            output.setText(getGender(gender) + getTicketType(adult, child, student) + numberInput.getText().toString() + "張，合計"+ price + "元" );
        });
    }

    // 取得性別
    private String getGender(RadioGroup gender) {
        switch (gender.getCheckedRadioButtonId()) {
            case R.id.rdbBoy:
                return "男生\n";
            case R.id.rdbGirl:
                return "女生\n";
        }
        return null;
    }

    // 取得票種
    private String getTicketType(RadioButton adult, RadioButton child, RadioButton student) {
        if (adult.isChecked()) {
            return "全票\n";
        } else if (child.isChecked()) {
            return "兒童票\n";
        } else if (student.isChecked()) {
            return "學生票\n";
        } else {
            return "";
        }
    }
}
