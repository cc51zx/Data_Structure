package my_queue;

public class LinkedListQuene<E> implements Quene<E>{
	private class Node{
		public E e;
		public Node next;
		
		public Node(E e,Node next) {
			this.e=e;
			this.next=next;
		}
		public Node(E e) {
			this(e,null);
		}
		public Node() {
			this(null,null);
		}
		
	}
	
	private Node head,tail;
	private int size;
	
	public LinkedListQuene() {
		head=null;
		tail=null;
		size=0;
	}
	@Override
	public int getSize() {
		return size;
	}
	@Override
	public boolean isEmpty() {
		return size==0;
	}
	@Override
	public void enquene(E e) {
		if(tail==null) {
			tail=new Node(e);
			head=tail;
		}else {
			tail.next=new Node(e);
			tail=tail.next;
		}
		size++;
	}
	@Override
	public E dequene() {
		if(isEmpty())
			throw new IllegalArgumentException("Quene is Empty");
		Node retNode=head;
		head=head.next;
		retNode.next=null;
		if(head==null)
			tail=null;
		size--;
		return retNode.e;
	}
	@Override
	public E getFront() {
		if(isEmpty())
			throw new IllegalArgumentException("Quene is Empty");
		return head.e;
	}
	
	@Override
	public String toString() {
		StringBuilder res=new StringBuilder();
		res.append("Quene:front ");
		Node cur=head;
		while(cur!=null) {
			res.append(cur.e+"->");
			cur=cur.next;
		}
		res.append("null tail");
		return res.toString();
	
	}

}
