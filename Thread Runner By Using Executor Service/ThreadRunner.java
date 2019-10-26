package com.sujeettech;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadRunner {

	public static void main(String[] args) {
		ExecutorService executor = Executors.newFixedThreadPool(50);
		String[] fileNames = { "http://crunchify.com", "http://yahoo.com", "http://www.ebay.com", "http://google.com",
				"http://www.example.co", "https://paypal.com", "http://bing.com/", "http://techcrunch.com/", "http://mashable.com/",
				"http://thenextweb.com/", "http://wordpress.com/", "http://wordpress.org/", "http://example.com/", "http://sjsu.edu/",
				"http://ebay.co.uk/", "http://google123.co.uk/", "http://wikipedia.org/", "http://en.wikipedia.org" };
 
		for (int i = 0; i < fileNames.length; i++) {
 
			String fileName = fileNames[i];
			Runnable worker = new MyRunnable(fileName);
			executor.execute(worker);
		}
		executor.shutdown();
		// Wait until all threads are finish
		while (!executor.isTerminated()) {
 
		}
		System.out.println("\nFinished all threads");
	}

}
