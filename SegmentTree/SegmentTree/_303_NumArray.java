package SegmentTree;

public class _303_NumArray {

	public static void main(String[] args) {
		int[]nums= {-2,0,3,-5,2,-1};
		NumArray res=new NumArray(nums);
		System.out.println(res.sumRange(0, 2));
		System.out.println(res.sumRange(2, 5));

	}

}

class NumArray{
	private SegmentTree<Integer> segmentTree;
	public NumArray(int[] nums) {
		Integer[] data=new Integer[nums.length];
		for(int i=0;i<nums.length;i++)
			data[i]=nums[i];
		segmentTree=new SegmentTree<>(data,(a,b)->a+b);
	}
	
	public int sumRange(int i,int j) {
		return segmentTree.query(i, j);
	}
	
	
}