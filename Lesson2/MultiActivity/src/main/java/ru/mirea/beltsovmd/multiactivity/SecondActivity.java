package ru.mirea.beltsovmd.multiactivity;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;

import android.widget.TextView;


import ru.mirea.beltsovmd.phonetabletmodule.R;

public class SecondActivity extends AppCompatActivity {

    TextView displayText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        displayText = findViewById(R.id.displayText);

        Intent intent = getIntent();
        if (intent != null) {
            String text = intent.getStringExtra("text");
            displayText.setText(text);
        }
        Log.d("SecondActivity", "onCreate() вызван");
    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.d("SecondActivity", "onStart() вызван");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("SecondActivity", "onResume() вызван");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("SecondActivity", "onPause() вызван");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("SecondActivity", "onStop() вызван");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("SecondActivity", "onDestroy() вызван");
    }


}