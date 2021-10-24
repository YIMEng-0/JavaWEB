package com.bjpowernode.tm2;

public class Worker extends Person {

	@Override
	public void do4() {
		System.out.println("工人下班");
	}

	@Override
	public void do3() {
		System.out.println("工人开始工作");
	}

	@Override
	public void do2() {
		System.out.println("工人吃早餐");
	}

	@Override
	public void do1() {
		System.out.println("工人起床洗漱");
	}

}
