package my_arrays;

import example.Student;

public class array_experiment {

	public static void main(String[] args) {
		Arrays<Integer> arr=new Arrays<>(10);
		for(int i=0;i<10;i++)
			arr.addLast(i);
		System.out.println(arr);
		
		arr.addLast(15);;
		System.out.println(arr);
		
		arr.addLast(20);
		System.out.println(arr);
		
		arr.removeLast();
		System.out.println(arr);
		
		arr.removeLast();
		System.out.println(arr);
		
		/*Arrays<Student> list=new Arrays<>();
		list.addLast(new Student("张三",23));
		list.addLast(new Student("李四",24));
		list.addLast(new Student("王五",25));
		System.out.println(list);*/
		

	}

}

