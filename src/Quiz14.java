import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by claire on 10/15/17.
 */
public class Quiz14 {

    static class DistanceSpeed {
        public DistanceSpeed(int d, int s) {
            distance = d;
            speed = s;
        }
        public int distance;
        public int speed;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int x = in.nextInt();
        int y = in.nextInt();

        ArrayList<DistanceSpeed> speedLimit = new ArrayList<>();
        ArrayList<DistanceSpeed> cowTravel = new ArrayList<>();
        for(int i = 0; i < x; i++) {
            int distance = in.nextInt();
            int speed = in.nextInt();
            DistanceSpeed ds = new DistanceSpeed(distance, speed);
            speedLimit.add(ds);
        }
        for(int i = 0; i < y; i++) {
            int distance = in.nextInt();
            int speed = in.nextInt();
            DistanceSpeed ds = new DistanceSpeed(distance, speed);
            cowTravel.add(ds);
        }

        // let the cow drive
        int max = 0;
        for (int i = 0; i < 100; i++) {
            int diff = getSpeedLimitAtMile(i, cowTravel) - getSpeedLimitAtMile(i, speedLimit);
            if (max < diff) {
                max = diff;
            }
        }

        System.out.println(max);
    }


    static int getSpeedLimitAtMile(int mile, ArrayList<DistanceSpeed> speedLimit) {
        int miles = 0;
        for (int i = 0; i < speedLimit.size(); i++) {
            miles += speedLimit.get(i).distance;
            if ( mile < miles) {
                return speedLimit.get(i).speed;
            }
        }
        return speedLimit.get(speedLimit.size() - 1).speed;
    }

}