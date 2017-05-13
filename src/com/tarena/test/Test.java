package com.tarena.test;

public class Test {

	public static void main(String[] args) {
		//创建抽象类的子类
//		Animal d=new Dog();//向上转型
//		d.shout();
//		Animal c=new Cat();
//		c.shout();
		//匿名内部类
		//匿名内部类没有类名，但是有{}类体，创建的是父类类名
		Animal d=new Animal(){
			public void shout() {
				System.out.println("汪汪汪");
			}
		};
		d.shout();
		
		Animal c=new Animal(){
			public void shout() {
				System.out.println("喵喵喵");
			}
			
		};
		c.shout();
		
	}

}
