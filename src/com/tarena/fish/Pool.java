package com.tarena.fish;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

 /*
 * 特征 --属性
 * 1.水，水草，环境，背景图片 BufferedImage
 * 2.多条鱼
 * 3.渔网
 * 4.积分板
 * 5.大炮
 * 6.子弹
 * 
 * 左下角计分板                  
 * 
 * 
 * 
 * 构造器（构造方法） 对当前类的属性初始化
 * 构造方法的执行时机，在创建对象时（new 对象）的时执行构造方法中的内容
 * 构造方法的语法：public 开始，构造方法的方法名和当前类名和当前所在的类名相同,无返回值类型
 * 
 * 
 * extends 子类Pool 继承  JPanel 类
 * JPanel 面板中有绘画功能，可以使用画笔画画
 * 
 */
public class Pool extends JPanel {
	BufferedImage bg;// 背景图片
	// 渔网
	// Fish f;
	// 实现多条鱼
	Fish[] fishes;
	Net net;
	BufferedImage bar;
	Barrel barrel;
	//弹夹,该集合容器用于存储子弹,泛型，只能放对于类型的数据
	ArrayList<Bullet> bullets=new ArrayList<Bullet>();
	

	// BufferedImage[][] golds;//用于表示存储金币的数组
	BufferedImage[] golds;// 用于表示存储金币的数组
	int mouseX;
	int mouseY;
	double f;//大炮的弧度
	int centerX;//大炮旋转的x坐标
	int centerY;//大炮旋转的y坐标

	public Pool() {
		// 对象bg赋值，从images文件夹中读取到bg.jpg这张图片给bg赋值
		// ImageIO 是java提供的工具类，能够方便的读取某一个图片,该图片是以文件的形式读取的
		try {
			// 添加背景图片
			bg = ImageIO.read(new File("images/bg.jpg"));
			// 添加计分板图片
			bar = ImageIO.read(new File("images/bottom-bar.png"));
			// 给炮台赋值
			barrel = new Barrel();

			// 创建gold数组的大小，用于存储金币
			// glods=new BufferedImage[6][10];
			// for(int i=0;i<6;i++){
			// for(int j=0;j<10;j++){
			// glods[i][j]=ImageIO.read(new File("images/"+j+".png"));
			// }
			// }
			golds = new BufferedImage[6];
			for (int i = 0; i < golds.length; i++) {
				golds[i] = ImageIO.read(new File("images/0.png"));
			}

			// 创建一条鱼，给属性f赋值
			// f=new Fish();
			net = new Net();
			// 创建多条鱼,并往数组中存储鱼对象，同时启动每条鱼的线程
			fishes = new Fish[11];
			// for循环给fishes数组赋值
			for (int i = 0; i < 9; i++) {
				// fish00 fish02...fish08 i
				// fish01..........fish09 i+1
				fishes[i] = new Fish("fish0" + (i + 1));
				fishes[i].start();
			}
			// 单独创建fish13，fish14
			fishes[9] = new Fish("fish13");
			fishes[10] = new Fish("fish14");
			// 启动fish13和fish14两条鱼的线程
			fishes[9].start();
			fishes[10].start();

			// f.start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("文件读取有误");
		}
		// try {
		// //fish05_09;
		// fish05_09=ImageIO.read(new File("images/fish05_09.png"));
		// } catch (IOException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		// try {
		// //bottom_bar
		// bottom_bar=ImageIO.read(new File("images/bottom-bar.png"));
		// } catch (IOException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		//
	}

	// 在池塘对象中调出绘画的方法，在池塘中画出内容
	// paint,该paint方法是父类JPanel，因为有继承关系，所有在子类中可以调用
	public void paint(Graphics g) {
		// 使用画笔g,将bg画在池塘类中
		// 参数1:所 要画的图片 参数2和3：所画图片左上角的坐标，参数4和5，所画图片的高度和宽度
		g.drawImage(bg, 0, 0, 800, 500, null);// 加背景
		// 画出底部计分板
		g.drawImage(bar, 0, 400, bar.getWidth(), bar.getHeight(), null);//

		// 获取能够画图片旋转功能的高级画笔 Graphics--> Graphics2D
		Graphics2D g2d = (Graphics2D) g.create();

		// rotate(弧度，旋转的x,y坐标)
		centerX = barrel.x + barrel.width / 2;
		centerY = barrel.y + barrel.height / 2;

		double x1 = mouseX - centerX;
		double y1 = mouseY - centerY;
		f = -Math.atan(x1 / y1);
		g2d.rotate(f, centerX, centerY);

		g2d.drawImage(barrel.img, barrel.x, barrel.y, barrel.width,
				barrel.height, null);//

		// 计分板
		// for(int i=0;i<glods.length;i++){
		// g.drawImage(glods[i][0],glods[0][0].getWidth()*i,420,glods[i][0].getWidth(),glods[i][0].getHeight(),null);
		// }
		// 使用画笔将数组中的金币画出来
		for (int i = 0; i < golds.length; i++) {
			g.drawImage(golds[i], 20 + i * 23, 445, 20, 20, null);
		}
		//使用画笔g将弹夹bullets中所有子弹画出来
		for(int i=0;i<bullets.size();i++){
			//根据下标i从集合bullets中取出一颗子弹
			Bullet b=bullets.get(i);
			//先获取Graphics2D类型的画笔
			Graphics2D d2=(Graphics2D)g.create();
			d2.rotate(b.roate, centerX,centerY);
			d2.drawImage(b.img, b.x, b.y, b.width, b.height, null);
		}
			
		

		// 画出炮台barrel

		// 使用画笔g将鱼画在池塘中
		// 通过Fish对象f调用 画图
		// g.drawImage(f.img, f.x, f.y, f.width, f.height,null);
		for (int i = 0; i < fishes.length; i++) {
			g.drawImage(fishes[i].img, fishes[i].x, fishes[i].y,
					fishes[i].width, fishes[i].height, null);
		}
		// 使用画笔将渔网画在池塘中
		// 让渔网的坐标格减一半，即鼠标的坐标和渔网的中心坐标重合
		int x = net.x - net.width / 2;
		int y = net.y - net.height / 2;
		// if（）里的条件，条件为true，鼠标进入池塘，画出渔网，
		// 条件为false，鼠标出去池塘，隐藏渔网
		if (net.isShow) {
			g.drawImage(net.net09, x, y, net.width, net.height, null);
		}
		// 设值画笔的颜色
		g.setColor(new Color(255, 0, 0));
		// 设值画笔字体
		g.setFont(new Font("楷体", Font.BOLD, 20));
		// 画字符串
		g.drawString(count + "", 50, 80);
		// 画出时间戳
		Date d = new Date();
		g.drawString(d.toString(), 50, 50);

	}

	public void action() {
		// 监听鼠标在当前池塘中的一些操作，使用MouseAdapter来完成
		MouseAdapter mouse = new MouseAdapter() {
			// 鼠标进入事件的监听----渔网 的显示功能
			public void mouseEntered(MouseEvent arg0) {
				net.isShow = true;
			}

			// 鼠标离开事件的监听---渔网隐藏功能
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				net.isShow = false;
			}

			// 鼠标移动事件的监听---渔网跟着鼠标移动的功能
			public void mouseMoved(MouseEvent e) {
				// TODO Auto-generated method stub
				// 获取鼠标在池塘中的坐标
				mouseX = e.getX();
				mouseY = e.getY();
				// 通过net调用Net类中定义的moveTo方法
				net.moveTo(mouseX, mouseY);
			}

			// 鼠标按下事件的监听--渔网捕鱼的功能
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
//				catchFish();
				//鼠标按下时，创建子弹对象,同时把当前池塘对象作为参数传过去
				Bullet bullet = new Bullet(Pool.this);
				
				//给子弹弧度赋值，子弹的弧度和大炮的弧度一致
				bullet.roate=f;
				//给子弹的坐标赋值
				bullet.x=centerX-10;//bullet.width/2
				bullet.y=centerY-17;//bullet.height/2
				//给子弹发射前的初始坐标p赋值
				bullet.p=new Point(centerX-10, centerY-17);
				//启动线程
				bullet.start();
				//将子弹放入弹夹中存储
				bullets.add(bullet);
			}

		};

		// 将监听事件绑定到当前池塘中
		this.addMouseListener(mouse);
		this.addMouseMotionListener(mouse);

		// 下面的while（true）不停的刷新池塘面板
		while (true) {
			repaint();
		}
	}

	int count = 0;

	public void catchFish() {
		for (int i = 0; i < fishes.length; i++) {
			Fish fish = fishes[i];
			// 判断渔网是否捕到了鱼
			if (net.isCanCatchFish(fish)) {
				// fish.x=800;
				// Random r=new Random();
				// fish.y=r.nextInt(500-fish.height);
				// fish.step=r.nextInt(5)+1;
				// 如果渔网捕到了鱼，让isLive赋值为false
				fish.isLive = false;
				count++;
				// 数组中存储的金币要对应的修改为count的数值
				// 将count变量由整数类型转化为字符串类型
				String strCount = count + ""; // strCount"3815"
				// strCount "3815" charAt
				// j 0123
				printScore(strCount);
			}
		}
	}
	//定义一个方法，改变计分板上的金币，让金币和鱼的条数同步
	public void printScore(String strCount){
		
		for (int j = 0; j < strCount.length(); j++) {
			// new File()
			// strCount.charAt(strCount.length()-1-j);
			try {
				golds[5 - j] = ImageIO.read(new File("images/"
						+ strCount.charAt(strCount.length() - 1 - j)
						+ ".png"));

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("金币图片读取有误");
			}
		}
	}

}
