import java.io.File;
import java.util.Scanner;

public class Quiz33d {
    public static void main(String[] args) throws Exception {
        Scanner in;
        if (args.length == 1) {
            in = new Scanner(new File(args[0]));
        } else {
            in = new Scanner(System.in);
        }
        int rows = in.nextInt();
        int cols = in.nextInt();
        int[][] grid = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                grid[i][j] = in.nextInt();
            }
        }

        int deepest = Integer.MIN_VALUE;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // check if (i, j) has a neighboring cell whose value is equal to its
                for (int ii = -1; ii <= 1; ii++) {
                    for (int jj = -1; jj <= 1; jj++ ) {
                        int neighbor_i = i + ii;
                        int neighbor_j = j + jj;
                        if (neighbor_i == i && neighbor_j == j) {
                            continue; // don't double count yourself
                        }
                        if (neighbor_i < 0 || neighbor_i >= rows || neighbor_j < 0 || neighbor_j >= cols) {
                            continue; // not legit grid position
                        }
                        if (grid[i][j] == grid[neighbor_i][neighbor_j] && grid[i][j] > deepest) {
                            deepest = grid[i][j];
                        }
                    }
                }
            }
        }
        System.out.println(deepest);
    }
}
