package SegmentTree;

public class SegmentTree<E> {
	private E[] tree;
	private E[] data;
	private Merge<E> merge;
	
	public SegmentTree(E[] arr,Merge<E> merge) {
		this.merge=merge;
		data=(E[])new Object[arr.length];
		for(int i=0;i<data.length;i++)
			data[i]=arr[i];
		tree=(E[])new Object[4*arr.length];
		buildSegmentTree(0,0,data.length-1);
		
	}
	private void buildSegmentTree(int treeIndex,int l,int r) {
		if(l==r) {
			tree[treeIndex]=data[l];
			return;
		}
		int leftTreeIndex=leftChild(treeIndex);
		int rightTreeIndex=rightChild(treeIndex);
		
		int m=l+(r-l)/2;
		buildSegmentTree(leftTreeIndex,l,m);
		buildSegmentTree(rightTreeIndex,m+1,r);
		
		tree[treeIndex]=merge.merge(tree[leftTreeIndex], tree[rightTreeIndex]);
		
		
	}
	
	public int getSize() {
		return data.length;
	}
	public E get(int index) {
		if(index<0 || index>=data.length)
			throw new IllegalArgumentException("Illegal index");
		return data[index];
	}
	
	private int leftChild(int index) {
		return 2*index+1;
	}
	private int rightChild(int index) {
		return 2*index+2;
	}
	
//	返回区间[queryL,queryR]的值
	public E query(int queryL,int queryR) {
		if(queryL<0 || queryL>=data.length ||
		   queryR<0 || queryR>=data.length || queryL>queryR)
			throw new IllegalArgumentException("Illegal index");
		return query(0,0,data.length-1,queryL,queryR);
	}
//	在以treeIndex为根的线段树中[l,r]的范围内，搜索区间[queryL,queryR]的值
	private E query(int treeIndex,int l,int r,int queryL,int queryR) {
		if(l==r)
			return tree[treeIndex];
		int m=l+(r-l)/2;
		int leftTreeIndex=leftChild(treeIndex);
		int rightTreeIndex=rightChild(treeIndex);
		if(queryL>=m+1)
			return query(rightTreeIndex,m+1,r,queryL,queryR);
		if(queryR<=m)
			return query(leftTreeIndex,l,m,queryL,queryR);
		E leftResult=query(leftTreeIndex,l,m,queryL,m);
		E rightResult=query(rightTreeIndex,m+1,r,m+1,queryR);
		
		return merge.merge(leftResult, rightResult);
	}
//	将index位置的值更新为e
	public void set(int index,E e) {
		if(index<0 || index>=data.length)
			throw new IllegalArgumentException("Illegal index");
		data[index]=e;
		set(0,0,data.length-1,index,e);
	}
//	在以treeIndex为根的线段树中更新index的值为e
	public void set(int treeIndex,int l,int r,int index,E e) {
		if(l==r) {
			tree[treeIndex]=e;
			return;
		}
		int leftTreeIndex=leftChild(treeIndex);
		int rightTreeIndex=rightChild(treeIndex);
		int m=l+(r-l)/2;
		
		if(index>=m+1)
			set(rightTreeIndex,m+1,r,index,e);
		else 
			set(leftTreeIndex,l,m,index,e);
		tree[treeIndex]=merge.merge(tree[leftTreeIndex],tree[rightTreeIndex]);
		
	}
	@Override
	public String toString() {
		StringBuilder res=new StringBuilder();
		res.append("[");
		for(int i=0;i<tree.length;i++) {
			if(tree[i]!=null) {
				res.append(tree[i]);
			}else 
				res.append("null");
			if(i!=tree.length-1)
				res.append(",");
		}
		return res.toString();
	}
	
	
	

}
