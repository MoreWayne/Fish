package com.tarena.fish;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Barrel {
	//获取大炮图片
	BufferedImage img;
	//大炮的坐标，长宽
	int width;
	int height;
	int x,y;
	//炮台角度
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
			System.out.println("大炮图片读取有误");
		}
	}
	
	
	public void shoot(){
		
	}

}
