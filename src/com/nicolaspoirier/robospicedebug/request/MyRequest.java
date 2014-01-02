package com.nicolaspoirier.robospicedebug.request;

import com.octo.android.robospice.request.SpiceRequest;

public class MyRequest extends SpiceRequest<Void> {

	public MyRequest() {
		super(Void.class);
	}

	@Override
	public Void loadDataFromNetwork() throws Exception {
		return null;
	}
}
