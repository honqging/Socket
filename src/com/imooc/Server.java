package com.imooc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

//基于tcp协议的socket通信,实现用户登陆
public class Server {
	
	public static void main(String[] args){
		try {
			ServerSocket serverSocket = new ServerSocket(8888);
			int count = 0;
			System.out.println("服务器即将启动，等待客户端的连接...\n");
			Socket socket = null;
			while(true){
//				调用accept方法开始舰艇，等待客户端的连接 
				socket = serverSocket.accept();
				
				ServerThread serverThread = new ServerThread(socket);
				//启动进程
				serverThread.start();
				count++;
				System.out.println("客户端的数量:" + count);
				InetAddress address2 = socket.getInetAddress();
				System.out.println("客户端IP:"+ address2.getHostAddress());

				
			}			
			
//			serverSocket.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
