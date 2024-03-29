package ru.mirea.beltsovmd.simplefragmentapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    Fragment fragment1, fragment2;
    FragmentManager fragmentManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentManager = getSupportFragmentManager();
        fragment1 = new FirstFragment();
        fragment2 = new SecondFragment();
    }
    // Метод обработки нажатия кнопок
    public void onClick(View view) {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        if (view.getId() == R.id.btnFirstFragment) {
            // Заменяем содержимое контейнера на первый фрагмент
            transaction.replace(R.id.fragmentContainer, fragment1);
        } else if (view.getId() == R.id.btnSecondFragment) {
            // Заменяем содержимое контейнера на второй фрагмент
            transaction.replace(R.id.fragmentContainer, fragment2);
        }
        // Применяем транзакцию
        transaction.commit();
    }
}