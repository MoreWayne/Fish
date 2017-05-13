package com.tarena.morningsnow;
/*
 * ��ն���
 */
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Sky extends JPanel{
	//����������
	BufferedImage bg;
//	Snow snow;
	//���ѩ��,����һ��Snow���͵��������������ڴ洢���ѩ������
	Snow[] snows;
	
	
	//��Ϊ����
	public Sky(){
		try {
			bg=ImageIO.read(new File("images/sky.jpg"));
			//����ѩ�����󣬴���ѩ���߳�
//			snow=new Snow();
			//����snows���������Ĵ�С
			snows=new Snow[100];
			//��100��ѩ����ֵ
			for(int i=0;i<snows.length;i++){
			snows[i]=new Snow();
			//�����������������е�ѩ���߳�
			snows[i].start();
			}
			//�����߳�
//			snow.start();
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("can't find snow ");
		}
		
	}
	@Override
	//��new Sky ��ʱ��paintִֻ����һ�Σ�ֻ����һ��
	public void paint(Graphics g) {
		//ʹ�û��ʽ�bg���������
		g.drawImage(bg,0,0,700,500,null);
		//��ѩ�����������
//		g.drawImage(snow.snowimg,snow.x,snow.y,snow.width,snow.height,null);
		//ʹ�û���g,���������������е�ѩ�����������
		for(int i=0;i<snows.length;i++){
			g.drawImage(snows[i].snowimg,snows[i].x, snows[i].y, snows[i].width,snows[i].height,null);
		}
		
		
	}
	//���һ����������ͣ�� ����paint������ˢ�������������
	public void action(){
		while(true){
			repaint();//�÷����Ǹ����JPanel�У���Ϊ�м̳й�ϵ��������������ֱ��ʹ�ø�i��repaint�����Ĺ��ܣ�����repaint������ִ��
			
		}
	}
	

}
