import java.io.File;
import java.util.HashMap;
import java.util.Scanner;

public class Quiz34d {
    public static void main(String[] args) throws Exception {
        Scanner in;
        if (args.length == 1) {
            in = new Scanner(new File(args[0]));
        } else {
            in = new Scanner(System.in);
        }
        int numCows = in.nextInt();
        int numEntries = in.nextInt();
        HashMap<String, Integer> accumTime = new HashMap<>();
        HashMap<String, Integer> startTime = new HashMap<>();
        for (int i = 0; i < numEntries; i++) {
            String cowId = in.next();
            String startOrStop = in.next();
            int hours = in.nextInt();
            int mins = in.nextInt();
            if (startOrStop.equals("START")) {
                startTime.put(cowId, hours*60+mins);
            } else {
                int cowTime = 0;
                if (accumTime.containsKey(cowId)) {
                    cowTime = accumTime.get(cowId);
                }
                accumTime.put(cowId, cowTime + hours*60+mins - startTime.get(cowId));
            }
        }
        for (int i = 1; i <= numCows; i++) {
            String cowId = String.format("%d", i);
            int cowTime = accumTime.get(cowId);
            // System.out.println(cowId + " " + cowTime );
            int hours = cowTime / 60;
            int mins = cowTime % 60;
            System.out.println(hours + " " + mins);

        }
    }
}
