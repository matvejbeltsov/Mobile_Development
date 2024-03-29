package ru.mirea.beltsovmd.favoritebook;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class ShareActivity extends AppCompatActivity {

    public static final String USER_MESSAGE = "MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share);

        // Получение данных из MainActivity
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String bookName = extras.getString(MainActivity.KEY);
            TextView textViewBook = findViewById(R.id.textViewBook);
            textViewBook.setText(String.format("Любимая книга разработчика: %s", bookName));
        }
    }

    // Метод вызывается при нажатии на кнопку
    public void shareBookName(View view) {
        EditText editTextBook = findViewById(R.id.editTextBook);
        String userBook = editTextBook.getText().toString();

        // Отправка введенных пользователем данных обратно в MainActivity
        Intent data = new Intent();
        data.putExtra(USER_MESSAGE, userBook);
        setResult(Activity.RESULT_OK, data);
        finish();
    }
}