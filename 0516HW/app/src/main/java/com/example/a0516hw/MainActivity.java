package com.example.a0516hw;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private Spinner spinner;
    private ListView listView;
    private TextView txvMain, txvSide, txvDrink;



    private void updateListView(int position) {
        ArrayAdapter<CharSequence> arrayAdapter;
        switch (position) {
            case 0: // 主餐
                arrayAdapter = ArrayAdapter.createFromResource(this,
                        R.array.MainDish, android.R.layout.simple_list_item_1);
                listView.setAdapter(arrayAdapter);
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        String selectedDish = parent.getItemAtPosition(position).toString();
                        txvMain.setText(selectedDish);
                    }
                });
                break;
            case 1: // 附餐
                arrayAdapter = ArrayAdapter.createFromResource(this,
                        R.array.SideDish, android.R.layout.simple_list_item_1);
                listView.setAdapter(arrayAdapter);
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        String selectedDish = parent.getItemAtPosition(position).toString();
                        txvSide.setText(selectedDish);
                    }
                });
                break;
            case 2: // 飲料
                arrayAdapter = ArrayAdapter.createFromResource(this,
                        R.array.Drink, android.R.layout.simple_list_item_1);
                listView.setAdapter(arrayAdapter);
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        String selectedDish = parent.getItemAtPosition(position).toString();
                        txvDrink.setText(selectedDish);
                    }
                });
                break;
            default:
                arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1);
        }
    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        spinner = findViewById(R.id.spinner);
        listView = findViewById(R.id.listView);
        txvMain = findViewById(R.id.txvMain);
        txvSide = findViewById(R.id.txvSide);
        txvDrink = findViewById(R.id.txvDrink);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.meal, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                updateListView(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // Do nothing
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // 設置要用哪個menu檔做為選單
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_cancel) {
            // 清除所有 TextView 的内容
            txvMain.setText("");
            txvSide.setText("");
            txvDrink.setText("");
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
