import java.util.ArrayList;
import java.util.Arrays;

public class Quiz23 {
    public void run() {
        ArrayList<Integer> loopyCows = findLoopyCows(new ArrayList<>(Arrays.asList(0, 4, 1, 5, 4)));
        System.out.println(loopyCows);

    }
     ArrayList<Integer> findLoopyCows(ArrayList<Integer> cows) {
         ArrayList<Integer> loopCows = new ArrayList<>();
         for (int i = 0; i < cows.size(); ++i) {
             ArrayList<Boolean> visitedCows = new ArrayList<>();
             for (int j = 0; j < cows.size(); ++j) {
                 visitedCows.add(false);
             }
             if(isTheCowLoopy(i, cows, visitedCows)) {
                 loopCows.add(i);
             }
         }
         return loopCows;
     }

     boolean isTheCowLoopy(int cowIndex, ArrayList<Integer> cows, ArrayList<Boolean> visitedCows) {
         int maxVisits = cows.size(); // if there's a loop, you will visit a visited cow in no more than than steps
         int visits = 0;
         do {
             int nextCow = cows.get(cowIndex);
             if (nextCow == 0) {
                 // a cow doesn't forward message is not considered loopy
                 return false;
             }
             if (visitedCows.get(nextCow-1)) {
                 return true;
             }
             visitedCows.set(nextCow, true);
             cowIndex = nextCow;
             visits += 1;
         } while (visits < maxVisits);

         return false;
     }
}
