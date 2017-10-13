import java.io.*;
import java.util.*;

public class Quiz11 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        int e = 0;
        for (int i = 1; i <= 62; i++) {
            if (i <= a) {
                continue;
            }
            if (b == first_digit(power_of_2(i))) {
                e = i;
                break;
            }
        }
        System.out.println(e);
    }

    // return a value that's 2 raised to the power of x
    private static long power_of_2(int x) {
        long r = 1;
        for (int i = 0; i < x; ++i) {
            r = r * 2;
        }
        return r;
    }

    // return first digit of input
    private static int first_digit(long x) {
        while ( x > 10) {
            x = x / 10;
        }
        return (int) x;
    }
}
