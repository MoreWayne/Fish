package com.tarena.thread;

import java.util.Date;

//���ӱ�
public class DateThread extends Thread {
	@Override
	public void run() {
	while(true){
		Date d=new Date();
		System.out.println(d);
		//�߳�����
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	}
}
