package balanced_bts;

public class Solution {

    static long m=1000000007;

    public static long balancedBTs(int height) {
        if (height <= 1)
            return 1;

        long a = balancedBTs(height - 1);
        long b = balancedBTs(height - 2);

        return (a * a + 2 * a * b) % m;
    }

    public static long balancedBTs2(int height){
        if (height <= 1)
            return 1;

        long[] bt=new long[height+1];

        bt[0]=1;
        bt[1]=1;

        for(int i=2;i<=height;++i){
            long a=bt[i-1];
            long b=bt[i-2];

            bt[i]=(a*a + 2*a*b) % m;
        }

        return bt[height];
    }

}
