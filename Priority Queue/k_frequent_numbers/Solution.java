package k_frequent_numbers;

import java.util.ArrayList;
import java.util.HashMap;

public class Solution {

    public static ArrayList<Integer> list=new ArrayList<>();

    public static HashMap<Integer,Integer> freq=new HashMap<>();

    // private static void remove(int ele){

    //     for(int i=0;i<list.size();++i){
    //         if(list.get(i)==ele){
    //             list.remove(i);
    //             return;
    //         }
    //     }
    
    // }

    private static void sort(){
        if(list.size()==0 || list.size()==1)
            return;

        int curr=list.get(list.size()-1);
        int j=list.size()-2;

        while(j>=0){
            int prev=list.get(j);
            if(freq.get(prev) < freq.get(curr)){
                list.set(j+1, prev);
                j--;
            }
            else if(freq.get(prev) == freq.get(curr) && prev > curr){
                list.set(j+1, prev);
                j--;
            }
            else
                break;
        }
        j++;
        list.set(list.size()-1, list.get(j));
        list.set(j, curr);
        
    }

    public static void kFrequent(int[] arr,int k) {
        if (arr.length == 0)
            return;



        for(int i=0;i<arr.length;++i){
            if(freq.containsKey(arr[i])){
                freq.put(arr[i], freq.get(arr[i]) + 1);            
            }
            else{
                freq.put(arr[i], 1);
                list.add(arr[i]);
            }

            sort();

            for(int j=0;j<k;++j){
                if(j>=list.size())
                    break;
                
                System.out.print(list.get(j) + " ");
            }
         
        }
        
    }

    public static void main(String[] args) {
        
        int arr[]={5,1,3,5,2};
        kFrequent(arr, 3);

        
    }
}
