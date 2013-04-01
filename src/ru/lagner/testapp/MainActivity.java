package ru.lagner.testapp;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        adapter  = new ArrayAdapter<String>(this, R.layout.todo_list_item, todos);
        
        lst_todoList = (ListView)findViewById(R.id.lst_TodoList);
        lst_todoList.setAdapter(adapter);
       
        todos.add("first to do item");
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    
    
    private ArrayList<String> todos = new ArrayList<String>();    
    
    private ListView lst_todoList;    
    
    private ArrayAdapter<String> adapter;
    
    final private int addItemId = Menu.FIRST;
    final private int removeItemId = Menu.FIRST + 1;
}
