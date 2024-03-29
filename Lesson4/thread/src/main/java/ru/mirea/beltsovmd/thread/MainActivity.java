package ru.mirea.beltsovmd.thread;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import ru.mirea.beltsovmd.thread.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding = null;
    private int thread_id_counter = 0;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Thread mainThread = Thread.currentThread();

        final String oldThreadName = mainThread.getName();
        mainThread.setName("МОЙ НОМЕР ГРУППЫ: 04, НОМЕР ПО СПИСКУ: 6, МОЙ ЛЮБИИМЫЙ ФИЛЬМ: ВОЛК С УОЛЛ-СТРИТ");
        final String newThreadName = mainThread.getName();
        binding.mainThreadInfo.setText(
                String.format("Имя текущего потока: %s\n", oldThreadName) +
                        String.format("Новое имя потока: %s\n", newThreadName)
        );
        Log.d(MainActivity.class.getSimpleName(), "Stack: " + Arrays.toString(mainThread.getStackTrace()));
    }
    public void OnStartBackgroundCalculationButtonPressed(View v) {
        try {
            final int days = Integer.parseUnsignedInt(binding.inputDaysPanel.getText().toString());
            final int lessons = Integer.parseUnsignedInt(binding.inputLessonsPanel.getText().toString());


            final Thread backround_worker = new Thread() {
                @Override
                public void run() {
                    synchronized (this) {
                        String calculation_result = "";
                        try {
                            Log.i(MainActivity.class.getSimpleName(), "Start background calculation");
                            wait(2000);
                            final float result = ((float) lessons) / days;
                            Log.i(MainActivity.class.getSimpleName(), "Finish background calculation");
                            calculation_result = String.format("Average lessons per day: %.2f", result);
                        } catch (InterruptedException e) {
                            calculation_result = "Calculation was interrupted...";
                        } finally {
                            final String formatted_result = String.format("Calculation result: %s", calculation_result);
                            binding.calculationResult.post(new Runnable() {
                                @Override
                                public void run() {
                                    binding.calculationResult.setText(formatted_result);
                                }
                            });
                        }
                    }
                }
            };
            backround_worker.start();
        } catch(NumberFormatException e) {
            binding.calculationResult.setText(String.format("Calculation result: %s", "Invalid input"));
        }
    }
    public void OnStartBlockingCalculationButtonPressed(View v) {
        final long endTime = System.currentTimeMillis() + 20 * 1000;
        while (System.currentTimeMillis() < endTime) {
            synchronized(this){
                try {
                    wait(endTime - System.currentTimeMillis());
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
    public void OnStartBlockingCalculationInBackgroundThreadButtonPressed(View v) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                final int numberThread = ++thread_id_counter;
                Log.d("ThreadProject", String.format("Запущен поток № %d студентом группы № %s номер по списку № %d ", numberThread, "БСБО-04-22", 6));
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
                    Log.d("ThreadProject", "Выполнен поток № " + numberThread);
                }
            }
        }).start();
    }
}
