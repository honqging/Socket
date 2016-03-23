package com.imooc;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
// InetAddress usage
public class Test01 {

	public static void main(String[] args) throws UnknownHostException {
		// TODO Auto-generated method stub
		InetAddress address = InetAddress.getLocalHost();
		System.out.println("Computer Name:"+ address.getHostName()
				+ "\nComputer IP" + address.getHostAddress()
				+ "\n" + Arrays.toString(address.getAddress()));
		

	}

}
