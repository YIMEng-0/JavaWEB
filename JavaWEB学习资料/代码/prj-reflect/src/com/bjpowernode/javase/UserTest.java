package com.bjpowernode.javase;

public class UserTest {

	public static void main(String[] args) throws Exception{
		Class c = Class.forName("com.bjpowernode.javase.User");
		Object obj = c.newInstance();
	}

}
