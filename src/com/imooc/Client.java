package com.imooc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	public static void main(String[] args){
		try {
			//1.创建客户端Socket，指定服务器地址和端口
			Socket socket = new Socket("localhost", 8888);
			
			OutputStream os = socket.getOutputStream();
			PrintWriter	pw = new PrintWriter(os);
			pw.write("用户名:ajflks, 密码:123");
			pw.flush();
			socket.shutdownOutput();
			
			//获取输入流
			InputStream is = socket.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			String info = null;
			//读取输入流，一次读取一行
			
			while((info= br.readLine())!=null){//循环读取
				System.out.println("我是客户端，服务器说：" + info);
//				info = br.readLine();
			}
			socket.shutdownInput();
			br.close();
			isr.close();
			is.close();
			
			pw.close();
			os.close();
			socket.close();
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
