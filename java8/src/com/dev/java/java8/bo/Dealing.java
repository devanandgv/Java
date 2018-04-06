package com.dev.java.java8.bo;

public class Dealing{

	private final Financier trader;
	private final int year;
	private final int value;

	public Dealing(Financier trader, int year, int value) {
		this.trader = trader;
		this.year = year;
		this.value = value;
	}

	public Financier getTrader() {
		return trader;
	}

	public int getYear() {
		return year;
	}

	public int getValue() {
		return value;
	}

	@Override
	public String toString() {
		return "Transaction [trader=" + trader + ", year=" + year + ", value=" + value + "]";
	}

}
