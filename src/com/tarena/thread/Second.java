package com.tarena.thread;
//ִ��һǧ���
public class Second extends Thread {
	@Override
	
	public void run() {
		for(int i=1;i<=1000;i++){
			System.out.println("�Ϳ�ݵ�"+i);
		}
	}
}
