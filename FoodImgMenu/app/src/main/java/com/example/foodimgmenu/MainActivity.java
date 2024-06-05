package com.example.foodimgmenu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.CompoundButton;

public class MainActivity extends AppCompatActivity {

    private CheckBox chk1, chk2, chk3, chk4;
    private ImageView output1, output2, output3, output4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        chk1 = findViewById(R.id.chk1);
        chk2 = findViewById(R.id.chk2);
        chk3 = findViewById(R.id.chk3);
        chk4 = findViewById(R.id.chk4);

        output1 = findViewById(R.id.output1);
        output2 = findViewById(R.id.output2);
        output3 = findViewById(R.id.output3);
        output4 = findViewById(R.id.output4);

        chk1.setOnCheckedChangeListener(new CheckBoxListener(output1));
        chk2.setOnCheckedChangeListener(new CheckBoxListener(output2));
        chk3.setOnCheckedChangeListener(new CheckBoxListener(output3));
        chk4.setOnCheckedChangeListener(new CheckBoxListener(output4));
    }

    private class CheckBoxListener implements CompoundButton.OnCheckedChangeListener {
        private ImageView imageView;

        public CheckBoxListener(ImageView imageView) {
            this.imageView = imageView;
        }

        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if (isChecked) {
                imageView.setVisibility(ImageView.VISIBLE);
            } else {
                imageView.setVisibility(ImageView.GONE);
            }
        }
    }
}
