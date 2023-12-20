package queue_usingll;

public class Queue<T> {
    private Node<T> front;
    private Node<T> rear;
    int size;

	public Queue() {
        front=null;
        rear=null;
        size=0;
	}

	public int getSize() { 
        return size;
    }

    public boolean isEmpty() { 
        return size==0;
    }

    public void enqueue(T data) {
        Node<T> newnode=new Node<>(data);
        if(size==0){
            front=newnode;
        }
        else if(size==1){
            rear=newnode;
            front.next=rear;            
        }
        else{
            rear.next=newnode;
            rear=rear.next;
        }
        size++;
    }

    public T dequeue() throws QueueEmptyException {
        if(size==0)
            throw new QueueEmptyException();
        
        T res=front.data;
        front=front.next;
        size--;
        
        return res;
    }

    public T front() throws QueueEmptyException{
        if(front==null)
            throw new QueueEmptyException();
        
        return front.data;
    }
}
