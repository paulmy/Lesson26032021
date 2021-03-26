package ru.samsung.lesson12032021;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Shell extends Activity {

    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shell);
    }

    public void openSQL(View view) {
        Intent intent = new Intent(Shell.this,MainActivity.class);
        startActivity(intent);
    }

    public void openRec(View view) {
        Intent intent = new Intent(Shell.this,RecActivity.class);
        startActivity(intent);
    }

    public void openFileSys(View view) {
        Intent intent = new Intent(Shell.this,FileSysActivity.class);
        startActivity(intent);
    }

    public void openBinaryTree(View view) {
        Intent intent = new Intent(Shell.this,BinaryTreeActivity.class);
        startActivity(intent);
    }

    public void openMap(View view) {
        Intent intent = new Intent(Shell.this,AssocMassiv.class);
        startActivity(intent);
    }

    public void openSort(View view) {
        Intent intent = new Intent(Shell.this,SortMassiv.class);
        startActivity(intent);
    }
}
