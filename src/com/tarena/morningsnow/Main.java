package com.tarena.morningsnow;
/*
 * 1.����ѩ��Ʈ�������
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
		//��������
		JFrame frame=new JFrame("ѩѩѩѩ");
		//������ն���
		Sky sky=new Sky();
		//��ӵ�������
		frame.add(sky);
		
		
		
		
		
		
		
		//���ô���
		frame.setSize(700,500);
		frame.setLocation(400, 500);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//ͨ����ն�������Լ������action������Ҫ���ڴ�������һ�е��ã���Ϊ ��ѭ��
		sky.action();
	}

}
