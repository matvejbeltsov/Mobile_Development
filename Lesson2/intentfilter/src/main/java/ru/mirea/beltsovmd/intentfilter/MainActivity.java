package ru.mirea.beltsovmd.intentfilter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class
MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button shareButton = findViewById(R.id.shareButton);
        shareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shareData();
            }
        });
    }
    private void shareData() {
        Intent shareIntent = new Intent(Intent.ACTION_SEND);
        shareIntent.setType("text/plain");
        shareIntent.putExtra(Intent.EXTRA_SUBJECT, "MIREA");
        shareIntent.putExtra(Intent.EXTRA_TEXT, "Бельцов Матвей Дмитриевич");
        startActivity(Intent.createChooser(shareIntent, "МОИ ФИО"));
    }
    public void openBrowser(View view) {
        // Создаем намерение для открытия веб-браузера
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://ya.ru/"));
        startActivity(browserIntent);
    }
}