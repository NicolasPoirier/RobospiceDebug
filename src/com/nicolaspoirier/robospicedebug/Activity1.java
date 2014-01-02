package com.nicolaspoirier.robospicedebug;

import com.nicolaspoirier.robospicedebug.request.MyRequest;
import com.octo.android.robospice.SpiceManager;
import com.octo.android.robospice.UncachedSpiceService;
import com.octo.android.robospice.persistence.exception.SpiceException;
import com.octo.android.robospice.request.listener.RequestListener;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.app.Activity;
import android.content.Intent;

public class Activity1 extends Activity {

	private SpiceManager spiceManager = new SpiceManager(
			UncachedSpiceService.class);

	private Button button;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity1);

		button = (Button) findViewById(R.id.button);

		button.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				startActivity(new Intent(Activity1.this, Activity2.class));
			}
		});
	}

	@Override
	protected void onStart() {
		super.onStart();
		spiceManager.start(this);
	}

	@Override
	protected void onResume() {
		super.onResume();
		spiceManager.execute(new MyRequest(), new RequestListener<Void>() {

			@Override
			public void onRequestFailure(SpiceException arg0) {
				button.setEnabled(true);
			}

			@Override
			public void onRequestSuccess(Void arg0) {
				button.setEnabled(true);
			}
		});
	}

	@Override
	protected void onStop() {
		spiceManager.shouldStop();
		super.onStop();
	}

}
