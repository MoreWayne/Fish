package com.tarena.thread;

import java.util.Date;

//电子表
public class DateThread extends Thread {
	@Override
	public void run() {
	while(true){
		Date d=new Date();
		System.out.println(d);
		//线程休眠
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	}
}
