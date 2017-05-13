package com.tarena.thread;

public class TestThread {
	public static void main(String[] args) {
//		for(int i=1;i<=1000;i++){
//			System.out.println("你是谁"+i);
//		}
//		
//		for(int i=1;i<=1000;i++){
//			System.out.println("我修水表"+i);
//		}
//		
		//并发执行
		//创建第一个线程。first
//		First first=new First();
//		//调用start方法，启动线程
//		first.start();
//		Second second=new Second();
//		second.start();
		//创建日期线程，并调用start方法，
		DateThread dt=new DateThread();
		dt.start();
		
		
		
		
		
		
	}
}
