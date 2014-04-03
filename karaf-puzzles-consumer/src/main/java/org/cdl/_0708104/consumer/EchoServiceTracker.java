package org.cdl._0708104.consumer;

import org.cdl._0708104.api.EchoService;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTracker;

/**
 *	Type Parameters: 
 *	S - The type of the service being tracked.
 *	T - The type of the tracked object.
 */
public class EchoServiceTracker extends ServiceTracker<EchoService,EchoService> {
	
	private EchoServiceConsumer echoServiceConsumer;
	
	public EchoServiceTracker(
			BundleContext bundleContext, 
			EchoServiceConsumer echoServiceConsumer) {
		super(bundleContext, EchoService.class.getName(), null);
		this.echoServiceConsumer = echoServiceConsumer;
	}

	@Override
	public EchoService addingService(
			ServiceReference<EchoService> serviceReference) {
		System.out.println("addingService executing");
		
		EchoService echoService = (EchoService) context.getService(serviceReference);
		echoServiceConsumer.startConsumer(echoService);
		return echoService;
	}
	
	@Override
	public void modifiedService(
			ServiceReference<EchoService> serviceReference, 
			EchoService echoService) {
		echoServiceConsumer.stopConsumer();
		EchoService newEchoService = (EchoService) context.getService(serviceReference);
		echoServiceConsumer.startConsumer(newEchoService);
	}
	
	@Override
	public void removedService(
			ServiceReference<EchoService> serviceReference,
			EchoService echoService) {
		echoServiceConsumer.stopConsumer();
		context.ungetService(serviceReference);
	}

}
