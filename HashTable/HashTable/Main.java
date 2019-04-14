package HashTable;

import java.util.ArrayList;

import Map.FileOperation;

public class Main {

	public static void main(String[] args) {
		String filename="pride-and-prejudice.txt";
		ArrayList<String> words=new ArrayList<>();
		if(FileOperation.readFile(filename, words)) {
            System.out.println("Total words: " + words.size());
		}
		double time;
		
		long startTime=System.nanoTime();
		RBTree<String,Integer>rb=new RBTree<>();
		

            for (String word : words) {
            	if(rb.contains(word))
            		rb.set(word, rb.get(word)+1);
            	else
            		rb.add(word, 1);
            }
		long endTime=System.nanoTime();
		time=(endTime-startTime)/1000000000.0;
		System.out.println("RBTree: "+time+"s");
		
		startTime=System.nanoTime();
		HashTable<String,Integer>ht=new HashTable<>();
		for (String word : words) {
			if(ht.contains(word))
				ht.set(word, ht.get(word)+1);
			else
				ht.add(word, 1);
		}
		endTime=System.nanoTime();
		time=(endTime-startTime)/1000000000.0;
		System.out.println("HashTable: "+time+"s");

	}

}
