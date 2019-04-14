package LinkedList;

public class test_LinkedList {

	public static void main(String[] args) {
		LinkedList<Integer> list=new LinkedList<>();
		for(int i=0;i<5;i++) {
			list.addFirst(i);			
			System.out.println(list);
		}
		
		list.set(3, 666);
		System.out.println(list);
		

	}

}
