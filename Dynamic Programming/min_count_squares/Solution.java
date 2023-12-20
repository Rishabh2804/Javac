package min_count_squares;
public class Solution {
    
    public static boolean isSquare(double number)    
    {   
        double sqrt=Math.sqrt(number);   
        
        return ((sqrt - Math.floor(sqrt)) == 0);   
    }
    
    public static int minCount(int n) {

        int[] a=new int[n+1];
        for(int i=0;i<=n;++i){
            if(isSquare(i)){
                a[i]=1;
                continue;
            }        
            
            int temp=Integer.MAX_VALUE;
            for(int j=1;j*j<=i;++j){
                temp=Math.min(temp,a[i-j*j]);
            }
            
            a[i]=1 + temp;
        }
        
        return a[n];
    }

}