package com.vihar.dataStructures.stack;

import java.util.*;;

public class StackWithDoublyLinkedList<T> implements Iterable {

	private LinkedList<T> listStack = new LinkedList<T>();

	public int size() {
		return listStack.size();
	}

	public boolean isEmpty() {
		return size() == 0;

	}

	public void push(T elem) {
		listStack.addLast(elem);// As it is doublyLinkedList head could remain at first element added
	}

	public T pop() {
		if (isEmpty())
			throw new EmptyStackException();
		return listStack.removeLast(); // As it is doublyLinkedList we could find the last element in LinkedList in
										// O(1) time
	}

	public T peek() {
		if (isEmpty())
			throw new EmptyStackException();
		return listStack.peekLast(); // we can not use getLast as it will give stack is empty if the value is null
	}
	@Override
	public Iterator iterator() {
		int i = 0;
		while (i < listStack.size()) {
		    System.out.println(listStack.get(i));
		    i++;}
		// TODO Auto-generated method stub
		return listStack.listIterator();
		
	}
	
	public static void main(String args[])
	{
		StackWithDoublyLinkedList stack = new StackWithDoublyLinkedList();
		System.out.println(stack.size());
		System.out.println(stack.isEmpty());
		stack.iterator();
		System.out.println();
		stack.push(2);
		stack.push(4);
		stack.push(6);
		stack.iterator();
		System.out.println();
		stack.pop();
		stack.iterator();
		
		
	}

	

	
}
