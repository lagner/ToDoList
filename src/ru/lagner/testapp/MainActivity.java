package ru.lagner.testapp;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
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
        // doesn't work
        registerForContextMenu(lst_todoList);
       
        todos.add("first to do item");        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);    
        
        return true;
    }
    
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenuInfo info)
    {
    	super.onCreateContextMenu(menu, v, info);
    	Log.v(logTag, "Context menu");
    }
    
    @Override
    public boolean onPrepareOptionsMenu(Menu menu)
    {
    	super.onPrepareOptionsMenu(menu);
    	Log.v(logTag, "prepare menu items");
    	
    	return true;
    }
    
    @Override 
    public boolean onOptionsItemSelected(MenuItem item)
    {
    	super.onOptionsItemSelected(item);
    	
    	int id = item.getItemId();   
    	switch(id)
    	{
    	case (R.id.mnu_addItem):
    		AddNewItem();
    		return true;
    	case (R.id.mnu_removeItem):
    		RemoveItem();
    		return true;    	
    	}    	
    	return false;
    }
    
    
    public void AddNewItem()
    {
		Log.i(logTag, "Adding new item");
    }
    
    public void RemoveItem()
    {
		Log.i(logTag, "Removing item");	    	
    }
    
    
    public void onClick(View v)
    {
    	Log.v(logTag, "clicked");
    }
    
    
    
    private ArrayList<String> todos = new ArrayList<String>();    
    
    private ListView lst_todoList;    
    
    private ArrayAdapter<String> adapter;
    
    final private int addItemId = Menu.FIRST;
    final private int removeItemId = Menu.FIRST + 1;
    final private String logTag = "MainActivity";
}
