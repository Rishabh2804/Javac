package remove_duplicates;

import java.util.ArrayList;

public class Runner {
    public static void main(String[] args) {
        int a[]={1,3,2,4,1,2,2,2,10000,3,2};

        ArrayList<Integer> output=Solution.removeDuplicates(a);
        for(int i=0;i<output.size();++i){
            System.out.println(output.get(i));
        }
    }
    
}
