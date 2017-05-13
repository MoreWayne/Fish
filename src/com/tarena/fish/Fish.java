package com.tarena.fish;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

/*
 * 1.�����
 */
public class Fish extends Thread {
	// ���࣬��ͬ��ͼƬ������ͬ������
	BufferedImage img;
	// ��С
	int width;

	int height;
	// λ�ã����꣩
	int x;
	int y;
	// �ٶ�
	int step;
	// ��Ķ�����10��ͼƬ��
	BufferedImage[] images;// ����һ��BufferedImage���͵����飬���ڴ洢ʮ�Ŷ���ͼƬ
	//���Ƿ���
	boolean isLive; //true��ʾ���������ڳ������Σ�false��ʾ���㱻����
	//7.��ķ���ͼƬ
	BufferedImage catch01;
	BufferedImage catch02;
	
	// ���޲εĹ��췽����Ϊ�вεĹ��췽��
	public Fish(String type) {
		// ����type��ʾ��ͬ�������="fish01","fish02","fish03"��������"fish"

		try {
			img = ImageIO.read(new File("images/" + type + "_00.png"));
			// ��ȡͼƬ�Ŀ�Ⱥ͸߶�
			width = img.getWidth();
			height = img.getHeight();

			// ��ʱ������x��y��ֵ,������random
			Random r = new Random();
			x = 800;
			y = r.nextInt(500 - height-100);
			step = r.nextInt(10) + 1;
			// ������������images�Ĵ�С����СΪ10
			images = new BufferedImage[10];
			// ��ȡÿһ�������10�Ŷ���ͼƬ������������images�У�
			for (int i = 0; i < images.length; i++) {
				images[i] = ImageIO.read(new File("images/" + type + "_0" + i
						+ ".png"));
			}
			//������isLive��ֵΪtrue����ʾ��տ�ʼ�������ε�
			isLive=true;
			//������catch01��catch02��ֵ
			catch01=ImageIO.read(new File("images/"+type+"_catch_01.png"));
			catch02=ImageIO.read(new File("images/"+type+"_catch_02.png"));

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("��ͼƬ��ȡ����");
		}

	}

	// ����run������ʵ������ƶ�

	int index = 0;// ����һ��������ʼֵΪ0����ʾ��������images���±�Ϊ0

	public void run() {
		// ʵ����Ĳ�ͣ�ƶ�
		while (true) {
			
			if(isLive){ //�������ε�����£�
				//����move������ʵ������
				move();

			}else{ //�㱻��׽�������                              
				//1.�㷭��2.����ʧ
				turnOver();
				goOut();
			}
			
			try {
				Thread.sleep(60);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// ���½������ʱ���ı�λ�ã��ٶ�
		}
	}
	
	
	
	

	// ����һ�����������εķ�����1.ֱ����2.��Ķ���Ч����
	public void move() {
		x -= step;// ʵ�������ǰ��
		// �жϳ�ȥ�����������¿�ʼ��
		if (x <= -width) {
			goOut();		//����goOut������������ʧ���½������

		}
		// ʵ����Ķ���Ч�������Լ���
		// ����һ����˳�򣬰���һ�����ٶȲ���10��ͼƬ��
		// ����һ����˳��--��Ϊ�����ǰ���˳�����ν�10�Ŷ���ͼƬ���������У����δ�������ȡ��10�Ŷ���ͼƬ����
		// ����һ�����ٶ�---��ǰwhile��ѭ��ÿ��60����ִ�����Σ�
		// ����10��ͼƬ----��10�Ŷ���ͼƬ��Img���¸�ֵ���ٳ�����paint�����л���img��Ϊ����

		img = images[index];
		index++;// ÿ��60���1 һ��10��ͼ��10��ͼ����������²���
		// ʵ����Ķ���Ч��
		if (index == 10) {
			index = 0;
		}
	}
	
	//����һ������������ʧ�����½������
	
	public void goOut(){
		x = 800;
		Random r = new Random();
		step = r.nextInt(10) + 1;
		y = r.nextInt(500 - height-100);
		//����ʧ���½��������isLiveֻ�и�ֵΪtrue��������������move����ʵ����
		isLive=true;
		
	}
	//����һ������ʵ���㱻��׽���ڵ�Ч��
	public void turnOver(){
		//��catch01��catch02���������ڵ�ͼƬ��img��ֵ����
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
