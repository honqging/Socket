package com.imooc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

//基于tcp协议的socket通信,实现用户登陆
public class Server {
	
	public static void main(String[] args){
		try {
			ServerSocket serverSocket = new ServerSocket(8888);
			System.out.println("服务器即将启动，等待客户端的连接...\n");
			Socket socket = serverSocket.accept();
			
			InputStream is = socket.getInputStream();
			//通过URL的openStream方法获取url对象索表示的资源的字节输入流
			InputStreamReader isr = new InputStreamReader(is);
			//字节输入流转换为字符输入流
			BufferedReader br = new BufferedReader(isr);
			//为字符输入流添加缓冲
			String info = null;
			//读取输入流，一次读取一行
			
			while((info= br.readLine())!=null){//循环读取
				System.out.println("我是服务器，客户端说：" + info);
//				info = br.readLine();
			}
			socket.shutdownInput();
			
			//获取输出流
			OutputStream os = socket.getOutputStream();
			PrintWriter pw = new PrintWriter(os);
			pw.write("欢迎您!");
			pw.flush();
			socket.shutdownOutput();
			
			pw.close();
			os.close();
			br.close();
			isr.close();
			is.close();
			socket.close();
			serverSocket.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
