package my_hashmap;

import java.util.ArrayList;

public class Map<K, V> {
    ArrayList<MapNode<K, V>> buckets;
    int size;
    int numBuckets;

    public Map() {
        numBuckets = 5;
        buckets = new ArrayList<>();
        for (int i = 0; i < 20; ++i) {
            buckets.add(null);
        }
    }

    public boolean isEmpty() {
        return buckets.isEmpty();
    }

    private int getBucketIndex(K key) {
        int hashCode = key.hashCode();
        return hashCode % numBuckets;
    }

    public int size() {
        return size;
    }

    public V removeKey(K key) {
        int bucketIndex = getBucketIndex(key);
        MapNode<K, V> head = buckets.get(bucketIndex);
        MapNode<K, V> temp = head;
        if (head.key.equals(key)) {
            size--;
            buckets.set(bucketIndex, head.next);
            return head.value;
        }

        while (temp.next != null) {
            if (temp.next.key.equals(key)) {
                V t = temp.next.value;
                temp.next = temp.next.next;
                size--;
                return t;
            }
            temp = temp.next;
        }

        return null;
    }

    public V getValue(K key) {
        int bucketIndex = getBucketIndex(key);
        MapNode<K, V> head = buckets.get(bucketIndex);
        MapNode<K, V> temp = head;
        while (temp != null) {
            if (temp.key.equals(key)) {
                return head.value;
            }
            temp = temp.next;
        }

        return null;
    }

    public void insert(K key, V value) {
        int bucketIndex = getBucketIndex(key);
        MapNode<K, V> head = buckets.get(bucketIndex);
        MapNode<K, V> temp = head;
        while (temp != null) {
            if (temp.key.equals(key)) {
                temp.value = value;
                return;
            }
            temp = temp.next;
        }
        MapNode<K, V> newElementNode = new MapNode<>(key, value);
        newElementNode.next = head;
        size++;
        buckets.set(bucketIndex, newElementNode);
        if (loadFactor() > 0.7) {
            reHash();
        }
    }

    public double loadFactor() {
        return (1.0 * size / numBuckets);
    }

    private void reHash() {
        // System.out.println("Rehashing: buckets" + numBuckets + " size " + size);
        ArrayList<MapNode<K, V>> temp = buckets;
        buckets = new ArrayList<>();
        size = 0;
        numBuckets *= 2;

        for (int i = 0; i < numBuckets; ++i) {
            buckets.add(null);
        }

        for (int i = 0; i < temp.size(); ++i) {
            MapNode<K, V> head = temp.get(i);
            while (head != null) {
                K key = head.key;
                V value = head.value;
                insert(key, value);
                head = head.next;
            }
        }
    }
}
