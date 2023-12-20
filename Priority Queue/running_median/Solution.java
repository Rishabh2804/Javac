package running_median;

import java.util.Collections;
import java.util.PriorityQueue;


public class Solution {
    
    public static void findMedian(int arr[]){
        if(arr.length==0)
            return;

        int median =arr[0];

        PriorityQueue<Integer> min=new PriorityQueue<>();
        PriorityQueue<Integer> max=new PriorityQueue<>(Collections.reverseOrder());

        max.add(arr[0]);

        System.out.print(median + " ");

        for(int i=1;i<arr.length;++i){
            if(max.size() > min.size()){
                if(arr[i]<median){
                    min.add(max.remove());
                    max.add(arr[i]);
                }
                else
                    min.add(arr[i]);
                
                median=(max.peek() + min.peek()) >> 1;
            }
            else if(max.size() < min.size()){
                if(arr[i]<median)
                    max.add(arr[i]);
                else{
                    max.add(min.remove());
                    min.add(arr[i]);
                }
                
                median=(max.peek() + min.peek()) >> 1;
            }
            else{   //max heap and min heap are of equal size
                if(arr[i]<median){
                    max.add(arr[i]);
                    median=max.peek();
                }
                else{
                    min.add(arr[i]);
                    median=min.peek();
                }
            }

            System.out.print(median + " ");
        }
    }

    
}
