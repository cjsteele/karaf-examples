package org.cdl._0708104.consumer;

import java.util.Timer;
import java.util.TimerTask;

import org.cdl._0708104.api.EchoService;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

public class ConsumerActivator implements BundleActivator {
	
	public static final int SECONDS = 5;
	
	private Timer timer;
	ServiceReference<?> serviceReference;
	EchoService echoService;
	
	@Override
	public void start(BundleContext context) throws Exception {
		serviceReference = context.getServiceReference(EchoService.class.getName());
		echoService = (EchoService) context.getService(serviceReference);
		timer = new Timer();
		timer.schedule(new EchoTask(), SECONDS*1000);
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		timer.cancel();
		serviceReference = null;
		echoService = null;
	}

	class EchoTask extends TimerTask {

		@Override
		public void run() {
			if(echoService != null) {
				echoService.echo("Echo");
			} else {
				System.out.println("Can't find service!");
			}
			timer.schedule(new EchoTask(), SECONDS*1000);
		}

	}	
	

}
