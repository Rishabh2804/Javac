package staircase;

public class Solution {
    
    public static long staircase(int n) {
        if(n==1 || n==2)
            return n;

        if(n==3)
            return 4;
		
        long[] steps=new long[n+1];
        steps[0]=-1;
        steps[1]=1;
        steps[2]=2;
        steps[3]=4;

        for(int i=4;i<=n;++i){

            steps[i]=steps[i-1] + steps[i-2] + steps[i-3];

        }

        return steps[n];
	}
}
