import java.util.HashMap;
import java.util.Scanner;

public class Quiz13d {

    // This represents a position, (x, y) coordinate, in the grid.
    static class Position {
        private int x;
        private int y;

        Position(int x, int y) {
            this.x = x;
            this.y = y;
        }

        // String to be used a key in the hashmap for position
        public String getKey() {
            return x + ":" + y;
        }

        public void move(String d) {
            switch (d) {
                case "E":
                    x += 1;
                    break;
                case "W":
                    x -= 1;
                    break;
                case "N":
                    y += 1;
                    break;
                case "S":
                    y -= 1;
                    break;
            }

        }
    }
    public static void main(String[] args) {
        // A hashmap to record the time each cell of the grid is mowed
        HashMap<String, Integer> mowTime = new HashMap<>();

        // FJ's starting time and position
        int t = 0;
        Position pos = new Position(0, 0);
        mowTime.put(pos.getKey(), t);
        // The minimum re-mow time for the grass to re-grow
        int minReMowTime = -1;

        Scanner in = new Scanner(System.in);
        // read in the number of lines
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            // For each line, read the direction and steps
            String direction = in.next();
            int steps = in.nextInt();
            for (int s = 0; s < steps; s++) {
                // each step, it moves to a new position at a new time
                pos.move(direction);
                t = t + 1;
                String timeKey = pos.getKey();

                // if the position has been visited before, get the different from its last mowing
                if (mowTime.containsKey(timeKey)) {
                    int lastMowTime = mowTime.get(timeKey);
                    int diff = t - lastMowTime;
                    // keep track of the minReMowTime
                    if (minReMowTime < 0 || diff < minReMowTime) {
                        minReMowTime = diff;
                    }
                }
                mowTime.put(pos.getKey(), t);
            }
        }
        System.out.println(minReMowTime);
    }
}
