package com.imooc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

//服务器端线程处理类
public class ServerThread extends Thread {
	
	Socket socket = null;
	public ServerThread(Socket socket){
		this.socket = socket;
	}
	
	public void run(){
		InputStream is = null;
		//通过URL的openStream方法获取url对象索表示的资源的字节输入流
		InputStreamReader isr = null;
		//字节输入流转换为字符输入流
		BufferedReader br = null;
		//获取输出流
		OutputStream os = null;
		PrintWriter pw = null;
		try {
			is = socket.getInputStream();
			isr = new InputStreamReader(is);
			br = new BufferedReader(isr);
			//为字符输入流添加缓冲
			String info = null;
			//读取输入流，一次读取一行
			
			while((info= br.readLine())!=null){//循环读取
				System.out.println("我是服务器，客户端说：" + info);
//			info = br.readLine();
			}
			socket.shutdownInput();
			
			os = socket.getOutputStream();
			pw = new PrintWriter(os);
			pw.write("欢迎您!");
			pw.flush();
			socket.shutdownOutput();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			try {
				pw.close();
				os.close();
				br.close();
				isr.close();
				is.close();
				socket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
	}
	


}
