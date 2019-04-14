package Set;

import LinkedList.LinkedList;

public class LinkedListSet<E> implements Set<E> {
	private LinkedList<E> list; 
	public LinkedListSet() {
		list=new LinkedList<>();
	}

	@Override
	public void add(E e) {
		
	}

	@Override
	public void remove(E e) {
		list.removeElement(e);
	}

	@Override
	public boolean contains(E e) {
		if(list.contains(e))
			return true;
		else
			return false;
		
	}

	@Override
	public int getSize() {
		
		return list.getSize();
	}

	@Override
	public boolean isEmpty() {
		
		return list.isEmpty();
	}

}
