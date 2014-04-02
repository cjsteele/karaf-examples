package org.cdl._0708104.producer;

import org.cdl._0708104.api.EchoService;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class ProducerActivator implements BundleActivator {

	EchoService echoService = new EchoServiceImpl();
	ServiceRegistration<?> registration;
	
	@Override
	public void start(BundleContext context) throws Exception {
		//register the service with the container
		
		registration = context.registerService(EchoService.class.getName(), echoService, null);
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		//unregister
		
		registration.unregister();
	}
}
