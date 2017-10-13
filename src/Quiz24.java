import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Quiz24 {

    public void run() {
        doGifts();
    }

    void doGifts() {
        HashMap<String, Integer> wallet = new HashMap<>();
        wallet.put("dave", 200);
        wallet.put("owen", 500);
        wallet.put("amr", 150);
        wallet.put("laura", 0);
        wallet.put("vick", 0);

        HashMap<String, ArrayList<String>> friends = new HashMap<>();
        friends.put(
                "dave",
                new ArrayList<>(Arrays.asList("laura", "owen", "vick")));
        friends.put(
                "owen",
                new ArrayList<>(Arrays.asList("dave")));
        friends.put(
                "amr",
                new ArrayList<>(Arrays.asList("owen", "vick")));
        friends.put(
                "laura",
                new ArrayList<>(Arrays.asList("owen", "vick")));
        friends.put(
                "vick",
                new ArrayList<>(Arrays.asList()));

        HashMap<String, Integer> moneyToDistribute = new HashMap<>();
        for (String person : wallet.keySet()) {
            Integer money = wallet.get(person);
            moneyToDistribute.put(person, money);
        }

        for (String person: friends.keySet()) {
            int money = moneyToDistribute.get(person);
            int numberOfFriends = friends.get(person).size();
            if (numberOfFriends > 0) {
                int r = money % numberOfFriends;
                int give = money / numberOfFriends;
                // distribute
                wallet.put(person, wallet.get(person) - money);
                // put back the remainder
                wallet.put(person, wallet.get(person) + r);
                // put money in friend's wallet
                for (String friend : friends.get(person)) {
                    wallet.put(friend, wallet.get(friend) + give);
                }
            }
        }
        for (String person: wallet.keySet()) {
            System.out.println(person + ": " + wallet.get(person));
        }
    }

}
