package com.tarena.thread;

public class TestThread {
	public static void main(String[] args) {
//		for(int i=1;i<=1000;i++){
//			System.out.println("����˭"+i);
//		}
//		
//		for(int i=1;i<=1000;i++){
//			System.out.println("����ˮ��"+i);
//		}
//		
		//����ִ��
		//������һ���̡߳�first
//		First first=new First();
//		//����start�����������߳�
//		first.start();
//		Second second=new Second();
//		second.start();
		//���������̣߳�������start������
		DateThread dt=new DateThread();
		dt.start();
		
		
		
		
		
		
	}
}
