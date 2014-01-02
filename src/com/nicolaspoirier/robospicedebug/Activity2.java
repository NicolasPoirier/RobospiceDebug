package com.nicolaspoirier.robospicedebug;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.app.Activity;
import android.content.Intent;

public class Activity2 extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity2);
		
		findViewById(R.id.button).setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                startActivity(new Intent(Activity2.this, Activity1.class));
            }
        });
	}

}
