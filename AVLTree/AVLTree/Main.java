package AVLTree;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		System.out.println("Pride and prejudice:");
		ArrayList<String> words=new ArrayList<>();
		if(FileOperation.readFile("AVLTree\\pride-and-prejudice.txt", words)) {
			System.out.println("Total words:"+words.size());
			
			AVLTree<String,Integer> map=new AVLTree<>();
			for(String word:words) {
				if(map.contains(word))
					map.set(word, map.get(word)+1);
				else
					map.add(word, 1);
			}
			
			System.out.println("Toral different words:"+map.getSize());
			System.out.println("Frequency of pride:"+map.get("pride"));
			System.out.println("Frequency of prejudice:"+map.get("prejudice"));
			
			for(String word:words) {
				map.remove(word);
				if(!map.isBST() || !map.isBalanced())
					System.out.println("Error");
			}
			
			
		}

	}

}
