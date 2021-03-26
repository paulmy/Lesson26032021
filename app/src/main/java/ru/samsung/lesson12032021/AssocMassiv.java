package ru.samsung.lesson12032021;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.*;


public class AssocMassiv extends Activity {
    EditText edit_map;
    TextView text_map;
    Button btn_put, btn_search;
    Comparator userComp = new UserNameComparator().thenComparing(new UserYearComparator());
  //  Map<Integer, User> map = new HashMap<Integer, User>();
    TreeMap<Integer, User> map = new TreeMap<Integer, User>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        edit_map = findViewById(R.id.edit_map);
        text_map = findViewById(R.id.text_map);
        btn_put = findViewById(R.id.btn_put);
        btn_search = findViewById(R.id.btn_search);

        map.put(1, new User("User1", 2000));
        map.put(2, new User("User1", 2000));
        InitMap();
        btn_put.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {

                    String[] usermap = edit_map.getText().toString().split(":");
                    map.put((int) (Math.random() * 100), new User(usermap[0], Integer.parseInt(usermap[1])));
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), "Пустое поле ввода", Toast.LENGTH_SHORT).show();
                }

                edit_map.setText("");
                OutputMap();

            }
        });
        btn_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text_map.setText("");
               // String value = edit_map.getText().toString();
                /*Integer key = Integer.parseInt(edit_map.getText().toString());

                if (map.containsKey(key))
                    text_map.setText(map.get(key).toString());
                else
                    text_map.setText("Нет элемента с таким ключом");*/
                SortedMap<Integer, User> submap = map.headMap(Integer.parseInt(edit_map.getText().toString()),true);

                text_map.setText("Submap:\n");
                for (Map.Entry<Integer, User> entry : submap.entrySet()) {
                    text_map.append(entry.getKey() + " -> " + entry.getValue() + "\n");
                    //System.out.println(entry.getKey() + " -> " + entry.getValue());
                }

/*
                for (Map.Entry<Integer,User> entry : map.entrySet()) {
                    if(value.equals(entry.getValue().getName()))
                        text_map.append(entry.getKey() + "\n");
                }*/


            }
        });

    }

    void OutputMap() {
        text_map.setText("");
        for (Map.Entry<Integer,User> entry : map.entrySet()) {
            text_map.append(entry.getKey() + " " + entry.getValue().getName() + "\n");
        }
    }

    void InitMap() {
        for (int i = 0; i < 10; i++) {

            map.put((int) (Math.random() * 100),
                    new User((char) (65 + (int) (Math.random() * 5)) + "User" + (int) (Math.random() * 2), (int) (Math.random() * 2000)));
        }
    }
}
