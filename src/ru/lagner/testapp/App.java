package ru.lagner.testapp;

import android.app.Application;
import android.content.res.Configuration;
import android.util.Log;

public class App extends Application {
	
	public static App getInstance()
	{
		return instance;
	}
	
	@Override
	public final void onCreate()
	{
		super.onCreate();
		instance = this;		
		Log.v(logTag, "App::onCreate");
	}
	
	@Override
	public final void onTerminate()
	{
		super.onTerminate();
		Log.v(logTag, "App::onTerminate");
	}
	
	@Override
	public final void onLowMemory()
	{
		super.onLowMemory();
		Log.v(logTag, "App::onLowMemory");
	}
	
	@Override
	public final void onConfigurationChanged(Configuration newConfig)
	{
		super.onConfigurationChanged(newConfig);
		Log.v(logTag, "App::onConfigurationChanged");
	}
		

	private static App instance;
	
	private String logTag = "AppMain";
}
