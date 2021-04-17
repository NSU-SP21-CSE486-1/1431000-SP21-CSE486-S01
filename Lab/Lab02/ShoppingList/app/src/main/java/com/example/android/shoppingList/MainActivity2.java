package com.example.android.shoppingList;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity2 extends AppCompatActivity {

    public static final String EXTRA_REPLY = "com.example.twoactivities.extra.REPLY";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }

    public void addItemCheese(View view) {
        Intent replyIntent = new Intent();
        String reply =  "Cheese";
        replyIntent.putExtra(EXTRA_REPLY, reply);
        setResult(RESULT_OK, replyIntent);
        finish();

    }

    public void addItemsugar(View view) {
        Intent replyIntent = new Intent();
        String reply =  "Sugar";
        replyIntent.putExtra(EXTRA_REPLY, reply);
        setResult(RESULT_OK, replyIntent);
        finish();

    }

    public void addItemSalt(View view) {
        Intent replyIntent = new Intent();
        String reply =  "Salt";
        replyIntent.putExtra(EXTRA_REPLY, reply);
        setResult(RESULT_OK, replyIntent);
        finish();

    }

    public void addItemMilk(View view) {
        Intent replyIntent = new Intent();
        String reply =  "Milk";
        replyIntent.putExtra(EXTRA_REPLY, reply);
        setResult(RESULT_OK, replyIntent);
        finish();

    }

    public void addItemApples(View view) {
        Intent replyIntent = new Intent();
        String reply =  "Apples";
        replyIntent.putExtra(EXTRA_REPLY, reply);
        setResult(RESULT_OK, replyIntent);
        finish();

    }

    public void addItemRice(View view) {
        Intent replyIntent = new Intent();
        String reply =  "Rice";
        replyIntent.putExtra(EXTRA_REPLY, reply);
        setResult(RESULT_OK, replyIntent);
        finish();
    }


}