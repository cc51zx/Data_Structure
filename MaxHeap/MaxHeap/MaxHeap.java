package MaxHeap;

public class MaxHeap<E extends Comparable<E>> {
	private Arrays<E> data;
	
	public MaxHeap(int capacity) {
		data=new Arrays<>(capacity);
	}
	public MaxHeap() {
		data=new Arrays<>();
	}
//将任意数组整理成堆的形状
//从第一个非叶子结点开始便利，将每个非叶子节点进行siftDown下沉操作，时间复杂度为O(n)
	public MaxHeap(E[] arr) {
		data=new Arrays<>(arr);
		for(int i=data.getSize()-1;i>=0;i--)
			siftDown(i);
	}
//	返回堆中元素个数
	public int size() {
		return data.getSize();
	}

//	返回一个布尔值确定堆是否为空
	public boolean isEmpty() {
		return data.isEmpty();
	}
	
//	返回完全二叉树的数组表示中，一个索引所表示的元素的父亲节点的索引
	private int parent(int index) {
		if(index==0)
			throw new IllegalArgumentException("index-0 hasn't parent");
		return (index-1)/2;
	}
//	返回完全二叉树的数组表示中，一个索引所表示的元素的左孩子节点的索引
	private int leftChild(int index) {
		return index*2+1;
	}
//	返回完全二叉树的数组表示中，一个索引所表示的元素的右孩子节点的索引
	private int rightChild(int index) {
		return index*2+2;
	}
	
//向堆中添加元素
	public void add(E e) {
		data.addLast(e);
		siftUp(data.getSize()-1);
	}
//	siftUp 新添加的元素上浮，以满足最大堆的要求
	private void siftUp(int k) {
		while(k>0 && data.getIndex(k).compareTo(data.getIndex(parent(k)))>0) {
			data.swap(k,parent(k));
			k=parent(k);
		}
		
	}
//	查找堆中最大元素
	public E findMax() {
		if(data.getSize()==0)
			throw new IllegalArgumentException("Can not find Max when heap is empty");
		return data.getIndex(0);
	}
//	取出堆中的最大元素
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
//			j为k的左右孩子中最大的那个
			if(data.getIndex(j).compareTo(data.getIndex(k))<0)
				break;
			data.swap(k, j);
			k=j;
			
		}
		
	}
	
//	取出堆中最大元素后，替换成e
	public E replace(E e) {
		E ret=findMax();
		data.set(0, e);
		siftDown(0);
		return ret;
	}
	
	
}
