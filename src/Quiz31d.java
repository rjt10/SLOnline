import java.io.File;
import java.util.Scanner;

public class Quiz31d {
    public static void main(String[] args) throws Exception {
        Scanner in;
        if (args.length == 1) {
            in = new Scanner(new File(args[0]));
        } else {
            in = new Scanner(System.in);
        }
        int total = in.nextInt();
        // it's basically selecting 4 integers, a^2 + b^2 + c^2 + d^2 == total
        // and get all the combinations
        int max = (int) Math.sqrt(total);
        int number_solutions = 0;
        for (int i = 0; i <= max; i++) {
            for (int j = 0; j <= max; j++) {
                for (int k = 0; k <= max; k++) {
                    for (int l = 0; l<= max; l++) {
                        if (i*i + j*j + k*k + l*l == total) {
                            number_solutions += 1;
                            //System.out.println(String.format("%d %d %d %d", i, j, k, l));
                        }
                    }
                }
            }
        }
        System.out.println(number_solutions);
    }
}
