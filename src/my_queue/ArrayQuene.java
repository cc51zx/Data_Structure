package my_queue;

import my_arrays.Arrays;

public class ArrayQuene<E> implements Quene<E> {
	Arrays<E> array;
	
	public ArrayQuene(int capacity) {
		array=new Arrays<>(capacity);
	}
	
	public ArrayQuene() {
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
	public void enquene(E e) {
		array.addLast(e);
	}
	
	@Override
	public E dequene() {
		return array.removeFirst();
	}
	
	@Override
	public E getFront() {
		return array.getFirst();
	}

	@Override
	public String toString() {
		StringBuffer sb=new StringBuffer();
		sb.append("Quene:"+"size:"+array.getSize()+" capacity:"+array.getCapacity()+"\r\n[");
		for(int i=0;i<array.getSize();i++) {
			if(i!=array.getSize()-1)
				sb.append(array.getIndex(i)+",");
			else
				sb.append(array.getIndex(i)+"]\r\n");
		}
		
		return sb.toString();
	}
	
	

}
