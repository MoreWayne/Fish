package com.tarena.fish;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/* 1. ���в�����˵�����
 * 2.
 */

public class Main {
	public static void main(String[] args) {
		
		JFrame frame=new JFrame("�������-���԰�1.0");
		Pool p=new Pool();
		//��������ӵ�������
		frame.add(p);
		
		
	 /*
	  	//����һ�����
		JPanel p=new JPanel();
		//����һ����ť
		JButton btn=new JButton("����");
		JButton btn2=new JButton("ȷ��");
		   
		//����һ�������ı������
		JTextField tf=new JTextField(10);
		//����һ����ǩ
		JLabel label=new JLabel("hello world");
		ImageIcon img=new ImageIcon("images/images/fish08_00.png");//����һ��ͼƬͼ����ʾͼƬ��·�������ƣ�
		JLabel label1=new JLabel(img);
		//�Ƚ���ť���������
		p.add(btn);
		p.add(btn2);
		p.add(tf);
		p.add(label);
		p.add(label1);
	 */
		
		//���ô���Ĵ�С
		frame.setSize(800,500);
		//���ô����λ��
		frame.setLocation(200,200);
		//���ô��岻�ɸı�
		frame.setResizable(false);
		//�رմ��� ��JVM�����
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	//���ô���ɼ� true  false���ɼ�
		frame.setVisible(true);
		p.action();
	
		
		
	}
}
