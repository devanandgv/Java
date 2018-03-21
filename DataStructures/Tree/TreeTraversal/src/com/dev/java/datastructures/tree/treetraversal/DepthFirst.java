package com.dev.java.datastructures.tree.treetraversal;

public class DepthFirst {

	public static void main(String[] args) {

		int[] array = { 9, 10, 14, 2, 3, 7, 54, 12, 6 };

		Node<Integer> root = new Node<>();

		Treeify.treeify(array, 0, root);

		System.out.println("InOrder Traversal");
		inOrderTraversal(root);
		System.out.println("PreOrder Traversal");
		preOrderTraversal(root);
		System.out.println("PostOrder Traversal");
		postOrderTraversal(root);

	}

	public static void inOrderTraversal(Node<Integer> root) {

		if (root.getLeftChild() != null)
			inOrderTraversal(root.getLeftChild());

		System.out.println(root.getValue());

		if (root.getRightChild() != null)
			inOrderTraversal(root.getRightChild());
	}

	public static void preOrderTraversal(Node<Integer> root) {

		System.out.println(root.getValue());
		
		if (root.getLeftChild() != null)
			preOrderTraversal(root.getLeftChild());


		if (root.getRightChild() != null)
			preOrderTraversal(root.getRightChild());
	}
	
	public static void postOrderTraversal(Node<Integer> root) {

		
		if (root.getLeftChild() != null)
			postOrderTraversal(root.getLeftChild());


		if (root.getRightChild() != null)
			postOrderTraversal(root.getRightChild());
		
		System.out.println(root.getValue());
	}

}
