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
 * ���� --����
 * 1.ˮ��ˮ�ݣ�����������ͼƬ BufferedImage
 * 2.������
 * 3.����
 * 4.���ְ�
 * 5.����
 * 6.�ӵ�
 * 
 * ���½ǼƷְ�                  
 * 
 * 
 * 
 * �����������췽���� �Ե�ǰ������Գ�ʼ��
 * ���췽����ִ��ʱ�����ڴ�������ʱ��new ���󣩵�ʱִ�й��췽���е�����
 * ���췽�����﷨��public ��ʼ�����췽���ķ������͵�ǰ�����͵�ǰ���ڵ�������ͬ,�޷���ֵ����
 * 
 * 
 * extends ����Pool �̳�  JPanel ��
 * JPanel ������л滭���ܣ�����ʹ�û��ʻ���
 * 
 */
public class Pool extends JPanel {
	BufferedImage bg;// ����ͼƬ
	// ����
	// Fish f;
	// ʵ�ֶ�����
	Fish[] fishes;
	Net net;
	BufferedImage bar;
	Barrel barrel;
	//����,�ü����������ڴ洢�ӵ�,���ͣ�ֻ�ܷŶ������͵�����
	ArrayList<Bullet> bullets=new ArrayList<Bullet>();
	

	// BufferedImage[][] golds;//���ڱ�ʾ�洢��ҵ�����
	BufferedImage[] golds;// ���ڱ�ʾ�洢��ҵ�����
	int mouseX;
	int mouseY;
	double f;//���ڵĻ���
	int centerX;//������ת��x����
	int centerY;//������ת��y����

	public Pool() {
		// ����bg��ֵ����images�ļ����ж�ȡ��bg.jpg����ͼƬ��bg��ֵ
		// ImageIO ��java�ṩ�Ĺ����࣬�ܹ�����Ķ�ȡĳһ��ͼƬ,��ͼƬ�����ļ�����ʽ��ȡ��
		try {
			// ��ӱ���ͼƬ
			bg = ImageIO.read(new File("images/bg.jpg"));
			// ��ӼƷְ�ͼƬ
			bar = ImageIO.read(new File("images/bottom-bar.png"));
			// ����̨��ֵ
			barrel = new Barrel();

			// ����gold����Ĵ�С�����ڴ洢���
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

			// ����һ���㣬������f��ֵ
			// f=new Fish();
			net = new Net();
			// ����������,���������д洢�����ͬʱ����ÿ������߳�
			fishes = new Fish[11];
			// forѭ����fishes���鸳ֵ
			for (int i = 0; i < 9; i++) {
				// fish00 fish02...fish08 i
				// fish01..........fish09 i+1
				fishes[i] = new Fish("fish0" + (i + 1));
				fishes[i].start();
			}
			// ��������fish13��fish14
			fishes[9] = new Fish("fish13");
			fishes[10] = new Fish("fish14");
			// ����fish13��fish14��������߳�
			fishes[9].start();
			fishes[10].start();

			// f.start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("�ļ���ȡ����");
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

	// �ڳ��������е����滭�ķ������ڳ����л�������
	// paint,��paint�����Ǹ���JPanel����Ϊ�м̳й�ϵ�������������п��Ե���
	public void paint(Graphics g) {
		// ʹ�û���g,��bg���ڳ�������
		// ����1:�� Ҫ����ͼƬ ����2��3������ͼƬ���Ͻǵ����꣬����4��5������ͼƬ�ĸ߶ȺͿ��
		g.drawImage(bg, 0, 0, 800, 500, null);// �ӱ���
		// �����ײ��Ʒְ�
		g.drawImage(bar, 0, 400, bar.getWidth(), bar.getHeight(), null);//

		// ��ȡ�ܹ���ͼƬ��ת���ܵĸ߼����� Graphics--> Graphics2D
		Graphics2D g2d = (Graphics2D) g.create();

		// rotate(���ȣ���ת��x,y����)
		centerX = barrel.x + barrel.width / 2;
		centerY = barrel.y + barrel.height / 2;

		double x1 = mouseX - centerX;
		double y1 = mouseY - centerY;
		f = -Math.atan(x1 / y1);
		g2d.rotate(f, centerX, centerY);

		g2d.drawImage(barrel.img, barrel.x, barrel.y, barrel.width,
				barrel.height, null);//

		// �Ʒְ�
		// for(int i=0;i<glods.length;i++){
		// g.drawImage(glods[i][0],glods[0][0].getWidth()*i,420,glods[i][0].getWidth(),glods[i][0].getHeight(),null);
		// }
		// ʹ�û��ʽ������еĽ�һ�����
		for (int i = 0; i < golds.length; i++) {
			g.drawImage(golds[i], 20 + i * 23, 445, 20, 20, null);
		}
		//ʹ�û���g������bullets�������ӵ�������
		for(int i=0;i<bullets.size();i++){
			//�����±�i�Ӽ���bullets��ȡ��һ���ӵ�
			Bullet b=bullets.get(i);
			//�Ȼ�ȡGraphics2D���͵Ļ���
			Graphics2D d2=(Graphics2D)g.create();
			d2.rotate(b.roate, centerX,centerY);
			d2.drawImage(b.img, b.x, b.y, b.width, b.height, null);
		}
			
		

		// ������̨barrel

		// ʹ�û���g���㻭�ڳ�����
		// ͨ��Fish����f���� ��ͼ
		// g.drawImage(f.img, f.x, f.y, f.width, f.height,null);
		for (int i = 0; i < fishes.length; i++) {
			g.drawImage(fishes[i].img, fishes[i].x, fishes[i].y,
					fishes[i].width, fishes[i].height, null);
		}
		// ʹ�û��ʽ��������ڳ�����
		// ��������������һ�룬��������������������������غ�
		int x = net.x - net.width / 2;
		int y = net.y - net.height / 2;
		// if�����������������Ϊtrue�����������������������
		// ����Ϊfalse������ȥ��������������
		if (net.isShow) {
			g.drawImage(net.net09, x, y, net.width, net.height, null);
		}
		// ��ֵ���ʵ���ɫ
		g.setColor(new Color(255, 0, 0));
		// ��ֵ��������
		g.setFont(new Font("����", Font.BOLD, 20));
		// ���ַ���
		g.drawString(count + "", 50, 80);
		// ����ʱ���
		Date d = new Date();
		g.drawString(d.toString(), 50, 50);

	}

	public void action() {
		// ��������ڵ�ǰ�����е�һЩ������ʹ��MouseAdapter�����
		MouseAdapter mouse = new MouseAdapter() {
			// �������¼��ļ���----���� ����ʾ����
			public void mouseEntered(MouseEvent arg0) {
				net.isShow = true;
			}

			// ����뿪�¼��ļ���---�������ع���
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				net.isShow = false;
			}

			// ����ƶ��¼��ļ���---������������ƶ��Ĺ���
			public void mouseMoved(MouseEvent e) {
				// TODO Auto-generated method stub
				// ��ȡ����ڳ����е�����
				mouseX = e.getX();
				mouseY = e.getY();
				// ͨ��net����Net���ж����moveTo����
				net.moveTo(mouseX, mouseY);
			}

			// ��갴���¼��ļ���--��������Ĺ���
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
//				catchFish();
				//��갴��ʱ�������ӵ�����,ͬʱ�ѵ�ǰ����������Ϊ��������ȥ
				Bullet bullet = new Bullet(Pool.this);
				
				//���ӵ����ȸ�ֵ���ӵ��Ļ��Ⱥʹ��ڵĻ���һ��
				bullet.roate=f;
				//���ӵ������긳ֵ
				bullet.x=centerX-10;//bullet.width/2
				bullet.y=centerY-17;//bullet.height/2
				//���ӵ�����ǰ�ĳ�ʼ����p��ֵ
				bullet.p=new Point(centerX-10, centerY-17);
				//�����߳�
				bullet.start();
				//���ӵ����뵯���д洢
				bullets.add(bullet);
			}

		};

		// �������¼��󶨵���ǰ������
		this.addMouseListener(mouse);
		this.addMouseMotionListener(mouse);

		// �����while��true����ͣ��ˢ�³������
		while (true) {
			repaint();
		}
	}

	int count = 0;

	public void catchFish() {
		for (int i = 0; i < fishes.length; i++) {
			Fish fish = fishes[i];
			// �ж������Ƿ񲶵�����
			if (net.isCanCatchFish(fish)) {
				// fish.x=800;
				// Random r=new Random();
				// fish.y=r.nextInt(500-fish.height);
				// fish.step=r.nextInt(5)+1;
				// ��������������㣬��isLive��ֵΪfalse
				fish.isLive = false;
				count++;
				// �����д洢�Ľ��Ҫ��Ӧ���޸�Ϊcount����ֵ
				// ��count��������������ת��Ϊ�ַ�������
				String strCount = count + ""; // strCount"3815"
				// strCount "3815" charAt
				// j 0123
				printScore(strCount);
			}
		}
	}
	//����һ���������ı�Ʒְ��ϵĽ�ң��ý�Һ��������ͬ��
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
				System.out.println("���ͼƬ��ȡ����");
			}
		}
	}

}
