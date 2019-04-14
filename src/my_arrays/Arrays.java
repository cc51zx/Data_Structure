package my_arrays;

public class Arrays<E> {
	private E[]data;
	private int size;
	
	public Arrays(int x) {
		data=(E[])new Object[x];
		size=0;
	}
	public Arrays() {
		this(10);
	}
	
	//�����а���Ԫ�صĸ���
	
	//�������������
	public int getCapacity() {
		return data.length;
	}
	
	public int getSize() {
		return size;
	}
	//��ѯ�����Ƿ�Ϊ��
	public boolean isEmpty() {
		return size==0;
	}
	//�������Ƿ����ĳһԪ��
	public boolean contains(E e) {
		for(int i=0;i<size;i++) {
			if(data[i].equals(e))
				return true;
		}
		return false;
	}
	
	//����ĳһԪ�ص�����
	public int find(E e) {
		for(int i=0;i<size;i++)
			if(data[i].equals(e))
				return i;
		return -1;
		
	}
	
	//ɾ��ĳһԪ��
	public E remove(int index) {
		if(index<0 || index>=size)
			throw new IllegalArgumentException("Index is illegal");
		E ret=data[index];
		for(int i=index+1;i<size;i++) {
			data[i-1]=data[i];
		}
		size--;
		if(size==data.length/4 && data.length/2!=0) //Ϊ�˷�ֹ���Ӷȵ���
			resize(data.length/2);
		return ret;
			
		}
		
	public E removeFirst() {
		return remove(0);
	}
	
	public E removeLast() {
		return remove(size-1);
	}
	
	//ɾ��Ԫ��e
	
	public void removeElement(E e) {
		int index=find(e);
		if(index!=-1)
		    remove(index);
		else
			throw new IllegalArgumentException("not exist element!");
	}
	
	public void addLast(E e) {
		/*if(size==data.length)
			throw new IllegalArgumentException("array is full");
		data[size]=x;
		size++;*/
		
		add(size,e);
	}
	
	
	//������ĳһλ�����Ԫ��
	public void add(int index,E e) {
		if(index<0 || index>size)
			throw new IllegalArgumentException("index is out of range");
		if(size==data.length) {
			resize(2*data.length);	
		}
		
		for(int i=size;i>index;i--) {
			data[i]=data[i-1];
		
		}
		data[index]=e;
		
		size++;
	}
	
	//����ĳһ������ֵ
	public E getIndex(int index) {
		if(index<0 || index>=size)
			throw new IllegalArgumentException("Index is illegal");
		return data[index];
		
	}
	public E getLast() {
		return getIndex(size-1);
	}
	
	public E getFirst() {
		return getIndex(0);
	}
	//�޸�����ĳһ������ֵ
	public void set(int index,E e) {
		if(index<0 || index>=size)
		    throw new IllegalArgumentException("Index is illegal");
		data[index]=e;
	}
	//��ѯ��������
	@Override
	public String toString() {
		StringBuffer sb=new StringBuffer();
		sb.append("Arrays:\r\n");
		sb.append("capacity="+data.length);
		sb.append(" size="+size+" [");
		for(int i=0;i<size;i++) {
			if(i!=size-1)
				sb.append(data[i]+",");
			else
				sb.append(data[i]+"]");
		}
		return sb.toString();
	}
	
	private void resize(int newCapacity) {
		E[] newData=(E[])new Object[newCapacity];
		for(int i=0;i<size;i++)
			newData[i]=data[i];
		data=newData;
		
	}
	


}
