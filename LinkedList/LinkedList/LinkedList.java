package LinkedList;

public class LinkedList<E> {
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
	
	private Node dummyHead;
	private int size;
	
	public LinkedList() {
		dummyHead=new Node(null,null);
		size=0;
	}
	
	public int getSize() {
		return size;
	}
	public boolean isEmpty() {
		return size==0;
	}
	
	//索引只是为了方便练习，实际应用中一般没有索引
	public void add(int index,E e) {
		if(index<0 || index>size)
			throw new IllegalArgumentException("Illegal index");
			Node pre=dummyHead;
			for(int i=0;i<index;i++)
				pre=pre.next;
			/*Node node=new Node(e);
			node.next=pre.next;
			pre.next=node;*/  //三个语句可用下面一句替代
			
			pre.next=new Node(e,pre.next);
			size++;
	}
	public void addFirst(E e) {
		/*Node node=new Node(e);
		node.next=head;
		head=node;*/
//		head=new Node(e,head);
//		size++;
		add(0,e);
	}
	public void addLast(E e) {
		add(size,e);
	}
	
	public E get(int index) {
		if(index<0 || index>=size)
			throw new IllegalArgumentException("Illegal index");
		Node cur=dummyHead.next;
		for(int i=0;i<index;i++)
			cur=cur.next;
		return cur.e;
	}
	public E getFirst() {
		return get(0);
	}
	public E getLast() {
		return get(size-1);
	}
	
	public void set(int index,E e) {
		if(index<0 || index>=size)
			throw new IllegalArgumentException("Illegal index");
		Node cur=dummyHead.next;
		for(int i=0;i<index;i++)
			cur=cur.next;
		cur.e=e;
	}
	public boolean contains(E e) {
		Node cur=dummyHead.next;
		while(cur!=null) {
			if(cur.e.equals(e))
				return true;
			cur=cur.next;
		}
		return false;
	}
	
	public E remove(int index) {
		if(index<0 || index>=size)
			throw new IllegalArgumentException("Index is illegal");
		Node pre=dummyHead;
		for(int i=0;i<index;i++)
			pre=pre.next;
		Node delNode=pre.next;
		pre.next=delNode.next;
		delNode.next=null;
		size--;
		return delNode.e;
	}
	public void removeElement(E e) {
		Node pre=dummyHead;
		Node cur=dummyHead.next;
		while(cur!=null) {
			if(cur.e.equals(e)) {
				pre.next=cur.next;
				cur.next=null;
			}
			pre=pre.next;
			cur=cur.next;
		}
		
	}
	public E removeFirst() {
		return remove(0);
	}
	public E removeLast() {
		return remove(size-1);
	}
	
	@Override
	public String toString() {
		StringBuffer res=new StringBuffer();
		for(Node cur=dummyHead.next;cur!=null;cur=cur.next)
			res.append(cur.e+"->");
		res.append("null\n");
		return res.toString();
	}


}
