package ru.mirea.beltsovmd.multiactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import ru.mirea.beltsovmd.phonetabletmodule.R;

public class MultiActivity extends AppCompatActivity {

    EditText editText;
    Button sendButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multi);

        editText = findViewById(R.id.editText);
        sendButton = findViewById(R.id.sendButton);

        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String textToSend = editText.getText().toString();
                Intent intent = new Intent(MultiActivity.this, SecondActivity.class);
                intent.putExtra("text", textToSend);
                startActivity(intent);
            }
        });
        Log.d("MainActivity", "onCreate() вызван");
    }
    public void onClickNewActivity(View view){
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.d("MainActivity", "onStart() вызван");
    }
    @Override
    protected void onResume() {
        super.onResume();
        Log.d("MainActivity", "onResume() вызван");
    }
    @Override
    protected void onPause() {
        super.onPause();
        Log.d("MainActivity", "onPause() вызван");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("MainActivity", "onStop() вызван");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("MainActivity", "onDestroy() вызван");
    }
}