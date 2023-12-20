package merge_k_sorted_arrays;

import java.util.ArrayList;

class Triplet {
    public int data;
    public int i;
    public int j;

    public Triplet(int data) {
        this.data = data;
    }

    public Triplet() {

    }
}

class PQ {
    ArrayList<Triplet> heap;

    public PQ() {
        heap = new ArrayList<>();
    }

    boolean isEmpty() {
        return heap.size() == 0;
    }

    public void heapify(int i) {
        int smallest = i;
        int n = heap.size();
        int l = 2 * i + 1;
        int r = 2 * i + 2;

        if (l < n && heap.get(l).data < heap.get(smallest).data) {
            smallest = l;
        }
        if (r < n && heap.get(r).data < heap.get(smallest).data) {
            smallest = r;
        }

        if (smallest != i) {
            Triplet temp = heap.get(i);
            heap.set(i, heap.get(smallest));
            heap.set(smallest, temp);
            heapify(smallest);
        }

    }

    public void add(Triplet element) {
        heap.add(element);

        int childIndex = heap.size() - 1;
        int parentIndex = (childIndex - 1) / 2;

        while (childIndex > 0) {
            if (heap.get(parentIndex).data > heap.get(childIndex).data) {
                Triplet temp = heap.get(parentIndex);
                heap.set(parentIndex, heap.get(childIndex));
                heap.set(childIndex, temp);

                childIndex = parentIndex;
                parentIndex = (childIndex - 1) / 2;
            } else {
                break;
            }
        }
    }

    public Triplet remove() {
        Triplet rem = heap.get(0);
        heap.set(0, heap.get(heap.size() - 1));
        heap.remove(heap.size() - 1);
        if (heap.size() > 1) {
            heapify(0);
        }

        return rem;
    }

}

public class Solution {

    public static ArrayList<Integer> mergeKSortedArrays(ArrayList<ArrayList<Integer>> input) {
        ArrayList<Integer> ans = new ArrayList<>();
        PQ min = new PQ();

        for (int i = 0; i < input.size(); ++i) {
            ArrayList<Integer> list = input.get(i);

            if (list == null) {
                continue;
            }

            Triplet ele = new Triplet(list.get(0));
            ele.i = i;
            ele.j = 0;

            min.add(ele);
        }

        while (!min.isEmpty()) {

            Triplet temp = min.remove();
            ans.add(temp.data);

            ArrayList<Integer> list = input.get(temp.i);
            int j = temp.j + 1;

            if (j >= list.size())
                continue;

            Triplet ele = new Triplet(list.get(j));
            ele.i = temp.i;
            ele.j = j;

            min.add(ele);
        }

        return ans;
    }

    public static ArrayList<Integer> mergeKSortedArrays(int[][] input) {
        ArrayList<Integer> ans = new ArrayList<>();
        PQ min = new PQ();

        for (int i = 0; i < input.length; ++i) {
            int[] list = input[i];

            if (list == null) {
                continue;
            }

            Triplet ele = new Triplet(list[0]);
            ele.i = i;
            ele.j = 0;

            min.add(ele);
        }

        while (!min.isEmpty()) {

            Triplet temp = min.remove();
            ans.add(temp.data);

            int[] list = input[temp.i];
            int j = temp.j + 1;

            if (j >= list.length)
                continue;

            Triplet ele = new Triplet(list[j]);
            ele.i = temp.i;
            ele.j = j;

            min.add(ele);
        }

        return ans;
    }
}
