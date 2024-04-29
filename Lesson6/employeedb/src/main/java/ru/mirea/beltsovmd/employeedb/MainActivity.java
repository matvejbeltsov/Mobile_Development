package ru.mirea.beltsovmd.employeedb;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final AppDataBase database = App.getInstance().getDatabase();
        final EmployeeDao employeeDao = database.employeeDao();

        employeeDao.insert(new Employee(1,"Петя", 2));
        employeeDao.insert(new Employee(2,"Вася", 4));
        employeeDao.insert(new Employee(3,"Степа", 6));

    }
}