package fibonacci;

import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static long fibo(int n) {
        if (n == 0 || n == 1) {
            return n;
        }

        return fibo(n - 1) + fibo(n - 2);
    }

    public static HashMap<Long, Long> fib;

    public static long fibo2(long n) {
        if (n == 0 || n == 1) {
            return n;
        }

        if (fib.containsKey(n)) {
            return fib.get(n);
        }

        fib.put(n, fibo2(n - 1) + fibo2(n - 2));
        return fib.get(n);
    }

    public static long fibo3(int n){
        if(n==0 || n==1){
            return n;
        }

        long[] fib=new long[n+1];
        fib[0]=0;
        fib[1]=1;

        for(int i=2;i<=n;++i){
            fib[i] = fib[i-1] + fib[i-2];
        }

        return fib[n];
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();

        System.out.println(fibo3(n));

        fib = new HashMap<>();
        System.out.println(fibo2(n));

        // System.out.println(fibo(n));

        s.close();
    }

}
