package com.tarena.fish;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
/*
 *渔网对象
 *鼠标控制捕鱼
 *
 */
public class Net {
	//大小，速度 ，位置
	BufferedImage net09;
	int width;
	int height;
	int x,y;
	//渔网的显示或隐藏
	//isShow为true 表示渔网显示（当鼠标进入池塘的时候需要将isSHow赋值为true
	//为false渔网隐藏 ，当鼠标离开池塘时需要将isShow赋值为false
	boolean isShow;
	
	public Net(){
		try {
			net09=ImageIO.read(new File("images/net09.png"));
			width=net09.getWidth();
			height=net09.getHeight();
			x=200;
			y=100;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("图片读取有误");
		}
	}
	
	
	
	//行为，捕鱼  catch
	//定义一个方法，将渔网的坐标更改为鼠标的坐标
	public void moveTo(int mouseX,int mouseY){
		//x,y为渔网的坐标，mouseX和mouseY为鼠标的坐标
		x=mouseX;
		y=mouseY;
	}
	public boolean isCanCatchFish(Fish f){
		int dx=x-f.x;
		int dy=y-f.y;
		boolean flag=dx>=0 && dx<=f.width && dy>=0 && dy<=f.height;
		return flag;
		
	}
	
	

}
