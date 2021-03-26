package ru.samsung.lesson12032021;

import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    ListView listView;
    EditText userFilter;
    DataBaseHelper dataBaseHelper;
    SQLiteDatabase db;
    Cursor userCursor;

    ArrayAdapter<User> userAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textview);
        listView = findViewById(R.id.list);
        userFilter = findViewById(R.id.userFilter);

        dataBaseHelper = new DataBaseHelper(getApplicationContext());

      dataBaseHelper.create_db();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                User user = userAdapter.getItem(position);
                Intent intent = new Intent(getApplicationContext(), UserActivity.class);
                intent.putExtra("id", user.getId());
                startActivity(intent);
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        try {
            DataBaseAdapter adapter= new DataBaseAdapter(this);
            adapter.open();
            db = dataBaseHelper.open();
            List<User> users = adapter.getUsers();
            userAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,users);

            if (!userFilter.getText().toString().isEmpty())
                userAdapter.getFilter().filter(userFilter.getText().toString());
            userFilter.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    userAdapter.getFilter().filter(s.toString());
                }

                @Override
                public void afterTextChanged(Editable s) {

                }
            });

            listView.setAdapter(userAdapter);
            adapter.close();
        } catch (SQLException e) {
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        db.close();
     //   userCursor.close();
    }

    public void add(View view) {
        Intent intent = new Intent(getApplicationContext(), UserActivity.class);
        startActivity(intent);

    }
}