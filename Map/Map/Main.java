package Map;

import java.util.ArrayList;

import Map.Map;

public class Main {
	public static double testMap(Map<String,Integer> map,String filename) {
		long startTime=System.nanoTime();
		System.out.println(filename);
		ArrayList<String> words=new ArrayList<>();
		if(FileOperation.readFile("pride-and-prejudice.txt", words)) {
            System.out.println("Total words: " + words.size());

            for (String word : words) {
            	if(map.contains(word))
            		map.set(word, map.get(word)+1);
            	else
            		map.add(word, 1);
            }
        }
		long endTime=System.nanoTime();
		return (endTime-startTime)/1000000000.0;
	}
	
	public static void main(String[] args) {
		String filename="pride-and-prejudice";
		
		LinkedListMap<String,Integer> linkedListMap=new LinkedListMap<>();
		double time1=testMap(linkedListMap,filename);
		System.out.println("LinkedListMap:"+time1);
		
		bstMap<String,Integer> bMap=new bstMap<>();
		double time2=testMap(bMap,filename);
		System.out.println("bstMap:"+time2);
		
		AVLMap<String,Integer> avlMap=new AVLMap<>();
		double time3=testMap(avlMap,filename);
		System.out.println("AVLMap:"+time3);
		
	}

}
