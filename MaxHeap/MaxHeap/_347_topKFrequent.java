package MaxHeap;

import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;

import PriorityQueue.PriorityQueue;

public class _347_topKFrequent {

	public static void main(String[] args) {
		int[] nums= {1,1,1,2,2,3,3,3,3,4,4,4,4,4};
		int k=2;
		List<Integer> list=new Solution().topKFrequent(nums, k);
		System.out.println(list);

	}

}

class Solution{
	private class Freq implements Comparable<Freq>{
		int e;
		int freq;
		public Freq(int e,int freq) {
			this.e=e;
			this.freq=freq;
		}
		@Override
		public int compareTo(Freq another) {
			if(this.freq<another.freq)
				return 1;
			else if(this.freq>another.freq)
				return -1;
			return 0;
		}
	}
	
	public List<Integer> topKFrequent(int[] nums,int k){
		TreeMap<Integer,Integer> count=new TreeMap<>();
		for(int num:nums) {
			if(count.containsKey(num))
				count.put(num, count.get(num)+1);
			else
				count.put(num, 1);
		}
		
		PriorityQueue<Freq> pq=new PriorityQueue<>();
		for(Integer key:count.keySet()) {
			if(pq.getSize()<k)
				pq.enqueue(new Freq(key,count.get(key)));
			else {
				if(count.get(key)>pq.getFront().freq) {
					pq.dequeue();
					pq.enqueue(new Freq(key,count.get(key)));
				}
			}
			
		}
		
		List<Integer> list=new LinkedList<>();
		while(!pq.isEmpty()) {
			list.add(pq.dequeue().e);
		}
		
		return list;
		
		
	}
	
}