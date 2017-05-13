package com.tarena.fish;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/* 1. 运行捕鱼达人的主类
 * 2.
 */

public class Main {
	public static void main(String[] args) {
		
		JFrame frame=new JFrame("捕鱼达人-测试版1.0");
		Pool p=new Pool();
		//将池塘添加到窗体中
		frame.add(p);
		
		
	 /*
	  	//创建一个面板
		JPanel p=new JPanel();
		//创建一个按钮
		JButton btn=new JButton("点我");
		JButton btn2=new JButton("确定");
		   
		//创建一个单行文本输入框
		JTextField tf=new JTextField(10);
		//创建一个标签
		JLabel label=new JLabel("hello world");
		ImageIcon img=new ImageIcon("images/images/fish08_00.png");//创建一盒图片图表（显示图片的路径和名称）
		JLabel label1=new JLabel(img);
		//先将按钮放入面板中
		p.add(btn);
		p.add(btn2);
		p.add(tf);
		p.add(label);
		p.add(label1);
	 */
		
		//设置窗体的大小
		frame.setSize(800,500);
		//设置窗体的位置
		frame.setLocation(200,200);
		//设置窗体不可改变
		frame.setResizable(false);
		//关闭窗体 关JVM虚拟机
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	//设置窗体可见 true  false不可见
		frame.setVisible(true);
		p.action();
	
		
		
	}
}
