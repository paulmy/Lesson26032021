package ru.samsung.lesson12032021;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Comparator;
import java.util.HashSet;
import java.util.TreeSet;


public class BinaryTreeActivity extends Activity {
    EditText edit_node;
    TextView text_node;
    BinaryTree tree;
    TreeSet<Integer> userTreeSet = new TreeSet<Integer>();
    HashSet<User> userHashSet = new HashSet<User>();
    Comparator userComp = new UserNameComparator().thenComparing(new UserYearComparator());
    TreeSet<User> userSet = new TreeSet<User>(userComp);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_binarytree);
        edit_node = findViewById(R.id.edit_node);
        text_node = findViewById(R.id.text_node);
        int[] b = {10, 25, 20, 6, 4, 8, 50, 30, 6};
        tree = new BinaryTree(b[0]);
        for (int i = 1; i < b.length; i++) {
            tree.insertNode(tree, b[i]);
        }
        text_node.setText(tree.printBinaryTree(tree, 0));
        userTreeSet.add(123);
        // Log.v("MYLOG",""+tree.printBinaryTree(tree,0,""));
        userHashSet.add(new User("User1", 1));
        userHashSet.add(new User("User2", 2));
        userHashSet.add(new User("User3", 3));
        userSet.add(new User("Ivan", 2000));
        userSet.add(new User("Ivan", 1970));
        userSet.add(new User("Ivan", 2020));


    }

    public void InputNode(View view) {
        /*int a=Integer.parseInt(edit_node.getText().toString());

        tree.insertNode(tree,a);
        text_node.setText(tree.printBinaryTree(tree,0));*/
        //userTreeSet.add(Integer.parseInt(edit_node.getText().toString()));
        //text_node.setText(userTreeSet.toString());
        text_node.setText("");
        userHashSet.add(new User("User" + (int) (Math.random() * 100), (int) (Math.random() * 2000)));
        for (User s : userHashSet) {
            text_node.append("name " + s.getName() + " Hash " + s.hashCode() + "\n");
        }
        //text_node.setText("Size " + userHashSet.size() + " " + userHashSet.toString());
        edit_node.setText("");


    }

    public void DelNode(View view) {
        String name = edit_node.getText().toString();
        text_node.setText("");


        for (User s : userHashSet) {
            if (s.getName().equals(name))
                userHashSet.remove(s);
        }
        for (User s : userHashSet)
            text_node.append("name " + s.getName() + " Hash " + s.hashCode() + "\n");

    }

    public void onTreeSet(View view) {
        text_node.setText("");
        userSet.add(new User((char)(65+(int) (Math.random() * 5))+"User"+(int) (Math.random() * 2), (int) (Math.random() * 2000)));
        for (User s : userSet)
            text_node.append(s.getName()+" "+s.getYear()+"\n");


    }
}
