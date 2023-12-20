import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PriorityQueueUse {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));;
	static StringTokenizer st;

	public static void main(String[] args) throws NumberFormatException, IOException {
		st = new StringTokenizer(br.readLine());
		MyPQ pq = new MyPQ();
		int choice = Integer.parseInt(st.nextToken());
		while (choice != -1) {
			try {
				switch (choice) {
					case 1: // insert
						int element = Integer.parseInt(st.nextToken());
						pq.insert(element);
						break;
					case 2: // getMax
						System.out.println(pq.getMax());
						break;
					case 3: // removeMax
						System.out.println(pq.removeMax());
						break;
					case 4: // size
						System.out.println(pq.getSize());
						break;
					case 5: // isEmpty
						System.out.println(pq.isEmpty());
						break;
					default:
						return;
				}
				choice = Integer.parseInt(st.nextToken());
			} catch (PriorityQueueEmptyException e) {
				System.out.println("Priority Queue is EMPTY!!");
			}
		}
	}

}