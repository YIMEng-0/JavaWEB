package com.bjpowernode.tm2;

/**
 * 模板类
 * @author Administrator
 *
 */
public abstract class Person {
	
	/**
	 * 模板方法
	 */
	public final void templateMethod(){
		//定义核心算法骨架，将程序的执行流程固定。
		//把算法写了,先...再..然后...最后...
		do1();
		do2();
		do3();
		do4();
	}

	/**
	 * 但是具体的实现步骤，这一步里的具体程序延迟到子类中完成。
	 */
	public abstract void do4() ;

	public abstract void do3() ;

	public abstract void do2() ;

	public abstract void do1() ;
	
}
