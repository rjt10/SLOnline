import java.util.Scanner;

/**
 * Created by claire on 10/15/17.
 */
public class Quiz15 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.next();
        String b = in.next();
        if (getGoodM8(a) % 47 == getGoodM8(b) % 47){
            System.out.println("GO");
        }
        else {
            System.out.println("STAY");
        }
    }

    static int getGoodM8(String word) {
        int y = 1;
        for (char x: word.toCharArray()){
            int i = x - 'A' + 1;
            y = y * i;
        }
        return y;
    }

}
