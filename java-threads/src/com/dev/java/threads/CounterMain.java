package com.dev.java.threads;

public class CounterMain {

	public static void main(String[] args) throws InterruptedException {

		
		CountDivisor countDivisor1 = new CountDivisor(1,25000);
		CountDivisor countDivisor2 = new CountDivisor(25000,50000);
		CountDivisor countDivisor3 = new CountDivisor(50000,75000);
		CountDivisor countDivisor4 = new CountDivisor(75000,100000);
		countDivisor1.start();
		countDivisor2.start();
		countDivisor3.start();
		countDivisor4.start();
		countDivisor4.join();
		countDivisor2.join();
		countDivisor1.join();
		countDivisor3.join();
		System.out.println(countDivisor1.getNoOfDivisor() +" " +countDivisor1.getMaxDivisor());
		System.out.println(countDivisor2.getNoOfDivisor()+" " +countDivisor2.getMaxDivisor());
		System.out.println(countDivisor3.getNoOfDivisor()+" " +countDivisor3.getMaxDivisor());
		System.out.println(countDivisor4.getNoOfDivisor()+" " +countDivisor4.getMaxDivisor());
		System.out.println(CountDivisor.getMaxNo());
	}
}
