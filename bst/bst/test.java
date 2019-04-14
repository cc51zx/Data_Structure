package bst;

import java.util.ArrayList;
import java.util.Random;

import Set.BST;

public class test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BST<Integer> bst=new BST<>();
		int[]nums={5,6,8,1,2,4,9};
		for(int num:nums){
			bst.add(num);
		}
		
		bst.preOrder();
		System.out.println("--------------");
		bst.levelOrder();
		System.out.println("--------------");
		bst.preOrderNR();
		System.out.println("--------------");
		bst.inOrder();
		System.out.println("--------------");
		bst.postOrder();
		System.out.println("--------------");
		System.out.println(bst);
		
/*		BST<Integer> bst=new BST<>();
		Random random=new Random();
		for(int i=0;i<1000;i++)
			bst.add(random.nextInt(10000));
		ArrayList<Integer> nums=new ArrayList<>();
		while(!bst.isEmpth()){
			nums.add(bst.removeMin());
		}
		for(int i=1;i<nums.size();i++)
			if(nums.get(i-1)>=nums.get(i))
				throw new IllegalArgumentException("Illegal");
		System.out.println("Test completed");*/
		

	}

}
