package com.sample.interview.programs;

public class Singleton {
	
	private static Singleton singleton = null;
	private int counter = 0;
	private Singleton(){}
	
	public static Singleton getInstance(){
		if(singleton == null)
			singleton = new Singleton();
		return singleton;
	}
	
	public void counter(){
		System.out.println(++counter);
	}
}
