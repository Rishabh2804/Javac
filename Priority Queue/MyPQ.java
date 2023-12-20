import java.util.ArrayList;

public class MyPQ {

    ArrayList<Integer> heap;

    public MyPQ() {
        heap = new ArrayList<>();
    }

    boolean isEmpty() {
        return heap.isEmpty();
    }

    int getSize() {
        return heap.size();
    }

    int getMax() throws PriorityQueueEmptyException {
        if (isEmpty()) {
            throw new PriorityQueueEmptyException();
        }
        return heap.get(0);
    }

    public void heapify(int i) {
        int largest = i;
        int n = getSize();
        int l = 2 * i + 1;
        int r = 2 * i + 2;

        if (l < n && heap.get(l) > heap.get(largest)) {
            largest = l;
        }
        if (r < n && heap.get(r) > heap.get(largest)) {
            largest = r;
        }

        if (largest != i) {
            int temp = heap.get(i);
            heap.set(i, heap.get(largest));
            heap.set(largest, temp);
            heapify(largest);
        }

    }

    public void insert(int element) {
        heap.add(element);

        int childIndex = heap.size() - 1;
        int parentIndex = (childIndex - 1) / 2;

        while (childIndex > 0) {
            if (heap.get(parentIndex) < heap.get(childIndex)) {
                int temp = heap.get(parentIndex);
                heap.set(parentIndex, heap.get(childIndex));
                heap.set(childIndex, temp);

                childIndex = parentIndex;
                parentIndex = (childIndex - 1) / 2;
            } else {
                break;
            }
        }
    }

    public int removeMax() throws PriorityQueueEmptyException {
        if (isEmpty())
            throw new PriorityQueueEmptyException();

        int rem = heap.get(0);
        heap.set(0, heap.get(heap.size() - 1));
        heap.remove(heap.size() - 1);
        if (heap.size() > 1) {
            heapify(0);
        }

        return rem;
    }

}