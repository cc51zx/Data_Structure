package my_stack;

import java.util.Random;

public class Time_test {
	public static double test(Stack<Integer> stack,int opCount) {
		long startTime=System.nanoTime();
		Random random=new Random();
		for(int i=0;i<opCount;i++)
			stack.push(random.nextInt(Integer.MAX_VALUE));
		for(int i=0;i<opCount;i++)
			stack.pop();
		long endTime=System.nanoTime();
		double time=(endTime-startTime)/100000000.0;
		return time;
	}
	

	public static void main(String[] args) {
		int opCount=100000;
		ArrayStack<Integer> arrayStack=new ArrayStack<>();
		double time1=test(arrayStack,opCount);
		System.out.println("ArrayStack:"+time1+"s");
		
		LinkedListStack<Integer> linkedlistStack=new LinkedListStack<>();
		double time2=test(linkedlistStack,opCount);
		System.out.println(time2);

	}

}
