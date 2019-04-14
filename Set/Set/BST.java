package Set;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BST<E extends Comparable<E>> {
	private class Node{
		public E e;
		public Node left,right;
		public Node(E e) {
			this.e=e;
			left=null;
			right=null;
		}
	}
	
	private Node root;
	private int size;
	
	public int getSize() {
		return size;
	}
	public boolean isEmpth() {
		return size==0;
	}
	
/*	public void add(E e){
		if(root==null){
			root=new Node(e);
			size++;
		}else{
			add(root,e);
		}
	}
	private void add(Node node,E e){
		if(e.equals(node.e))
			return;
		else if(e.compareTo(e)<0 && node.left==null){
			node.left=new Node(e);
			size++;
			return;
		}else if(e.compareTo(e)>0 && node.right==null){
			node.right=new Node(e);
			size++;
			return;
		}
		
		if(e.compareTo(e)<0)
			add(node.left,e);
		else
			add(node.right,e);
		
	}*/
	//添加元素的改进
	public void add(E e){
		root=add(root,e);
	}
	//向以node为根的二叉树中添加元素e
	private Node add(Node node,E e){
		if(node==null){
			size++;
			return new Node(e);
		}
		if(e.compareTo(node.e)<0){
			node.left=add(node.left,e);
		}else if(e.compareTo(node.e)>0){
			node.right=add(node.right,e);
		}
		return node;
	}
	
	//二分搜索树的查询操作
	public boolean contains(E e){
		return contains(root,e);
	}
	private boolean contains(Node node,E e){
		if(node==null)
			return false;
		if(e.compareTo(e)==0)
			return true;
		else if(e.compareTo(node.e)<0)
			return contains(node.left,e);
		else
			return contains(node.right,e);
	}
	
	//二分搜索树的前序遍历
	public void preOrder(){
		preOrder(root);
	}
	private void preOrder(Node node){
		if(node==null)
			return;
		System.out.println(node.e);
		preOrder(node.left);
		preOrder(node.right);
	}
	//二分搜索树前序遍历的非递归
	public void preOrderNR(){
		if(root==null){
			System.out.println("null");
			return;
		}
		Stack<Node> stack=new Stack<>();
		stack.push(root);
		while(!stack.isEmpty()){
			Node cur=stack.pop();
			System.out.println(cur.e);
			if(cur.right!=null)
				stack.push(cur.right);
			if(cur.left!=null)
				stack.push(cur.left);
		}
	}
    //二分搜索树的中序遍历
	public void inOrder(){
		inOrder(root);
	}
	private void inOrder(Node node){
		if(node==null)
			return;
		inOrder(node.left);
		System.out.println(node.e);
		inOrder(node.right);
	}
	
	//二分搜索树的后序遍历
	public void postOrder(){
		postOrder(root);
	}
	private void postOrder(Node node){
		if(node==null)
			return;
		postOrder(node.left);
		postOrder(node.right);
		System.out.println(node.e);
	}
	
	public void levelOrder(){
		Queue<Node> queue=new LinkedList<>();
		if(root==null){
			System.out.println("null");
			return;
		}
		queue.add(root);
		while(!queue.isEmpty()){
			Node cur=queue.poll();
			System.out.println(cur.e);
			if(cur.left!=null)
				queue.add(cur.left);
			if(cur.right!=null)
				queue.add(cur.right);
		}
	}
	//获取最小值
	public E minimum(){
		if(size==0)
			throw new IllegalArgumentException("BST is empty");
		return minimum(root).e;
	}
	private Node minimum(Node node){
		if(node.left==null)
			return node;
		return minimum(node.left);
	}
	
	//获取最大值
	public E maximum(){
		if(size==0)
			throw new IllegalArgumentException("BST is empty");
		Node node=root;
		while(node.right!=null){
			node=node.right;
		}
		return node.e;
	}
	//删除最小元素
	public E removeMin(){
		E min=minimum();
		root=removeMin(root);
		return min;	
	}
	private Node removeMin(Node node){
		if(node.left==null){
			Node rightNode=node.right;
			node.right=null;
			size--;
			return rightNode;
		}
		
		node.left=removeMin(node.left);
		return node;
	}
	//删除最大元素
	public E removeMax(){
		E ret=maximum();
		root=removeMax(root);
		return ret;
	}
	private Node removeMax(Node node){
		if(node.right==null){
			Node leftNode=node.left;
			node.right=null;
			size--;
			return leftNode;
		}
		node.right=removeMax(node.right);
		return node;
		
	}
	
	//删除任意元素
	public void remove(E e) {
		root=remove(root,e);
	}
	private Node remove(Node node,E e) {
		if(node==null)
			return null;
		if(e.compareTo(node.e)<0) {
			node.left=remove(node.left,e);
			return node;
		}else if(e.compareTo(node.e)>0) {
			node.right=remove(node.right,e);
			return node;
		}else {//e==node.e
			if(node.left==null) {
				Node rightNode=node.right;
				node.right=null;
				size--;
				return rightNode;
			}
			if(node.right==null) {
				Node leftNode=node.left;
				node.left=null;
				size--;
				return leftNode;
			}
			
			//左右孩子均不为空
			Node successor=minimum(node.right);
			successor.right=removeMin(node.right);
			successor.left=node.left;
			
			node.right=node.left=null;
			
			return successor;
			
		}
		
	}
	
	@Override
	public String toString(){
		StringBuilder res=new StringBuilder();
		generateBSTString(root,0,res);
		return res.toString();
	}
	
	private void generateBSTString(Node node,int depth,StringBuilder res){
		if(node==null){
			res.append(generateDepth(depth)+"null"+"\n");
			return;
		}
		
		res.append(generateDepth(depth)+node.e+"\n");
		generateBSTString(node.left,depth+1,res);
		generateBSTString(node.right,depth+1,res);
		
		
	}
	private String generateDepth(int depth){
		StringBuilder res=new StringBuilder();
		for(int i=0;i<depth;i++)
			res.append("--");
		return res.toString();
	}
		
		

}
