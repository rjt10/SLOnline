import java.io.File;
import java.util.HashMap;
import java.util.Scanner;

public class Quiz32d {
    public static void main(String[] args) throws Exception {
        Scanner in;
        if (args.length == 1) {
            in = new Scanner(new File(args[0]));
        } else {
            in = new Scanner(System.in);
        }
        HashMap<String, Integer> milkProduction = new HashMap<>();
        int num_entries = in.nextInt();
        for(int i = 0; i < num_entries; i++) {
            String cow = in.next();
            int production = in.nextInt();
            if (!milkProduction.containsKey(cow)) {
                milkProduction.put(cow, 0);
            }
            milkProduction.put(cow, milkProduction.get(cow) + production);
        }

        // put the cow and its milk production into their respective arrays
        int numCows = milkProduction.keySet().size();
        String[] cowNames = new String[numCows];
        int[] cowProductions = new int[numCows];
        int i = 0;
        for (String cow : milkProduction.keySet()) {
            cowNames[i] = cow;
            cowProductions[i] = milkProduction.get(cow);
            i++;
        }

        // put the minimum production to the first entry of the array
        for (i = 1; i < numCows; i++) {
            if (cowProductions[i] < cowProductions[0]) {
                String cow = cowNames[0];
                int p = cowProductions[0];
                cowNames[0] = cowNames[i];
                cowProductions[0] = cowProductions[i];
                cowNames[i] = cow;
                cowProductions[i] = p;
            }
        }
        // put the minimum production to the 2nd entry of the array
        for (i = 2; i < numCows; i++) {
            if (cowProductions[i] < cowProductions[1]) {
                String cow = cowNames[1];
                int p = cowProductions[1];
                cowNames[1] = cowNames[i];
                cowProductions[1] = cowProductions[i];
                cowNames[i] = cow;
                cowProductions[i] = p;
            }
        }

        System.out.println(cowNames[1]);
    }
}
