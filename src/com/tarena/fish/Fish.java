package com.tarena.fish;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

/*
 * 1.鱼对象
 */
public class Fish extends Thread {
	// 种类，不同的图片决定不同的种类
	BufferedImage img;
	// 大小
	int width;

	int height;
	// 位置（坐标）
	int x;
	int y;
	// 速度
	int step;
	// 鱼的动画（10张图片）
	BufferedImage[] images;// 定义一个BufferedImage类型的数组，用于存储十张动画图片
	//鱼是否存活
	boolean isLive; //true表示该鱼正常在池塘中游，false表示该鱼被捕到
	//7.鱼的翻腾图片
	BufferedImage catch01;
	BufferedImage catch02;
	
	// 把无参的构造方法改为有参的构造方法
	public Fish(String type) {
		// 参数type表示不同种类的鱼="fish01","fish02","fish03"。。。。"fish"

		try {
			img = ImageIO.read(new File("images/" + type + "_00.png"));
			// 获取图片的宽度和高度
			width = img.getWidth();
			height = img.getHeight();

			// 临时给变量x和y赋值,后期用random
			Random r = new Random();
			x = 800;
			y = r.nextInt(500 - height-100);
			step = r.nextInt(10) + 1;
			// 创建数组容器images的大小，大小为10
			images = new BufferedImage[10];
			// 读取每一种类的鱼10张动画图片，并放入数组images中；
			for (int i = 0; i < images.length; i++) {
				images[i] = ImageIO.read(new File("images/" + type + "_0" + i
						+ ".png"));
			}
			//给变量isLive赋值为true，表示鱼刚开始是正常游的
			isLive=true;
			//给变量catch01和catch02赋值
			catch01=ImageIO.read(new File("images/"+type+"_catch_01.png"));
			catch02=ImageIO.read(new File("images/"+type+"_catch_02.png"));

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("鱼图片读取有误");
		}

	}

	// 调出run方法，实现鱼的移动

	int index = 0;// 定义一个变量初始值为0，表示访问数组images的下标为0

	public void run() {
		// 实现鱼的不停移动
		while (true) {
			
			if(isLive){ //鱼正常游的情况下，
				//调用move方法，实现鱼游
				move();

			}else{ //鱼被捕捉到的情况                              
				//1.鱼翻腾2.鱼消失
				turnOver();
				goOut();
			}
			
			try {
				Thread.sleep(60);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// 重新进入池塘时，改变位置，速度
		}
	}
	
	
	
	

	// 定义一个方法，鱼游的方法（1.直线游2.鱼的动画效果）
	public void move() {
		x -= step;// 实现鱼的往前游
		// 判断出去后，再让鱼重新开始游
		if (x <= -width) {
			goOut();		//调用goOut方法，让鱼消失重新进入池塘

		}
		// 实现鱼的动画效果，鱼自己动
		// 按照一定的顺序，按照一定的速度播放10张图片、
		// 按照一定的顺序--因为我们是按照顺序依次将10张动画图片放入数组中，依次从数组中取出10张动画图片即可
		// 按照一定的速度---当前while死循环每个60毫秒执行依次，
		// 播放10张图片----将10张动画图片给Img重新赋值，再池塘的paint方法中画出img即为播放

		img = images[index];
		index++;// 每隔60秒加1 一共10张图，10张图播放完后，重新播放
		// 实现鱼的动画效果
		if (index == 10) {
			index = 0;
		}
	}
	
	//定义一个方法，鱼消失，重新进入池塘
	
	public void goOut(){
		x = 800;
		Random r = new Random();
		step = r.nextInt(10) + 1;
		y = r.nextInt(500 - height-100);
		//鱼消失重新进入池塘，isLive只有赋值为true，才能正常调用move方法实现游
		isLive=true;
		
	}
	//定义一个方法实现鱼被捕捉后翻腾的效果
	public void turnOver(){
		//将catch01和catch02这两个翻腾的图片给img赋值即可
		for(int i=1;i<=5;i++){
		
		try {
			img=catch01;
			Thread.sleep(100);
			img=catch02;
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	
		}
		
	}
	
	
	

}
