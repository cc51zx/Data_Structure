package SegmentTree;

public class _307_NumArray_Update {

	public static void main(String[] args) {
		int[]nums= {-2,0,3,-5,2,-1};
		NumArray1 res=new NumArray1(nums);
		System.out.println(res.sumRange(0, 2));
		System.out.println(res.sumRange(2, 5));

	}

}

class NumArray1{
	private SegmentTree<Integer> segmentTree;
	public NumArray1(int[] nums) {
		Integer[] data=new Integer[nums.length];
		for(int i=0;i<nums.length;i++)
			data[i]=nums[i];
		segmentTree=new SegmentTree<>(data,(a,b)->a+b);
	}
	
	public int sumRange(int i,int j) {
		return segmentTree.query(i, j);
	}
	
	
}