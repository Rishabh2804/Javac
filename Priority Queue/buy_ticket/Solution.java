package buy_ticket;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;


public class Solution {

    
	public static int buyTicket(int input[], int k) {
        Queue<Integer> q = new LinkedList<>();

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i : input){
            q.add(i);
            pq.add(i);
        }
        int count = 0;
        while(!pq.isEmpty()){
            if(q.peek().equals(pq.peek())){
                if(k == 0){
                    return count + 1;
                } else{
                    count ++;
                    q.poll();
                    pq.poll();
                    if(k == 0){
                        k = q.size() - 1;
                    } else{
                        k--;
                    }
                }
            }
        }

        return count;
	   }
}