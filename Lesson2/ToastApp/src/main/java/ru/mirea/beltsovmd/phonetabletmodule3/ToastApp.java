package ru.mirea.beltsovmd.phonetabletmodule3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ToastApp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toast_app);

        EditText editText = findViewById(R.id.editText);
        Button buttonCount = findViewById(R.id.buttonCount);
        buttonCount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputText = editText.getText().toString();
                int charCount = inputText.length();
                String message = "СТУДЕНТ № 6 ГРУППА БСБО-04-22 Количество символов - " + charCount;
                Toast.makeText(ToastApp.this, message, Toast.LENGTH_SHORT).show();
            }
        });
    }
}