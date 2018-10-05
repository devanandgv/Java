package com.dev.java.threads.exercise1;

import java.util.concurrent.ConcurrentLinkedDeque;

/*
 * Implement a thread pool strategy for solving the same maximum-number-of-divisors problem
 * new technique for combining the results from all the tasks: Use two queues in your program. 
 * Use a queue of tasks, as usual, to hold the tasks that will be executed by the thread pool.
 * But also use a queue of results produced by the threads.
 * When a task completes, the result from that task should be placed into the result queue. 
 * The main program can read results from the second queue as they become available,
 * and combine all the results to get the final answer.
 * The result queue will have to be a blocking queue,
 * since the main program will have to wait for results to become available. 
 * Note that the main program knows the exact number of results that it expects to read from the queue, 
 * so it can do so in a for loop; when the for loop completes, 
 * the main program knows that all the tasks have been executed.
 * */
public class CountThreadPool extends Thread {

	static ConcurrentLinkedDeque<Thread> taskQueue = new ConcurrentLinkedDeque<>();
	static ConcurrentLinkedDeque<Thread> resultQueue = new ConcurrentLinkedDeque<>();
	
	private int min;

	private int max;


	private int noOfDivisor;

	private int maxDivisor;

	public CountThreadPool(int min, int max) {
		super();
		this.min = min;
		this.max = max;
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
		resultQueue.add(new ResultThreadPool(no));
		this.setMaxDivisor(no);
		this.setNoOfDivisor(result);
	}

	@Override
	public void run() {

		countDivisor();
	}

	public static void main(String[] args) throws InterruptedException {

		ConcurrentLinkedDeque<Thread> taskQueue = new ConcurrentLinkedDeque<>();
		int noOfSubTask = 10;
		int min = 1;
		int max = 100000;
		int subTaskLimit = max / noOfSubTask;
		CountThreadPool[] threadPoolTask = new CountThreadPool[noOfSubTask];
		for (int j = min, i = 0; j <= (max - noOfSubTask) && i <= noOfSubTask; j = j + subTaskLimit, i++) {

			System.out.println("j:" + j + "j+subTask:" + (j + subTaskLimit - min) + "i : " + i);
			threadPoolTask[i] = new CountThreadPool(j, j + subTaskLimit - min);
			taskQueue.add(threadPoolTask[i]);

		}
		while (true) {

			CountThreadPool task = (CountThreadPool) taskQueue.poll();
			if (task == null) {
				break;
			}
			task.start();
			task.join();
			System.out.println(task.getNoOfDivisor());
		}
		while (true) {

			ResultThreadPool task = (ResultThreadPool) resultQueue.poll();
			if (task == null) {
				break;
			}
			task.start();
			task.join();
			
		}
		System.out.println("result : "+ResultThreadPool.result);
		
	}

	private static class ResultThreadPool extends Thread {

		private static volatile int result;

		private int no;

		public ResultThreadPool(int no) {
			this.no = no;
		}

		@Override
		public void run() {

			if(this.no > result) {
				
				setResult();
			}
		}

		private synchronized void setResult() {
		
			result = this.no;
		}
	}

}
