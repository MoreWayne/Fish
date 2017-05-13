package com.tarena.thread;
//执行一千遍答
public class Second extends Thread {
	@Override
	
	public void run() {
		for(int i=1;i<=1000;i++){
			System.out.println("送快递的"+i);
		}
	}
}
