package org.cdl._0708104.consumer;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class ConsumerActivator implements BundleActivator {
	
	public static final int SECONDS = 5;
	
	EchoServiceTracker echoServiceTracker;
	
	@Override
	public void start(BundleContext context) throws Exception {
		echoServiceTracker = new EchoServiceTracker(context, new EchoServiceConsumer());
		echoServiceTracker.open();
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		echoServiceTracker.close();
	}	

}
