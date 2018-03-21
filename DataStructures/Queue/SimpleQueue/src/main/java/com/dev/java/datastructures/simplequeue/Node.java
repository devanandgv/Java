package com.dev.java.datastructures.simplequeue;

public class Node<E> {

	private E nodeValue;
	private Node<E> nodeNext;
	
	public E getNodeValue() {
		return nodeValue;
	}
	public void setNodeValue(E nodeValue) {
		this.nodeValue = nodeValue;
	}
	public Node<E> getNodeNext() {
		return nodeNext;
	}
	public void setNodeNext(Node<E> nodeNext) {
		this.nodeNext = nodeNext;
	}

	
}
