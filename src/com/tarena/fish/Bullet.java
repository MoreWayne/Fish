package com.tarena.fish;

/*
 * 子弹类
 */
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Bullet extends Thread {
	// 特征
	// 1.种类
	BufferedImage img;
	// 位置
	int x, y;
	// 大小
	int width;
	int height;
	// 弧度
	double roate;
	// 子弹发射前的初始坐标
	Point p;
	// 池塘对象
	Pool pool;
	
	int xx,yy;//子弹按照弧度移动时，移动的实际坐标
	boolean isMove;//表示子弹线程是否执行，true表示子弹线程执行， false子弹线程结束
	

	public Bullet(Pool p) {
		try {
			img = ImageIO.read(new File("images/bullet1.png"));
			width = img.getWidth();
			height = img.getHeight();
			// 将参数传递过来的池塘p赋值给pool
			pool = p;
			isMove=true;//初始值为true表示子弹线程已启动，子弹是能够正常移动的 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("子弹图片读取有误");
		}

	}

	@Override
	public void run() {
		// 调用move方法，实现子弹的不停移动
		while (isMove) {
			move();
			try {
				Thread.sleep(60);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/*
	 * 圆心（a,b） 半径r ,求桌面上的坐标（x，y） x=a+Math.sin(弧度)*r p.x=a y=b-Math.cos(弧度)*r
	 * p.y=b
	 * 
	 * 注意 y轴是向下的
	 */

	// 定义一个方法，实现子弹的移动
	public void move() {
		y = y - 10;
		// 求子弹按照弧度移动时的半径
		int r = p.y - y;

		xx = p.x + (int) (Math.sin(roate) * r);
		yy = p.y - (int) (Math.cos(roate) * r);
		//子弹每移动一下，检测是否能击中鱼      
		hint();

	}

	// 定义一个方法，子弹击中鱼的检测方法,如果子弹击中鱼，直接让鱼消失
	public void hint() {
		//从池塘中获取多条鱼
		Fish[] fs=pool.fishes;
		//使用循环遍历数组中的每一条鱼，检查是否被子弹击中
		for (int i = 0; i < fs.length; i++) {
			//从数组中取出每一条鱼
			Fish f=fs[i];
			if(xx >= f.x && xx <= f.x + f.width && yy >= f.y && yy <= f.y + f.height && f.isLive){
				f.isLive=false;
				//把当前子弹冲弹夹中删除掉
				pool.bullets.remove(this);
				//当子弹击中鱼时，需要将isMove赋值为false，停掉子线程
				isMove=false;
				//调用池塘中的的count变量,count++
				pool.count++;
				//调用printScore方法，改变计分板上的金币
				pool.printScore(pool.count+"");
			}
		}
	}
	
	
	
	
	
	
}
