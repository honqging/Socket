package com.imooc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

//使用url读取网页内容
public class Test03 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		URL url = new URL("http://www.imooc.com");
		InputStream is = url.openStream();
		//通过URL的openStream方法获取url对象索表示的资源的字节输入流
		InputStreamReader isr = new InputStreamReader(is);
		//字节输入流转换为字符输入流
		BufferedReader br = new BufferedReader(isr);
		//为字符输入流添加缓冲
		String data = br.readLine();
		//读取输入流，一次读取一行
		
		while(data!=null){//循环读取
			System.out.println(data);
			data = br.readLine();
		}
		
		br.close();
		isr.close();
		is.close();
		


	}

}
