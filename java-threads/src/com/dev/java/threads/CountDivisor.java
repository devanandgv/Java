package com.dev.java.threads;

/*Now write a program that uses multiple threads to solve the same problem, but for the range 1 to 100000
 *  (or less, if you don't have a fast computer). 
 * By using threads, your program will take less time to do the computation when it is run on a multiprocessor computer.
 *  At the end of the program, output the elapsed time, 
 * the integer that has the largest number of divisors, and the number of divisors that it has*/
public class CountDivisor extends Thread {

	private int min;

	private int max;

	private static int maxNo;

	private int noOfDivisor;
	
	private int maxDivisor;

	public CountDivisor(int min, int max) {
		super();
		this.min = min;
		this.max = max;
	}

	public static int getMaxNo() {
		return maxNo;
	}

	private synchronized void setMaxNo(int maxDiv) {
		if (maxNo < maxDiv) {
			maxNo = maxDiv;
		}
	}

	public int getMaxDivisor() {
		return maxDivisor;
	}

	public void setMaxDivisor(int maxDivisor) {
		this.maxDivisor = maxDivisor;
	}

	public int getNoOfDivisor() {
		return noOfDivisor;
	}

	public void setNoOfDivisor(int noOfDivisor) {
		this.noOfDivisor = noOfDivisor;
	}

	private void countDivisor() {

		int result = 0;
		int no = min;
		for (int i = min; i < max; i++) {
			int count = 1;
			for (int j = 2; j <= i; j++) {
				if (i % j == 0) {
					count++;
				}
			}
			if (count > result) {
				result = count;
				no = i;
			}

		}
		this.setMaxNo(no);
		this.setMaxDivisor(no);
		this.setNoOfDivisor(result);
	}

	@Override
	public void run() {

		countDivisor();
	}

	public static void main(String[] args) throws InterruptedException {

		CountDivisor countDivisor1 = new CountDivisor(1, 25000);
		CountDivisor countDivisor2 = new CountDivisor(25000, 50000);
		CountDivisor countDivisor3 = new CountDivisor(50000, 75000);
		CountDivisor countDivisor4 = new CountDivisor(75000, 100000);
		countDivisor1.start();
		countDivisor2.start();
		countDivisor3.start();
		countDivisor4.start();
		countDivisor4.join();
		countDivisor2.join();
		countDivisor1.join();
		countDivisor3.join();
		System.out.println(countDivisor1.getNoOfDivisor() + " " + countDivisor1.getMaxDivisor());
		System.out.println(countDivisor2.getNoOfDivisor() + " " + countDivisor2.getMaxDivisor());
		System.out.println(countDivisor3.getNoOfDivisor() + " " + countDivisor3.getMaxDivisor());
		System.out.println(countDivisor4.getNoOfDivisor() + " " + countDivisor4.getMaxDivisor());
		System.out.println(CountDivisor.getMaxNo());
	}

}
