import java.util.ArrayList;


public class Quiz21 {

    public void run() {
        int r = cowMultiplication(123, 45);
        System.out.println(r);
    }

    int cowMultiplication(int a, int b) {
        int result = 0;
        ArrayList<Integer> listA = getDigits(123);
        ArrayList<Integer> listB = getDigits(45);
        for (int i : listA) {
            for (int j : listB) {
                result = result + i * j;
            }
        }
        return result;
    }

    // Returns a list containing the digits in the integer
    // Assumes a is not negetive
    ArrayList<Integer> getDigits(int a) {
        ArrayList<Integer> digits = new ArrayList<>();
        if (a < 0) {
            a = -a;
        }
        while (a > 10) {
            int d = a % 10;
            a = a / 10;
            digits.add(d);

        }
        digits.add(a);
        return digits;
    }

}
