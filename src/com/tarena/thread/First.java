package com.tarena.thread;
//执行一千遍问



public class First extends Thread {
	
	
	public void run(){
		for(int i=1;i<=1000;i++){
			System.out.println("你是谁"+i);
		}
	}
	
	
}
