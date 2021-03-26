package ru.samsung.lesson12032021;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class UserActivity extends Activity {
    EditText name, year;
    Button btn_save, btn_delete;

    DataBaseHelper sqlHelper;
    SQLiteDatabase db;
    Cursor userCursor;
    long userId = 0;
    private DataBaseAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        name = findViewById(R.id.name);
        year = findViewById(R.id.year);
        btn_delete = findViewById(R.id.btn_delete);
        btn_save = findViewById(R.id.btn_save);
        adapter = new DataBaseAdapter(this);

        Bundle extras = getIntent().getExtras();
        if (extras != null)
            userId = extras.getLong("id");
        if (userId > 0) {
            adapter.open();

            User user = adapter.getUser(userId);

            name.setText(user.getName());
            year.setText(String.valueOf(user.getYear()));

            adapter.close();
        }
        if (userId == 0) {
            btn_delete.setVisibility(View.GONE);
        }
        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String u_name = name.getText().toString();
                int u_year = Integer.parseInt(year.getText().toString());
                User user = new User(userId, u_name, u_year);
                adapter.open();

                if (userId > 0)
                    adapter.update(user);
                else
                    adapter.insert(user);
                adapter.close();
                goHome();
            }
        });

        btn_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapter.open();
                adapter.delete(userId);
                adapter.close();
                goHome();
            }
        });

    }

    private void goHome() {
        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
        startActivity(intent);
    }
}
