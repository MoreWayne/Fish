package com.tarena.test;

public class Test {

	public static void main(String[] args) {
		//���������������
//		Animal d=new Dog();//����ת��
//		d.shout();
//		Animal c=new Cat();
//		c.shout();
		//�����ڲ���
		//�����ڲ���û��������������{}���壬�������Ǹ�������
		Animal d=new Animal(){
			public void shout() {
				System.out.println("������");
			}
		};
		d.shout();
		
		Animal c=new Animal(){
			public void shout() {
				System.out.println("������");
			}
			
		};
		c.shout();
		
	}

}
