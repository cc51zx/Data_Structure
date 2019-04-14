package my_stack;

public class LinkedListStack<E> implements Stack<E> {
	private LinkedList<E> list;
	public LinkedListStack() {
		list=new LinkedList<>();
	}
	@Override
	public int getSize() {
		return list.getSize();
	}
	@Override
	public boolean isEmpty() {
		return list.isEmpty();
	}
	@Override
	public void push(E e) {
		list.addFirst(e);
	}
	@Override
	public E pop() {
		return list.removeFirst();
	}
	@Override
	public E peek() {
		return list.getFirst();
	}
	@Override
	public String toString() {
		StringBuilder res=new StringBuilder();
		res.append("Stack:top ");
		res.append(list);
		return res.toString();
	}
	//≤‚ ‘≤ø∑÷
/*		public static void main(String[] args) {
			LinkedListStack<Integer> s=new LinkedListStack<>();
			for(int i=0;i<10;i++) {
				s.push(i);
				System.out.println(s);
				if(i%3==2) {
					s.pop();
					System.out.println(s);
				}
					
			}

		}*/

}
