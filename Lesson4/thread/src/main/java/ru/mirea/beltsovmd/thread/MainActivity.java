package ru.mirea.beltsovmd.thread;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import ru.mirea.beltsovmd.thread.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private int counter = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Найти TextView для отображения информации о главном потоке
        TextView infoTextView = findViewById(R.id.infoTextView);

        // Получить текущий поток
        Thread mainThread = Thread.currentThread();


        infoTextView.setText("Имя текущего потока: " + mainThread.getName());


        mainThread.setName("МОЙ НОМЕР ГРУППЫ: 04, НОМЕР ПО СПИСКУ: 06, МОЙ ЛЮБИИМЫЙ ФИЛЬМ: Волк с Уолл-Стрит");
        infoTextView.append("\n Новое имя потока: " + mainThread.getName());

        // Вывести стек вызовов потока в LogCat
        Log.d(MainActivity.class.getSimpleName(), "Stack: " + Arrays.toString(mainThread.getStackTrace()));
        binding.buttonMirea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    public void run() {
                        int numberThread = counter++;
                        Log.d("ThreadProject", String.format("Запущен поток No %d студентом группы No %s номер по списку No %d ", numberThread, "БСБО-04-22", 6));
                        long endTime = System.currentTimeMillis() + 20 * 1000;
                        while (System.currentTimeMillis() < endTime) {
                            synchronized (this) {
                                try {
                                    wait(endTime - System.currentTimeMillis());
                                    Log.d(MainActivity.class.getSimpleName(), "Endtime: " + endTime);
                                } catch (Exception e) {
                                    throw new RuntimeException(e);
                                }
                            }
                            Log.d("ThreadProject", "Выполнен поток No " + numberThread);
                        }
                    }
                }).start();
            }
        });

        binding.calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateAveragePairs();
            }
        });
    }

    private void calculateAveragePairs() {
        // Получение введенных пользователем значений
        int totalPairs = Integer.parseInt(binding.totalPairsEditText.getText().toString());
        int totalDays = Integer.parseInt(binding.totalDaysEditText.getText().toString());

        // Выполнение вычислений в фоновом потоке
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                // Подсчет среднего количества пар в день
                double averagePairs = (double) totalPairs / totalDays;

                // Отображение результата в TextView в главном потоке
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        binding.resultTextView.setText("Average pairs per day: " + averagePairs);
                    }
                });
            }
        });
    }
}
