package com.tarena.morningsnow;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
//��ѩ������̳�Thread��Ϊһ���̣߳���Ϊÿһ��ѩ����������һ����������
public class Snow extends Thread{
	//����������
	//����
	BufferedImage snowimg;
	//����
	int x;
	int y;
	
	//��С
	int width;
	int height;
	//�ٶ� 1 2 3 4 5
	int step;
	
	
	
	//���췽��
	public Snow() {
		try {
			snowimg=ImageIO.read(new File("images/snow.png"));
			
			//��ȡͼƬ��ʵ�ʿ�Ⱥ͸߶�
			height=snowimg.getHeight();
			width=snowimg.getWidth();
			
			Random r=new Random();
			
			
			x=r.nextInt(700-width);//700-width
			y=-height;
			//��step��ֵ��1-5֮�������ֵ
			step=r.nextInt(5)+1;//0-4-->1-5
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("ѩͼƬ��ȡ����");
		}
		
	}
	//��Ϊ
	@Override
	//��run������ʵ��ѩ���Ĳ�ͣ����
	public void run() {
		while(true){
			y+=step;
			System.out.println(y);
			try {
				Thread.sleep(60);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//�ж�ѩ��ʦ�����������
			if(y>=500){
				y=-height;
				//���¸�ѩ��������ٶ�step��ֵ
				Random r=new Random();
				step=r.nextInt(10)+1;
				//���¸�x��ֵ���´δӲ�ͬ�ĵط�����
				x=r.nextInt(700-width);
				
			}
			
		}
		
		
		
	}
	

}
