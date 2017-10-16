import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Quiz23d {
    public static void main(String[] args) throws Exception {
        Scanner in;
        if (args.length == 1) {
            in = new Scanner(new File(args[0]));
        } else {
            in = new Scanner(System.in);
        }
        int nCows = in.nextInt();
        // relay contains information about how each cow relays info
        HashMap<Integer, Integer> relayInfo = new HashMap<>();
        for(int i = 1; i <= nCows; i++) {
            relayInfo.put(i, in.nextInt());
        }

        ArrayList<Integer> loopCows = new ArrayList<>();
        for (int i = 1; i < nCows; i++) {
             if (isCowLoopy(i, relayInfo)) {
                loopCows.add(i);
            }
        }
        System.out.println(loopCows.size());
    }

    // Return true is ith cow is loopy
    // how to determine if a cow is loopy
    // if the cow is loopy, then the message will hit the same cow again in no more than nCows steps
    // if the cow's message reach a dead end, i.e. reach 0, then it's not loopy
    private static boolean isCowLoopy(Integer cow, HashMap<Integer, Integer> relayInfo) {
        HashMap<Integer, Boolean> visitedCows = new HashMap<>();
        int maxSteps = relayInfo.size();
        int cowToVisit = cow;
        for (int i = 0; i < maxSteps; i++) {
            if (relayInfo.get(cowToVisit) == 0) {
                return false;
            }
            if (visitedCows.containsKey(cowToVisit)) {
                return true;
            }
            visitedCows.put(cowToVisit, true);
            // move on to the next cow
            cowToVisit = relayInfo.get(cowToVisit);
        }
        // return false when not finding a loop
        return false;
    }
}
