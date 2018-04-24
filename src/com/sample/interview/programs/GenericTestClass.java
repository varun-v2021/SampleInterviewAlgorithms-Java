package com.sample.interview.programs;

public class GenericTestClass<T> {
	T obj;

	GenericTestClass(T obj) {
		this.obj = obj;
	}

	public T getObject() {
		return this.obj;
	}

}
