package org.cdl._0708104.consumer;

import java.util.Timer;
import java.util.TimerTask;

import org.cdl._0708104.api.EchoService;

public class EchoServiceConsumer {
	
	public static final int SECONDS = 5;

	EchoService echoService;
	Timer timer;
	
	public void startConsumer(EchoService echoService) {
		if(echoService != null) {
			this.echoService = echoService;
			timer = new Timer();
			timer.schedule(new EchoTask(), (EchoServiceConsumer.SECONDS * 1000));
		} else {
			throw new RuntimeException("echoService was passed to EchoServiceConsumer as null.");
		}
	}
	
	public void stopConsumer() {
		timer.cancel();
		echoService = null;
	}
	
	class EchoTask extends TimerTask {

		@Override
		public void run() {
			if(echoService != null) {
				System.out.println("Consumer received "+echoService.echo("Echo"));
			} else {
				System.out.println("EchoService was null!");
			}
			timer.schedule(new EchoTask(), SECONDS*1000);
		}

	}	
}
