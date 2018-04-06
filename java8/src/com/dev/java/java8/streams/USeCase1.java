package com.dev.java.java8.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.dev.java.java8.bo.Financier;
import com.dev.java.java8.bo.Dealing;

public class USeCase1 {

	/* 
	 * 	1. Find all dealings in the year 2011 and sort them by value (small to high).
	   	2. What are all the unique cities where the financiers work?
		3. Find all financiers from Cambridge and sort them by name.
		4. Return a string of all financiers’ names sorted alphabetically.
		5. Are any financiers based in Milan?
		6. Print all dealings’ values from the financiers living in Cambridge.
		7. What’s the highest value of all the dealings?
		8. Find the dealing with the smallest value.
	 * 
	 * */
	public static void main(String args[]){
		
		Financier raoul = new Financier("Raoul", "Cambridge");
		
		Financier mario = new Financier("Mario","Milan");
		Financier alan = new Financier("Alan","Cambridge");
		Financier brian = new Financier("Brian","Boston");
		List<Dealing> dealings = Arrays.asList(
		new Dealing(brian, 2011, 300),
		new Dealing(raoul, 2012, 1000),
		new Dealing(raoul, 2011, 400),
		new Dealing(mario, 2012, 710),
		new Dealing(mario, 2012, 700),
		new Dealing(alan, 2012, 950)
		);
		
		
		//1. Find all dealings in the year 2011 and sort them by value (small to high).
		
		
		List<Dealing> dealing2011 = dealings.stream().filter(t->t.getYear()==2011)
										.sorted(Comparator.comparing(Dealing::getValue))
										.collect(Collectors.toList());
				System.out.println("Answer 1 : "+dealing2011);
				
		//	2. What are all the unique cities where the financiers work?
		List<String> uniqueCities = dealings.stream().map(t->t.getTrader().getCity())
				.distinct().collect(Collectors.toList());
		System.out.println("Answer 2 : "+uniqueCities);
		
		
		//3. Find all financiers from Cambridge and sort them by name.
		
		List<String> cambridgeFinanciers = dealings.stream().filter(t->t.getTrader().getCity().equals("Cambridge"))
										.map(t->t.getTrader().getName()).sorted().distinct().collect(Collectors.toList());
		System.out.println("3. Cambridge Traders :"+cambridgeFinanciers);
		
		//4. Return a string of all financiers’ names sorted alphabetically.
		
		List<String> financiersName = dealings.stream().map(t->t.getTrader().getName()).distinct().sorted()
									.collect(Collectors.toList());
		System.out.println("4. Traders Names : "+financiersName);
		
		//5. Are any financiers based in Milan?
		
		Boolean isFinancierMilan = dealings.stream().anyMatch(t->t.getTrader().getCity().equals("Milan"));
		System.out.println("isTraderMilan : "+isFinancierMilan);
		
		//6. Print all dealings’ values from the financiers living in Cambridge.
		IntStream valuesOfCambridge = dealings.stream().filter(t->t.getTrader().getCity().equals("Cambridge"))	
										.mapToInt(Dealing::getValue);
		System.out.println("6. Cambridge Traders Values : ");
		valuesOfCambridge.forEach(t->System.out.print(t+"\t"));
		
		//7. What’s the highest value of all the dealings?
		int highestValue = dealings.stream().max(Comparator.comparingInt(Dealing::getValue)).get().getValue();
		System.out.println("7. highest transaction value : "+highestValue);
		
		//8. Find the dealing with the smallest value.
		
		int smallestValue = dealings.stream().min(Comparator.comparingInt(Dealing::getValue)).get().getValue();
		System.out.println("8. smallest transaction value : "+smallestValue);
	}
}
