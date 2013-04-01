package ru.lagner.testapp;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.TextView;

public class TodoListItemView extends TextView {
	
	
	public TodoListItemView(Context context, AttributeSet attrs, int style)
	{
		super(context, attrs, style);
		Init();
	}
	
	public TodoListItemView(Context context, AttributeSet attrs)
	{
		super(context, attrs);
		Init();
	}
	
	public TodoListItemView(Context context)
	{
		super(context);
		Init();
	}
	
	@Override
	public void onDraw(Canvas canvas)
	{		
		canvas.drawColor(paperColor);
		
		canvas.drawLine(0, 0, getHeight(), 0, linePaint);
		canvas.drawLine(0, getHeight(), getWidth(), getHeight(), linePaint);
		canvas.drawLine(margin, 0, margin, getHeight(), marginPaint);
		canvas.save();
		canvas.translate(margin, 0);
		
		super.onDraw(canvas);		
		canvas.restore();
	}
		
	
	private void Init()
	{
		Log.v(logTag, "Init");
		
		Resources resources = getResources();
		
		marginPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
		marginPaint.setColor(resources.getColor(R.color.notepad_margin));
		
		linePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
		linePaint.setColor(resources.getColor(R.color.notepad_lines));
		
		paperColor = resources.getColor(R.color.notepad_paper);
		margin = resources.getDimension(R.dimen.notepad_margin);
	}

	private final String logTag = "TodoListItemView";
	
	private Paint marginPaint;
	private Paint linePaint;
	
	private int paperColor;
	private float margin;
}
