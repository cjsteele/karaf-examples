package org.cdl._0708104.producer;

import org.cdl._0708104.api.EchoService;

public class EchoServiceImpl implements EchoService {

	@Override
	public void echo(String s) {
		System.out.println(s);
	}
}
