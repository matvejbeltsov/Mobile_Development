package ru.mirea.beltsovmd.intentapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    TextView currentTimeTextView;
    Button goToSecondActivityButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        currentTimeTextView = findViewById(R.id.currentTimeTextView);
        goToSecondActivityButton = findViewById(R.id.goToSecondActivityButton);

        // Получаем текущее системное время
        long dateInMillis = System.currentTimeMillis();
        String format = "yyyy-MM-dd HH:mm:ss";
        final SimpleDateFormat sdf = new SimpleDateFormat(format);
        String currentTime = sdf.format(new Date(dateInMillis));
        currentTimeTextView.setText(currentTime);

        goToSecondActivityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Передаем текущее время второй активности
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("currentTime", currentTime);
                startActivity(intent);
            }
        });
    }
}