package stack;

public interface Stack<T> {

	public boolean isEmpty();

	public T top() throws Underflow;

	public void push(T element);

	public T pop() throws Underflow;
	
//	public String toString();

}
