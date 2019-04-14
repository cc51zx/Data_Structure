package my_queue;

public class _quene_test {

	public static void main(String[] args) {
		//method1_Arrayquene();
		//method2();
		LinkedListQuene<Integer> lquene=new LinkedListQuene<>();
		for(int i=0;i<10;i++) {
			lquene.enquene(i);
			System.out.println(lquene);
			if(i%3==2) {
				lquene.dequene();
				System.out.println(lquene);
			}
		}

	}

	public static void method2() {
		LoopQuene<Integer> quene=new LoopQuene<>();
		for(int i=0;i<10;i++) {
			quene.enquene(i);
			System.out.println(quene);
			if(i%3==0) {
				quene.dequene();
				System.out.println(quene);
			}
		}
	}

	public static void method1_Arrayquene() {
		ArrayQuene<Integer> quene=new ArrayQuene<>(20);
		for(int i=0;i<10;i++) {
			quene.enquene(i);
		}
		System.out.println(quene);
		quene.dequene();
		quene.dequene();
		System.out.println(quene);
	}

}
