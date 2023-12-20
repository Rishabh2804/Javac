package stack_usingll;

public class Stack<T> {
    public Node<T> top;
    int size = 0;

    public Stack() {
        top = null;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        if (top == null)
            return true;
        else
            return false;
    }

    public void push(T element) {
        Node<T> newnode = new Node<>(element);

        newnode.next = top;
        top = newnode;
        size++;
    }

    public T pop() throws StackEmptyException {
        if (this.isEmpty())
            throw new StackEmptyException();

        T ele = top.data;
        top = top.next;
        size--;
        return ele;
    }

    public T top() throws StackEmptyException {
        if (top == null)
            throw new StackEmptyException();

        return top.data;
    }
}