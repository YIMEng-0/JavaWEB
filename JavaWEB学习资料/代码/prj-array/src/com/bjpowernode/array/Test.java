package com.bjpowernode.array;

import java.util.Date;

/**
 * 数组的toString方法是什么样子的？
 * 		[数组中元素的类型@内存地址
 */
public class Test {

	public static void main(String[] args) {
		
		int[] arr = {1,2,3,4,45,5};
		System.out.println(arr.toString()); //[I@95cfbe
		
		String[] strs = {"c","b","a"};
		System.out.println(strs); //[Ljava.lang.String;@19bb25a
		
		Date[] dates = {new Date(),new Date(),new Date()};
		System.out.println(dates); //[Ljava.util.Date;@1e58cb8
	}

}
