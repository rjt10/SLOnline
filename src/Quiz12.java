import java.util.Scanner;

public class Quiz12 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int x = in.nextInt();
        int y = in.nextInt();
        int m = in.nextInt();
        int r = 0;

        int num_x = m / x;
        int num_y = m / y;

        for (int i = 0; i <= num_x; i++) {
            for (int j = 0; j <= num_y; j++) {
                int a = i * x + j * y;
                if (a <= m && a > r) {
                    r = a;
                }
            }
        }
        System.out.println(r);
    }
}
