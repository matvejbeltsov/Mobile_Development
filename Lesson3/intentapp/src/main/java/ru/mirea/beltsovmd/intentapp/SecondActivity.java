package ru.mirea.beltsovmd.intentapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    TextView displayTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        displayTextView = findViewById(R.id.displayTextView);

        // Получаем переданное из первой активности время
        String currentTime = getIntent().getStringExtra("currentTime");

        // Формируем строку для отображения
        String displayText = "КВАДРАТ ЗНАЧЕНИЯ МОЕГО НОМЕРА ПО СПИСКУ В ГРУППЕ СОСТАВЛЯЕТ 36, а текущее время " + currentTime;

        // Устанавливаем текст в TextView
        displayTextView.setText(displayText);
    }
}