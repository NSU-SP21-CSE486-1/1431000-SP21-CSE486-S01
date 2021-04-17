package com.example.android.shoppingList;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView item1;
    private TextView item2;
    private TextView item3;
    private TextView item4;
    private TextView item5;
    private TextView item6;
    private TextView item7;
    private TextView item8;
    private TextView item9;
    private TextView item10;
    public static final int TEXT_REQUEST = 1;
    public int count = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        item1 = findViewById(R.id.main_item1);
        item2 = findViewById(R.id.main_item2);
        item3 = findViewById(R.id.main_item3);
        item4 = findViewById(R.id.main_item4);
        item5 = findViewById(R.id.main_item5);
        item6 = findViewById(R.id.main_item6);
        item7 = findViewById(R.id.main_item7);
        item8 = findViewById(R.id.main_item8);
        item9 = findViewById(R.id.main_item9);
        item10 = findViewById(R.id.main_item10);

        if(savedInstanceState != null){
            item1.setText(savedInstanceState.getString("main_item1"));
            item2.setText(savedInstanceState.getString("main_item2"));
            item3.setText(savedInstanceState.getString("main_item3"));
            item4.setText(savedInstanceState.getString("main_item4"));
            item5.setText(savedInstanceState.getString("main_item5"));
            item6.setText(savedInstanceState.getString("main_item6"));
            item7.setText(savedInstanceState.getString("main_item7"));
            item8.setText(savedInstanceState.getString("main_item8"));
            item9.setText(savedInstanceState.getString("main_item9"));
            item10.setText(savedInstanceState.getString("main_item10"));
            count = savedInstanceState.getInt("count");



        }
    }

    public void addItemLaunch(View view) {
        Intent intent = new Intent(this, MainActivity2.class);
        startActivityForResult(intent, TEXT_REQUEST);
    }

    @Override
    public void onActivityResult(int requestCode,
                                 int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == TEXT_REQUEST) {
            if (resultCode == RESULT_OK) {
                String reply = data.getStringExtra(MainActivity2.EXTRA_REPLY);
                data.getStringExtra(MainActivity2.EXTRA_REPLY);
                addItemToList(reply);
            }
        }
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putString("main_item1", item1.getText().toString());
        savedInstanceState.putString("main_item2", item2.getText().toString());
        savedInstanceState.putString("main_item3", item3.getText().toString());
        savedInstanceState.putString("main_item4", item4.getText().toString());
        savedInstanceState.putString("main_item5", item5.getText().toString());
        savedInstanceState.putString("main_item6", item6.getText().toString());
        savedInstanceState.putString("main_item7", item7.getText().toString());
        savedInstanceState.putString("main_item8", item8.getText().toString());
        savedInstanceState.putString("main_item9", item9.getText().toString());
        savedInstanceState.putString("main_item10", item10.getText().toString());
        savedInstanceState.putInt("count" , count);
    }

    public void addItemToList(String returnItem){
        switch (count){
            case 10: {
             item10.setText(returnItem);
             item10.setVisibility(View.VISIBLE);
             count++;
             break;
            }
            case 1: {
                item1.setText(returnItem);
                item1.setVisibility(View.VISIBLE);
                count++;
                break;
            }
            case 2: {
                item2.setText(returnItem);
                item2.setVisibility(View.VISIBLE);
                count++;
                break;
            }
            case 3: {
                item3.setText(returnItem);
                item3.setVisibility(View.VISIBLE);
                count++;
                break;
            }
            case 4: {
                item4.setText(returnItem);
                item4.setVisibility(View.VISIBLE);
                count++;
                break;
            }
            case 5: {
                item5.setText(returnItem);
                item5.setVisibility(View.VISIBLE);
                count++;
                break;
            }
            case 6: {
                item6.setText(returnItem);
                item6.setVisibility(View.VISIBLE);
                count++;
                break;
            }
            case 7: {
                item7.setText(returnItem);
                item7.setVisibility(View.VISIBLE);
                count++;
                break;
            }
            case 8: {
                item8.setText(returnItem);
                item8.setVisibility(View.VISIBLE);
                count++;
                break;
            }
            case 9: {
                item9.setText(returnItem);
                item9.setVisibility(View.VISIBLE);
                count++;
                break;
            }
            default:{
                break;
            }
        }

    }

    public void emptyList(View view) {
        item1.setText("");
        item2.setText("");
        item3.setText("");
        item4.setText("");
        item5.setText("");
        item6.setText("");
        item7.setText("");
        item8.setText("");
        item9.setText("");
        item10.setText("");
        count = 1;
    }
}