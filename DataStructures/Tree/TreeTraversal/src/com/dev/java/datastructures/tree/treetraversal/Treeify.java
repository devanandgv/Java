package com.dev.java.datastructures.tree.treetraversal;

public class Treeify {

	public static void treeify(int[] array,int i,Node<Integer> node){
		
		node.setValue(array[i]);
		if(2*i+1 < array.length){
			
			Node<Integer> left = new Node<>();
			node.setLeftChild(left);
			treeify(array, 2*i+1, left);
		}
		if(2*i+2 < array.length){
			
			Node<Integer> right = new Node<>();
			node.setRightChild(right);
			treeify(array, 2*i+2, right);
		}	
				
	}	
}
