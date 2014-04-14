package org.cdl._0708104.producer;

import org.cdl._0708104.api.EchoService;

public class EchoServiceImpl implements EchoService {

	public void startUp() {
		System.out.println(">>> Starting EchoService <<<");
	}
	
	@Override
	public String echo(String s) {
		System.out.println("EchoService received "+s);
		return s;
	}
}
