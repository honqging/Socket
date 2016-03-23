package com.imooc;

import java.net.MalformedURLException;
import java.net.URL;

//url常用方法
public class Test02 {
	public static void main(String[] args) throws MalformedURLException {
		URL imooc = new URL("http://www.imooc.com");
		URL url = new URL(imooc, "/index.html#testmaodian");
		System.out.println(url.getProtocol() + "," + url.getRef()
				+ "," + url.getPort());
	}
}
