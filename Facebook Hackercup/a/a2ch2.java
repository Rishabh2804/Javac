package a;

import java.util.*;

public class a2ch2 {
//tIME COMPLEXITY IS V^2
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		s.nextLine();

		for(int t1=1;t1<=t;t1++) {
			String str = s.nextLine();
			int e = s.nextInt();
			s.nextLine();

			int adjacencyMatrix[][] = new int[26][26];
			for (int i = 0; i < e; i++) {
				String str2 = s.nextLine();

				int source = (int) str2.charAt(0) - 'A';
				int dest = (int) str2.charAt(1) - 'A';

				adjacencyMatrix[source][dest] = 1;

			}
			HashMap<Integer, HashMap<Integer, Integer>> arr = new HashMap<>();
			for (int i = 0; i < 26; i++) {
				if (str.contains((char) ('A' + i) + "")) {
					arr.put(i, Dijkstra(adjacencyMatrix, 26, i));
				}
			}

			int ans = Integer.MAX_VALUE;
//			System.out.println(arr);

			for (int i = 0; i < 26; i++) {
				char x = (char) ('A' + i);

				int cans = 0;
				boolean canBeCoverted = true;
//				if (str.contains(x + "")) 
				{
					
					for (int j = 0; j < str.length(); j++) {
						if (str.charAt(j) != x) {
							int index = str.charAt(j) - 'A';
							if (!arr.containsKey(index)) {
								canBeCoverted = false;
								break;
							}

							else {
								int m = x - 'A';
								if (!arr.get(index).containsKey(m)) {
									canBeCoverted = false;
									break;
								} else
									cans += arr.get(index).get(m);
							}

						}
					}
						if (!canBeCoverted)
							continue;
						else {
							ans = Math.min(ans, cans);
							

						}
					
				}

			}
			if(ans==Integer.MAX_VALUE)
				ans=-1;
			System.out.println("Case #" + t1 + ": " + ans);
			s.close();
		}
		
	}

	private static HashMap<Integer, Integer> Dijkstra(int[][] adjacencyMatrix, int v, int k) {
		int minDistance[] = new int[v];
		minDistance[k] = 0;
		for (int i = 0; i < v; i++) {
			if (i != k)
				minDistance[i] = Integer.MAX_VALUE;
		}
		boolean visited[] = new boolean[v];
		int minIndex = k;
		for (int i = 0; i < v; i++) {

			if (i != 0)
				minIndex = findMinDist(minDistance, visited);

			visited[minIndex] = true;
			for (int j = 0; j < v; j++) {
				if (adjacencyMatrix[minIndex][j] != 0 && !visited[j]) {
					int pathWeightviaMinIndex = minDistance[minIndex] + adjacencyMatrix[minIndex][j];
					minDistance[j] = Math.min(minDistance[j], pathWeightviaMinIndex);
				}
			}
		}
		HashMap<Integer, Integer> dist = new HashMap<>();
		for (int i = 0; i < minDistance.length; i++) {
			if (minDistance[i] != Integer.MAX_VALUE && minDistance[i]>=0
				)
				dist.put(i, minDistance[i]);
		}
		return dist;
	}

	private static int findMinDist(int[] minDistance, boolean[] visited) {

		int minIndex = -1;
		for (int i = 0; i < minDistance.length; i++) {
			if (!visited[i] && (minIndex == -1 || minDistance[i] < minDistance[minIndex])) {
				minIndex = i;
			}

		}
		return minIndex;
	}

}
