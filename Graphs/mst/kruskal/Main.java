package mst.kruskal;

import java.util.*;

class Edge implements Comparable<Edge> {
    public int source;
    public int dest;
    public int weight;

    public Edge(int source, int dest, int weight) {
        this.source = source;
        this.dest = dest;
        this.weight = weight;
    }

    public void print() {
        int first = Math.min(this.source, this.dest);
        int second = Math.max(this.source, this.dest);
        System.out.print(first + " " + second + " " + this.weight);
    }

    @Override
    public int compareTo(Edge b) {
        return this.weight - b.weight;
    }

}

public class Main {

    public static Scanner s = new Scanner(System.in);

    public static int findParent(int v, int parent[]) {
        if (parent[v] == v) {
            return v;
        }

        return findParent(parent[v], parent);
    }

    public static void Kruskal(Edge input[], int v) {
        Arrays.sort(input);

        Edge output[] = new Edge[v - 1];

        int parent[] = new int[v];
        for (int i = 0; i < v; ++i) {
            parent[i] = i;
        }

        int count = 0;
        int i = -1;
        while (count != v - 1) {
            i++;

            Edge curr = input[i];

            int currParent = findParent(curr.source, parent);
            int destParent = findParent(curr.dest, parent);

            if (currParent == destParent) {
                continue;
            }

            output[count] = curr;
            count++;
            parent[currParent] = destParent;
        }

        // System.out.println();
        for (int j = 0; j < v - 1; ++j) {
            output[j].print();
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int v = s.nextInt();
        int e = s.nextInt();

        Edge input[] = new Edge[e];
        for (int i = 0; i < e; ++i) {
            int source = s.nextInt();
            int dest = s.nextInt();
            int weight = s.nextInt();

            input[i] = new Edge(source, dest, weight);
        }
        Kruskal(input, v);
    }

}
