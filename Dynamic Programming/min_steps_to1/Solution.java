package min_steps_to1;

public class Solution {

	public static int countMinStepsToOne(int n) {
        if(n==1)
            return 0;

        if(n==2)
            return 1;
        
        int a,b,c;
        a=Integer.MAX_VALUE;
        b=Integer.MAX_VALUE;
        c=countMinStepsToOne(n-1);
        
        if(n%2==0){
            a=countMinStepsToOne(n/2);
        }

        if(n%3==0){
            b=countMinStepsToOne(n/3);
        }

        return 1 + Math.min(Math.min(a, b),c);
	}

    public static int countMinStepsToOne2(int n){
        if(n==1)
            return 0;

        int[] arr=new int[n+1];
        arr[0]=-1;
        arr[1]=0;

        for(int i=2; i<=n;++i){
            int ans=arr[i-1];

            if(i%2==0)
                ans=Math.min(ans,arr[i/2]);
            
            if(i%3==0)
                ans=Math.min(ans,arr[i/3]);

            arr[i]=ans + 1;
        }

        return arr[n];
    }
}