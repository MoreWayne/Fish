package com.tarena.morningsnow;
/*
 * 1.运行雪花飘落的主类
 * 
 * 
 * 
 * 
 * 
 */
import javax.swing.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//创建窗体
		JFrame frame=new JFrame("雪雪雪雪");
		//创建天空对象
		Sky sky=new Sky();
		//添加到窗体中
		frame.add(sky);
		
		
		
		
		
		
		
		//设置窗体
		frame.setSize(700,500);
		frame.setLocation(400, 500);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//通过天空对象调用自己定义的action方法，要放在代码的最后一行调用，因为 死循环
		sky.action();
	}

}
