import java.util.Scanner;

public class BitManipulation {

    // Function to get the bit at the
    // ith position
    static boolean getBit(int num, int i) {

        // Return true if the ith bit is
        // set. Otherwise return false
        return ((num & (1 << i)) != 0);
    }

    // Function to set the ith bit of the
    // given number num
    static int setBit(int num, int i) {

        // Sets the ith bit and return
        // the updated value
        return num | (1 << i);
    }

    // Function to clear the ith bit of
    // the given number N
    static int clearBit(int num, int i) {

        // Create the mask for the ith
        // bit unset
        int mask = ~(1 << i);

        // Return the update value
        return num & mask;
    }

    static int toggleBit(int num, int pos) {
        return num ^= (1 << pos);
    }

    static int strip_last_set_bit(int num) {
        return num & (num - 1);
    }

    static int lowest_set_bit(int num) {
        return num & (-num);
    }

    static int sum(int a, int b) {

        return (a ^ b) + ((a & b) << 1);
    }

    // Driver Code
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        // Given number N
        int N = s.nextInt();

        System.out.println("The bit at the 3rd position is: " + (getBit(N, 3) ? '1' : '0'));

        System.out.println("The value of the given number after setting the bit at MSB is: " + setBit(N, 0));

        System.out.println("The value of the given number after clearing the bit at MSB is: " + clearBit(N, 0));

        System.out.print("Enter the values of a and b : ");
        int a = s.nextInt(), b = s.nextInt();

        System.out.println("The sum of " + a + " and " + b + " = " + sum(a, b));
        s.close();
    }
}