package my_queue;

public interface Quene<E> {
	int getSize();
	boolean isEmpty();
	void enquene(E e);
	E dequene();
	E getFront();

}
