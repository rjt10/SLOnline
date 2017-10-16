import java.util.Scanner;

public class Quiz22d {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int p = in.nextInt();
        int q = in.nextInt();

        for (int i = 1; i <= p; i++) {
            for (int j = 1; j <= q; j++) {
                if (p % i == 0 && q % j == 0) {
                    System.out.println(i + " " + j);
                }
            }
        }
    }
}
