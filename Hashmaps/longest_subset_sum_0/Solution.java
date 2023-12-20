package longest_subset_sum_0;

import java.util.HashMap;

public class Solution {

    public static int lengthOfLongestSubsetWithZeroSum(int arr[]) {
        if(arr.length==0)
           return 0;
	
        HashMap<Integer,Integer> sum=new HashMap<>();
        sum.put(0, -1);
        
        int maxl=0,s=0;
        for(int i=0;i<arr.length;++i){
            s+=arr[i];
            if(sum.containsKey(s)){
                int l=i-sum.get(s);
                if(maxl<l)
                   maxl=l;
            }
            else
                sum.put(s, i);
        }

        return maxl;
    }
}
