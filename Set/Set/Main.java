package Set;

import java.util.ArrayList;
import java.util.Collections;

public class Main {
	public static double testSet(Set<String> set,String filename) {
		long startTime=System.nanoTime();
		
		System.out.println(filename);
		ArrayList<String> words=new ArrayList<>();
		if(FileOperation.readFile(filename, words)) {
			System.out.println("Total words:"+words.size());
			
//			Collections.sort(words);
			
			for(String word:words) {
				set.add(word);
			}
			
			System.out.println("Toral different words:"+set.getSize());
			
	  }
		long endTime=System.nanoTime();
		return (endTime-startTime)/1000000000.0;
	}
	
	public static void main(String[] args) {
		String filename="pride-and-prejudice.txt";
		
		LinkedListSet<String> linkedListSet=new LinkedListSet<>();
		double time1=testSet(linkedListSet,filename);
		System.out.println("LinkedListSet:"+time1);
		System.out.println("------------------------------------");
		
		BSTSet<String> bstSet=new BSTSet<>();
		double time2=testSet(bstSet,filename);
		System.out.println("BSTSet:"+time2);
		System.out.println("------------------------------------");
		
		AVLSet<String> AVLSet=new AVLSet<>();
		double time3=testSet(linkedListSet,filename);
		System.out.println("AVLSet:"+time3);

	}


}