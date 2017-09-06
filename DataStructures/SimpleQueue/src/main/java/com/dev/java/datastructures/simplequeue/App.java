package com.dev.java.datastructures.simplequeue;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) throws Exception {
		System.out.println("Hello World!");

		SimpleQueue<String> sim = new SimpleQueue<>();
		System.out.println(sim.getSize());
		sim.offer("dev");
		System.out.println(sim.poll());
		System.out.println(sim.poll());
		//sim.show();
	}
}
