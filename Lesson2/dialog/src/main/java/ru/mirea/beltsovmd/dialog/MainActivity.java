package ru.mirea.beltsovmd.dialog;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void showTimePickerDialog(View v) {
        MyTimeDialogFragment newFragment = new MyTimeDialogFragment();
        newFragment.show(getSupportFragmentManager(), "timePicker");
    }
    public void showDatePickerDialog(View v) {
        MyDateDialogFragment newFragment = new MyDateDialogFragment();
        newFragment.show(getSupportFragmentManager(), "datePicker");
    }
    public void showProgressDialog(View v) {
        MyProgressDialogFragment newFragment = new MyProgressDialogFragment();
        newFragment.show(getSupportFragmentManager(), "progressDialog");
    }
    public void onClickShowDialog(View view) {
        AlertDialogFragment dialogFragment = new AlertDialogFragment();
        dialogFragment.show(getSupportFragmentManager(), "mirea");
    }
    public void onOkClicked() {
        Toast.makeText(getApplicationContext(), "Вы выбрали кнопку \"Иду дальше\"!",
                Toast.LENGTH_LONG).show();
    }
    public void onCancelClicked() {
        Toast.makeText(getApplicationContext(), "Вы выбрали кнопку \"Нет\"!",
                Toast.LENGTH_LONG).show();
    }
    public void onNeutralClicked() {
        Toast.makeText(getApplicationContext(), "Вы выбрали кнопку \"На паузе\"!",
                Toast.LENGTH_LONG).show();
    }
}