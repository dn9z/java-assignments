package stack;


public class LinkedListStack<T> implements Stack<T> {

	 private Node<T> first;   
	
	
	public LinkedListStack(){
		 first = null;
	    
	}
	
	@Override
	public boolean isEmpty() {
		 if(first == null)
	         return true;
	        return false;
	}

	@Override
	public T top() throws Underflow {
		  if(isEmpty())
	       throw new Underflow("Stack is empty.");
	       return first.getElement();
		
	}

	@Override
	public void push(T element) {
		 Node<T> v = new Node<T>(element, first);
	        first = v;	
	}

	@Override
	public T pop() throws Underflow {
		if(isEmpty())
            throw new Underflow("Stack is empty.");
        T temp = first.getElement();
        first = first.getNext();
        return temp;
	}
	


}
