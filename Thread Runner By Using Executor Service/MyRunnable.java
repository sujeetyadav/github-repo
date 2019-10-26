package com.sujeettech;

public class MyRunnable implements Runnable{

	String fileName;
	public MyRunnable(String fileName) {
		this.fileName = fileName;
	}

	@Override
	public void run() {
		System.out.println("processing file " + fileName + " by thread " + Thread.currentThread().getId());
	}

}
