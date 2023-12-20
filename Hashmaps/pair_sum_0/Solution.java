package pair_sum_0;

import java.util.HashMap;

public class Solution {
    
    public static int PairSum(int[] input, int size) {
        HashMap<Integer,Integer> present=new HashMap<>();
        present.put(0,0);

        int zero=0;
        for(int i=0;i<size;++i){
            if(input[i]<0){
                if(present.containsKey(input[i]))
                    present.put(input[i], present.get(input[i]) + 1);
                else    
                    present.put(input[i],1);
            } 
            else if(input[i]==0){
                zero++;   //count no of zeroes
            }
        }

        int count=zero*(zero-1) >> 1;

        for(int i=0;i<size;++i){
            if(input[i]>0 && present.containsKey(-1*input[i])){
                    count+=present.get(-1*input[i]);                       
            }
        }
    
        return count;
    }
}
