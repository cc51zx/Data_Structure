package MaxHeap;

public class MaxHeap<E extends Comparable<E>> {
	private Arrays<E> data;
	
	public MaxHeap(int capacity) {
		data=new Arrays<>(capacity);
	}
	public MaxHeap() {
		data=new Arrays<>();
	}
//��������������ɶѵ���״
//�ӵ�һ����Ҷ�ӽ�㿪ʼ��������ÿ����Ҷ�ӽڵ����siftDown�³�������ʱ�临�Ӷ�ΪO(n)
	public MaxHeap(E[] arr) {
		data=new Arrays<>(arr);
		for(int i=data.getSize()-1;i>=0;i--)
			siftDown(i);
	}
//	���ض���Ԫ�ظ���
	public int size() {
		return data.getSize();
	}

//	����һ������ֵȷ�����Ƿ�Ϊ��
	public boolean isEmpty() {
		return data.isEmpty();
	}
	
//	������ȫ�������������ʾ�У�һ����������ʾ��Ԫ�صĸ��׽ڵ������
	private int parent(int index) {
		if(index==0)
			throw new IllegalArgumentException("index-0 hasn't parent");
		return (index-1)/2;
	}
//	������ȫ�������������ʾ�У�һ����������ʾ��Ԫ�ص����ӽڵ������
	private int leftChild(int index) {
		return index*2+1;
	}
//	������ȫ�������������ʾ�У�һ����������ʾ��Ԫ�ص��Һ��ӽڵ������
	private int rightChild(int index) {
		return index*2+2;
	}
	
//��������Ԫ��
	public void add(E e) {
		data.addLast(e);
		siftUp(data.getSize()-1);
	}
//	siftUp ����ӵ�Ԫ���ϸ������������ѵ�Ҫ��
	private void siftUp(int k) {
		while(k>0 && data.getIndex(k).compareTo(data.getIndex(parent(k)))>0) {
			data.swap(k,parent(k));
			k=parent(k);
		}
		
	}
//	���Ҷ������Ԫ��
	public E findMax() {
		if(data.getSize()==0)
			throw new IllegalArgumentException("Can not find Max when heap is empty");
		return data.getIndex(0);
	}
//	ȡ�����е����Ԫ��
	public E extractMax() {
		E ret=findMax();
		data.swap(0, data.getSize()-1);
		data.removeLast();
		siftDown(0);
		return ret;
		
	}
	private void siftDown(int k) {
		while(leftChild(k)<data.getSize()) {
			int j=leftChild(k);
			if(j+1<data.getSize() && data.getIndex(j+1).compareTo(data.getIndex(j))>0)
				j=j+1;
//			jΪk�����Һ����������Ǹ�
			if(data.getIndex(j).compareTo(data.getIndex(k))<0)
				break;
			data.swap(k, j);
			k=j;
			
		}
		
	}
	
//	ȡ���������Ԫ�غ��滻��e
	public E replace(E e) {
		E ret=findMax();
		data.set(0, e);
		siftDown(0);
		return ret;
	}
	
	
}
