package com.bjpowernode.tm2;

public class Student extends Person {

	@Override
	public void do4() {
		System.out.println("学生放学");
	}

	@Override
	public void do3() {
		System.out.println("学生上课");
	}

	@Override
	public void do2() {
		System.out.println("学生吃早餐");
	}

	@Override
	public void do1() {
		System.out.println("学生起床洗漱");
	}

}
