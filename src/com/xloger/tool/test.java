package com.xloger.tool;

import java.util.Scanner;

public class test {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		String s;
		int i;
		Scanner sc=new Scanner(System.in);
		while(true){
		System.out.println("输入需要转换的数");
		s=sc.next();
		i=Integer.valueOf(s,16);
		System.out.println(i);
		}
	}

}
