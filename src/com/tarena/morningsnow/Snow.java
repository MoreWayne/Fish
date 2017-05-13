package com.tarena.morningsnow;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
//让雪花对象继承Thread成为一个线程，因为每一个雪花的下落是一个并发现象
public class Snow extends Thread{
	//特征，属性
	//种类
	BufferedImage snowimg;
	//坐标
	int x;
	int y;
	
	//大小
	int width;
	int height;
	//速度 1 2 3 4 5
	int step;
	
	
	
	//构造方法
	public Snow() {
		try {
			snowimg=ImageIO.read(new File("images/snow.png"));
			
			//获取图片的实际宽度和高度
			height=snowimg.getHeight();
			width=snowimg.getWidth();
			
			Random r=new Random();
			
			
			x=r.nextInt(700-width);//700-width
			y=-height;
			//给step赋值，1-5之间随机赋值
			step=r.nextInt(5)+1;//0-4-->1-5
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("雪图片获取错误");
		}
		
	}
	//行为
	@Override
	//该run方法，实现雪花的不停下落
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
			//判断雪花师傅会落出窗体
			if(y>=500){
				y=-height;
				//重新给雪花下落的速度step赋值
				Random r=new Random();
				step=r.nextInt(10)+1;
				//重新给x赋值，下次从不同的地方出现
				x=r.nextInt(700-width);
				
			}
			
		}
		
		
		
	}
	

}
