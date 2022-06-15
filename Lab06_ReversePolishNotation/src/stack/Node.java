package stack;

public class Node<T>
{
    private T value;
    private Node<T> next;

    /**
     * Creates a node with null references to its element and next node
     */
    public Node() {}

    public Node(T value, Node<T> next)
    {
        this.value = value;
        this.next = next;
    }
    
    public T getElement()
    {
        return value;
    }

    public Node<T> getNext()
    {
        return next;
    }

    public void setElement(T newElem)
    {
        value = newElem;
    }

    public void setNext(Node<T> newNext)
    {
        next = newNext;
    }
    
}
