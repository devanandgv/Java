package com.dev.java.threads.exercise1;


/*1.Write a program to find out. Use the following unsynchronized counter class,
 *  which you can include as a nested class in your program:

static class Counter {
   int count;
   void inc() {
       count = count+1;
   }
   int getCount() {
       return count;
   }
}
Write a thread class that will call the inc() method in this class a specified number of times. 
Create several threads, start them all, and wait for all the threads to terminate. 
Print the final value of the counter, and see whether it is correct.*/
public class CounterThread extends Thread {

	int count;

	void inc() throws InterruptedException {
		count = count + 1;
		// System.out.println("in : "+this.getId()+" count : "+count);
		Thread.sleep(100);
	}

	int getCount() {
		return count;
	}

	@Override
	public void run() {
		// System.out.println("thread id : "+this.getId());
		try {
			inc();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws InterruptedException {

		CounterThread counter = new CounterThread();

		Thread[] threadCount = new Thread[100];

		for (int i = 0; i < threadCount.length; i++) {

			threadCount[i] = new Thread(counter);
			System.out.println("i : " + i);
			threadCount[i].start();
		}
		Thread.sleep(1000);
		System.out.println(counter.count);

	}
}
