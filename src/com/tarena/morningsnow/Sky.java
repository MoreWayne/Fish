package com.tarena.morningsnow;
/*
 * 天空对象，
 */
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Sky extends JPanel{
	//特征，属性
	BufferedImage bg;
//	Snow snow;
	//多个雪花,定义一个Snow类型的数组容器，用于存储多个雪花对象
	Snow[] snows;
	
	
	//行为方法
	public Sky(){
		try {
			bg=ImageIO.read(new File("images/sky.jpg"));
			//创建雪花对象，创建雪花线程
//			snow=new Snow();
			//创建snows数组容器的大小
			snows=new Snow[100];
			//给100个雪花赋值
			for(int i=0;i<snows.length;i++){
			snows[i]=new Snow();
			//启动数组容器中所有的雪花线程
			snows[i].start();
			}
			//启动线程
//			snow.start();
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("can't find snow ");
		}
		
	}
	@Override
	//在new Sky 类时，paint只执行了一次，只画了一次
	public void paint(Graphics g) {
		//使用画笔将bg画在天空中
		g.drawImage(bg,0,0,700,500,null);
		//将雪花画在天空中
//		g.drawImage(snow.snowimg,snow.x,snow.y,snow.width,snow.height,null);
		//使用画笔g,将数组容器中所有的雪花画在天空中
		for(int i=0;i<snows.length;i++){
			g.drawImage(snows[i].snowimg,snows[i].x, snows[i].y, snows[i].width,snows[i].height,null);
		}
		
		
	}
	//添加一个方法，不停地 调用paint方法，刷新天空面板的内容
	public void action(){
		while(true){
			repaint();//该方法是父类的JPanel中，因为有继承关系，可以在子类中直接使用该i，repaint方法的功能，调用repaint方法的执行
			
		}
	}
	

}
