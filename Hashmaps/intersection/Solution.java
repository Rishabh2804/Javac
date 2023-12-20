package intersection;

import java.util.HashMap;


public class Solution {
    
    public static void printIntersection(int[] arr1,int[] arr2){
        HashMap<Integer,Integer> present=new HashMap<>();
       
        for(int i=0;i<arr1.length;++i){
            if(present.containsKey(arr1[i]))
                present.put(arr1[i], present.get(arr1[i]) + 1);
            else
                present.put(arr1[i],1);
        }

        for(int i=0;i<arr2.length;++i){
            if(present.containsKey(arr2[i])){
                int freq=present.get(arr2[i]);
                if(freq==0)
                   continue;
                
                System.out.println(arr2[i]);

                present.put(arr2[i],freq-1);                
            }
            
        }
    }
}
