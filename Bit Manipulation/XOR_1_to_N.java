import java.util.*;

public class XOR_1_to_N {

    public static long XORtillN(long n) {

        long rem = 3 & n;

        if (rem == 0 || rem == 3) {
            return 0;
        }

        if (rem == 1) {
            return 1;
        }

        if (rem == 2) {
            return n + 1;
        }

        return 0;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.print("Enter n: ");
        long n = s.nextLong();

        System.out.println("The XOR of all number from 1 to " + n + " = " + XORtillN(n));
        s.close();
    }

}
