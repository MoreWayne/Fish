package com.tarena.fish;

/*
 * �ӵ���
 */
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Bullet extends Thread {
	// ����
	// 1.����
	BufferedImage img;
	// λ��
	int x, y;
	// ��С
	int width;
	int height;
	// ����
	double roate;
	// �ӵ�����ǰ�ĳ�ʼ����
	Point p;
	// ��������
	Pool pool;
	
	int xx,yy;//�ӵ����ջ����ƶ�ʱ���ƶ���ʵ������
	boolean isMove;//��ʾ�ӵ��߳��Ƿ�ִ�У�true��ʾ�ӵ��߳�ִ�У� false�ӵ��߳̽���
	

	public Bullet(Pool p) {
		try {
			img = ImageIO.read(new File("images/bullet1.png"));
			width = img.getWidth();
			height = img.getHeight();
			// ���������ݹ����ĳ���p��ֵ��pool
			pool = p;
			isMove=true;//��ʼֵΪtrue��ʾ�ӵ��߳����������ӵ����ܹ������ƶ��� 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("�ӵ�ͼƬ��ȡ����");
		}

	}

	@Override
	public void run() {
		// ����move������ʵ���ӵ��Ĳ�ͣ�ƶ�
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
	 * Բ�ģ�a,b�� �뾶r ,�������ϵ����꣨x��y�� x=a+Math.sin(����)*r p.x=a y=b-Math.cos(����)*r
	 * p.y=b
	 * 
	 * ע�� y�������µ�
	 */

	// ����һ��������ʵ���ӵ����ƶ�
	public void move() {
		y = y - 10;
		// ���ӵ����ջ����ƶ�ʱ�İ뾶
		int r = p.y - y;

		xx = p.x + (int) (Math.sin(roate) * r);
		yy = p.y - (int) (Math.cos(roate) * r);
		//�ӵ�ÿ�ƶ�һ�£�����Ƿ��ܻ�����      
		hint();

	}

	// ����һ���������ӵ�������ļ�ⷽ��,����ӵ������㣬ֱ��������ʧ
	public void hint() {
		//�ӳ����л�ȡ������
		Fish[] fs=pool.fishes;
		//ʹ��ѭ�����������е�ÿһ���㣬����Ƿ��ӵ�����
		for (int i = 0; i < fs.length; i++) {
			//��������ȡ��ÿһ����
			Fish f=fs[i];
			if(xx >= f.x && xx <= f.x + f.width && yy >= f.y && yy <= f.y + f.height && f.isLive){
				f.isLive=false;
				//�ѵ�ǰ�ӵ��嵯����ɾ����
				pool.bullets.remove(this);
				//���ӵ�������ʱ����Ҫ��isMove��ֵΪfalse��ͣ�����߳�
				isMove=false;
				//���ó����еĵ�count����,count++
				pool.count++;
				//����printScore�������ı�Ʒְ��ϵĽ��
				pool.printScore(pool.count+"");
			}
		}
	}
	
	
	
	
	
	
}
