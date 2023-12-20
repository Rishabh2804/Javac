package assignment.coding_ninjas;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Runner {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static String[] takeInput() throws IOException {
        String[] strNums;
        strNums = br.readLine().split("\\s");
        int size = 2;
        int[] input = new int[size];
        for (int i = 0; i < size; ++i) {
            input[i] = Integer.parseInt(strNums[i]);
        }

        String[] Graph = new String[input[0]];

        for (int i = 0; i < input[0]; ++i) {
            Graph[i] = br.readLine();
        }

        return Graph;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {

        String[] Graph = takeInput();
        System.out.println(new Solution().solve(Graph, Graph.length, Graph[0].length()));

    }
}