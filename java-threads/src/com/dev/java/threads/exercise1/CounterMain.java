package com.dev.java.threads.exercise1;

//http://math.hws.edu/javanotes/c12/exercises.html
	
public class CounterMain {

	public static void main(String[] args) throws InterruptedException {

		int y =83160;
		int count=0;
		
		for (int i = 2; i < y; i++) {
		    if (y % i == 0) {
		      count++;
		    }
		}
		System.out.println(count);
	}
}
