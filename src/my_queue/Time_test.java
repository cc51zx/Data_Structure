package my_queue;

import java.util.Random;

public class Time_test {
	public static double testQuene(Quene<Integer>q,int opCount) {
		long startTime=System.nanoTime();
		Random random=new Random();
		for(int i=0;i<opCount;i++)
			q.enquene(random.nextInt(Integer.MAX_VALUE));
		for(int i=0;i<opCount;i++)
			q.dequene();
		long endTime=System.nanoTime();
		return (endTime-startTime)/100000000.0;
	}

	public static void main(String[] args) {
		int opCount=100000;
		ArrayQuene<Integer> quene=new ArrayQuene<>();
		double time1=testQuene(quene,opCount);
		System.out.println("ArrayQuene:"+time1+"s");
		
		LoopQuene<Integer> loopquene=new LoopQuene<>();
		double time2=testQuene(loopquene,opCount);
		System.out.println("LoopQuene:"+time2+"s");
		
		

	}

}
