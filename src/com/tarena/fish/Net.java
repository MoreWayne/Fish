package com.tarena.fish;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
/*
 *��������
 *�����Ʋ���
 *
 */
public class Net {
	//��С���ٶ� ��λ��
	BufferedImage net09;
	int width;
	int height;
	int x,y;
	//��������ʾ������
	//isShowΪtrue ��ʾ������ʾ���������������ʱ����Ҫ��isSHow��ֵΪtrue
	//Ϊfalse�������� ��������뿪����ʱ��Ҫ��isShow��ֵΪfalse
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
			System.out.println("ͼƬ��ȡ����");
		}
	}
	
	
	
	//��Ϊ������  catch
	//����һ�����������������������Ϊ��������
	public void moveTo(int mouseX,int mouseY){
		//x,yΪ���������꣬mouseX��mouseYΪ��������
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
