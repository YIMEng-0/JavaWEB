package com.bjpowernode.tm2;

public class Test {

	public static void main(String[] args) {
		Person zhangsan = new Student();
		zhangsan.templateMethod();
		
		Person lisi = new Worker();
		lisi.templateMethod();
	}

}
