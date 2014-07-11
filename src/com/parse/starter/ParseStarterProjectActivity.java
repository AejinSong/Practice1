package com.parse.starter;

//import kr.ac.kaist.ic.R;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import com.parse.ParseAnalytics;
import com.parse.ParseObject;

public class ParseStarterProjectActivity extends Activity {
	/** Called when the activity is first created. */
	
	EditText etExerTime;
	EditText etExerType;
	Button btn;
	
	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		ParseAnalytics.trackAppOpened(getIntent());
		//final ParseObject exercise = new ParseObject("Exercise");
		//안에 다른 함수로 들어갈 때는 앞에 final 써줘야함.
		etExerTime = (EditText) findViewById(R.id.editText1);
		etExerType = (EditText) findViewById(R.id.editText2);

		
		
		btn = (Button) findViewById(R.id.button1);
		
		

		btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				ParseObject exercise = new ParseObject("Exercise");
				//안에 다른 함수로 들어갈 때는 앞에 final 써줘야함.
				

				String time1 = etExerTime.getText().toString();
				int time = Integer.valueOf(time1);
				exercise.put("time", time);
				
				String type = etExerType.getText().toString();
				exercise.put("type", type);
				exercise.saveInBackground();
			}
		});
		
		
	}
}
