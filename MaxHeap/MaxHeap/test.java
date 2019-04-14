package MaxHeap;

import java.util.Random;

public class test {
	private static double testHeap(Integer[] testData,boolean isHeapify) {
		long startTime=System.nanoTime();
		MaxHeap<Integer> maxheap;
		if(isHeapify) {
			 maxheap=new MaxHeap<>(testData);
		}else {
			 maxheap=new MaxHeap<>();
			for(int i=0;i<testData.length;i++)
				maxheap.add(testData[i]);			
		}
		int[] list=new int[testData.length];
		for(int i=0;i<testData.length;i++)
			list[i]=maxheap.extractMax();
		
		for(int i=1;i<testData.length;i++) {
			if(list[i]>list[i-1]) {
				throw new IllegalArgumentException("Error");
			}
		}
		
		System.out.println("Pass");
		
		long endTime=System.nanoTime();
		return (endTime-startTime)/100000000;
	}
	public static void main(String[] args) {
		/*MaxHeap<Integer> maxheap=new MaxHeap<>();
		Random random=new Random();
		int n=1000000;
		for(int i=0;i<1000000;i++)
			maxheap.add(random.nextInt(Integer.MAX_VALUE));
		int[] list=new int[n];
		for(int i=0;i<n;i++)
			list[i]=maxheap.extractMax();
		
		for(int i=1;i<n;i++) {
			if(list[i]>list[i-1]) {
				throw new IllegalArgumentException("Error");
			}
		}
		
		System.out.println("Pass");*/
		
		int n=1000000;
		Random random=new Random();
		Integer[] testData=new Integer[n];
		for(int i=0;i<n;i++)
			testData[i]=random.nextInt(Integer.MAX_VALUE);
		
		double time1=testHeap(testData,true);
		double time2=testHeap(testData,false);
		System.out.println(time1);
		System.out.println(time2);
	
	}

}
