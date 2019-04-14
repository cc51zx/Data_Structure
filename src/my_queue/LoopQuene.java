package my_queue;

public class LoopQuene<E> implements Quene<E> {
	private E[] data;
	private int front,tail;
	private int size;
	
	public LoopQuene(int capacity) {
		data=(E[])new Object[capacity+1];
		front=0;
		tail=0;
		size=0;
	}
	public LoopQuene() {
		this(10);
	}
	
	public int getCapacity() {
		return data.length-1;
	}
	@Override
	public int getSize() {
		return size;
	}
	@Override
	public boolean isEmpty() {
		return front==tail;
	}
	
	@Override
	public void enquene(E e) {
		if((tail+1)%data.length==front)
			resize(2*getCapacity());
		data[tail]=e;
		tail=(tail+1)%data.length;
		size++;
	}
	
	@Override
	public E dequene() {
		if(isEmpty())
			throw new IllegalArgumentException("Quene is empty");
		E ret=data[front];
		data[front]=null;
		front=(front+1)%data.length;
		size--;
		if(size==getCapacity()/4 && getCapacity()/2!=0)
			resize(getCapacity()/2);
		return ret;
	}
	
	@Override
	public E getFront() {
		if(isEmpty())
			throw new IllegalArgumentException("Quene is empty");
		return data[front];
	}
	public void resize(int newCapacity) {
		E[] newData=(E[])new Object[newCapacity+1];
		for(int i=0;i<size;i++)
			newData[i]=data[(i+front)%data.length];
		data=newData;
		front=0;
		tail=size;
	}
	@Override
	public String toString() {
		StringBuffer sb=new StringBuffer();
		sb.append(String.format("LoopQuene:size=%d,capacity=%d\n",size,getCapacity()));
		sb.append("front[");
		for(int i=front;i!=tail;i=(i+1)%data.length) {
			if((i+1)%data.length!=tail)
				sb.append(data[i]+",");
			else
				sb.append(data[i]);
		}
		sb.append("]tail\n");
		return sb.toString();
	}

}
