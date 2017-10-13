import java.lang.reflect.Array;
import java.util.ArrayList;

public class Quiz22 {
    public void run() {
        printGridLocations(24, 2);
    }

    void printGridLocations(int p, int q) {
        ArrayList<Integer> xLocations = getFactors(p);
        ArrayList<Integer> yLocations = getFactors(q);
        for (int x : xLocations) {
            for (int y: yLocations) {
                System.out.println(x + " " + y);
            }
        }

    }
    // Returns a list which contains factors of the given integer
    ArrayList<Integer> getFactors(int n) {
        ArrayList<Integer> factors = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                factors.add(i);
            }
        }
        return factors;
    }
}
