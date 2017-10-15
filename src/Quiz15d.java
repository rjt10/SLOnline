import java.util.Scanner;

public class Quiz15d {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String cometName  = in.next();
        String groupName = in.next();

        if (getNumber(cometName) == getNumber(groupName)) {
            System.out.println("GO");
        } else {
            System.out.println("STAY");
        }
    }

    static int getNumber(String s) {
        int x = 1;
        for (char ch : s.toCharArray()) {
            int i = ch - 'A' + 1;
            x = x * i;
        }
        return x % 47;
    }
}
