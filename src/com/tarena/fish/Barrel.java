package com.tarena.fish;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Barrel {
	//��ȡ����ͼƬ
	BufferedImage img;
	//���ڵ����꣬����
	int width;
	int height;
	int x,y;
	//��̨�Ƕ�
	int angle;
	
	
	public Barrel(){
		try {
			img=ImageIO.read(new File("images/barrel.png"));
			width=img.getWidth();
			height=img.getHeight();
			
			x=400;
			y=400;
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("����ͼƬ��ȡ����");
		}
	}
	
	
	public void shoot(){
		
	}

}
