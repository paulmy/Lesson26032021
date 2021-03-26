package ru.samsung.lesson12032021;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class SortMassiv extends Activity {
    EditText edit_sort;
    TextView text_sort;
    int[] a = new int[10000];
    User[] users= new User[10000];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sort);
        text_sort = findViewById(R.id.text_sort);
        edit_sort = findViewById(R.id.edit_sort);

        // InitMassiv(a);
        InitMassiv(users, users.length);
        text_sort.setText(OutputMassiv(users));
    }

    public void onBubbleSort(View view) {
        BubbleSort(users);
        text_sort.setText(OutputMassiv(users));
    }

    public void onQuickSort(View view) {
        quickSort(users, 0, users.length - 1);
        text_sort.setText(OutputMassiv(users));
    }

    public void onCreateMassiv(View view) {
        InitMassiv(users, users.length);
        text_sort.setText(OutputMassiv(users));

    }

    public void InitMassiv(int[] a) {
        for (int i = 0; i < a.length; i++) {
            a[i] = (int) (Math.random() * 1000);
        }

    }

    public void InitMassiv(User[] a, int n) {

        for (int i = 0; i < a.length; i++) {
            a[i] = new User("User" + i, (int) (Math.random() * 1000));
        }

    }

    public String OutputMassiv(int[] a) {
        String s = "";
        for (int i = 0; i < a.length; i++) {
            s = s + a[i] + " ";
        }
        return s;
    }

    public String OutputMassiv(User[] a) {
        String s = "";
        for (int i = 0; i < a.length; i++) {
            s = s + a[i] + "\n";
        }
        return s;
    }

    public void BubbleSort(User[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = a.length - 2; j >= i; j--) {
                if (a[j].getYear() > a[j + 1].getYear()) {
                    User c = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = c;
                }

            }
        }


    }


    public static void bubbleSort(int[] a) {
        for (int i = a.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (a[j] > a[j + 1]) {
                    int tmp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = tmp;
                }
            }
        }
    }

    public void BubbleSort(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = a.length - 2; j >= i; j--) {
                if (a[j] > a[j + 1]) {
                    int c = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = c;
                }

            }
        }


    }

    public static void quickSort(User[] a, int low, int high) {
        if (a.length == 0)
            return; //завершение выполнение алгоритма, если длина массива равна 0

        if (low >= high)
            return; //завершение выполнение алгоритма, если уже нечего делить

        // выбор опорного элемента
        int middle = low + (high - low) / 2;
        User op = a[middle];

        // разделить на подмассивы, который больше и меньше опорного элемента
        int i = low, j = high;
        while (i <= j) {
            while (a[i].getYear() < op.getYear()) {
                i++;
            }
            while (a[j].getYear() > op.getYear()) {
                j--;
            }

            if (i <= j) { //меняем элементы местами
                User temp = a[i];
                a[i] = a[j];
                a[j] = temp;
                i++;
                j--;
            }
        }

        // вызов рекурсии для сортировки левой и правой части
        if (low < j)
            quickSort(a, low, j);

        if (high > i)
            quickSort(a, i, high);
    }


}
