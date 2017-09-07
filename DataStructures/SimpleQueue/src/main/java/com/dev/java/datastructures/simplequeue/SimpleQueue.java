package com.dev.java.datastructures.simplequeue;

public class SimpleQueue<E> {

	private Node<E> head;
	private Node<E> tail;
	private int size;

	public void offer(E value) {

		if (isNull(value))

			throw new NullPointerException("Value is NULL");

		else if (isNull(this.head)) {

			Node<E> tempHead = new Node<>();
			tempHead.setNodeValue(value);
			tempHead.setNodeNext(null);
			this.head = tempHead;
			this.tail = tempHead;
			size = 1;

		} else {

			Node<E> tempTail = new Node<>();
			tempTail.setNodeValue(value);
			tempTail.setNodeNext(null);
			this.tail.setNodeNext(tempTail);
			this.tail = tempTail;
			size++;

		}

	}

	public E poll() throws Exception {

		if (size == 0)

			return null;

		else {

			Node<E> tempHead = this.head;
			this.head = this.head.getNodeNext();
			tempHead.setNodeNext(null);
			size--;
			return tempHead.getNodeValue();

		}
	}

	public void show() throws Exception {

		if (size == 0)

			throw new NullPointerException("Queue is Empty");

		else {

			Node<E> tempHead = this.head;

			do {
				System.out.println(tempHead.getNodeValue());
				tempHead = tempHead.getNodeNext();

			} while (tempHead != null);
		}
	}

	public E peek() {

		if (size == 0)

			return null;

		else

			return this.head.getNodeValue();
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	private boolean isNull(Object obj) {

		if (obj == null)
			return true;
		else
			return false;
	}
}
