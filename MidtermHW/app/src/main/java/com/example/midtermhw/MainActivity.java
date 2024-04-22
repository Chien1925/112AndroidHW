package com.example.midtermhw;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RadioButton boy = findViewById(R.id.rdbBoy);
        RadioButton girl = findViewById(R.id.rdbGirl);

        RadioButton adult = findViewById(R.id.rdbAdult);
        RadioButton child = findViewById(R.id.rdbChild);
        RadioButton student = findViewById(R.id.rdbStudent);

        RadioGroup type = findViewById(R.id.rgType);
        RadioGroup gender = findViewById(R.id.rgGender);

        TextView output = findViewById(R.id.lblOutput);

        EditText numberInput = findViewById(R.id.edtNumber);

        numberInput.addTextChangedListener(new android.text.TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                updateOutput();
            }

            @Override
            public void afterTextChanged(android.text.Editable s) {}
        });

        type.setOnCheckedChangeListener((group, checkedId) -> updateOutput());
        gender.setOnCheckedChangeListener((group, checkedId) -> updateOutput());

        Button btnConfirm = findViewById(R.id.btnConfirm);
        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String outputText = output.getText().toString();
                Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                intent.putExtra("outputText", outputText);
                startActivity(intent);
            }
        });
    }

    private void updateOutput() {
        TextView output = findViewById(R.id.lblOutput);
        EditText numberInput = findViewById(R.id.edtNumber);

        String genderText = "";
        RadioButton boy = findViewById(R.id.rdbBoy);
        RadioButton girl = findViewById(R.id.rdbGirl);
        if (boy.isChecked()) {
            genderText = "男生";
        } else if (girl.isChecked()) {
            genderText = "女生";
        }

        String ticketTypeText = "";
        RadioButton adult = findViewById(R.id.rdbAdult);
        RadioButton child = findViewById(R.id.rdbChild);
        RadioButton student = findViewById(R.id.rdbStudent);
        if (adult.isChecked()) {
            ticketTypeText = "全票";
        } else if (child.isChecked()) {
            ticketTypeText = "兒童票";
        } else if (student.isChecked()) {
            ticketTypeText = "學生票";
        }

        if (!TextUtils.isEmpty(numberInput.getText().toString())) {
            int price = 0;
            if (adult.isChecked()) {
                price = 500 * Integer.parseInt(numberInput.getText().toString());
            } else if (child.isChecked()) {
                price = 250 * Integer.parseInt(numberInput.getText().toString());
            } else if (student.isChecked()) {
                price = 400 * Integer.parseInt(numberInput.getText().toString());
            }
            output.setText(genderText +"\n"+ ticketTypeText + "\n" + numberInput.getText().toString() + "張\n"+"合計" + price + "元");
        } else {
            output.setText(genderText+"\n" + ticketTypeText+"\n" + "請輸入張數");
        }
    }
}
