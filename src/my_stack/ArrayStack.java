package my_stack;

import my_arrays.Arrays;

public class ArrayStack<E> implements Stack<E> {
	Arrays<E> array;
	public ArrayStack(int capacity){
		array=new Arrays<>(capacity);
	}
	public ArrayStack() {
		array=new Arrays<>();
	}
	
	@Override
	public int getSize() {
		return array.getSize();
	}
	
	@Override
	public boolean isEmpty() {
		return array.getSize()==0;
	}
	
	@Override
	public void push(E e) {
		array.addLast(e);
	}
	
	@Override
	public E pop() {
		return array.removeLast();
	}
	
	@Override
	public E peek() {
		return array.getLast();
	}
	
	@Override
	public String toString() {
		StringBuffer sb=new StringBuffer();
		sb.append("Stack:[");
		for(int i=0;i<array.getSize();i++) {
			if(i!=0)
				sb.append(","+array.getIndex(i));
			else
				sb.append(""+array.getIndex(i));
		}
		sb.append("]"+"\r\n");
		return sb.toString();
	}
	
//²âÊÔ²¿·Ö
/*	public static void main(String[] args) {
		ArrayStack<String> s=new ArrayStack<>();
		s.push("ab");
		s.push("cd");
		s.push("ef");
		System.out.println(s);
		System.out.println(s.peek());
		String s1=s.pop();
		System.out.println(s);
	}*/

}
