import java.util.Arrays;
import java.util.HashMap;
import java.util.Collections;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashSet;

public class Line4 {
    public static void main(String[] args) {
        String[][] snapshots = {
            {"ACCOUNT1", "100"}, 
            {"ACCOUNT2", "150"}
        };
        String[][] transactions = { 
            {"1", "SAVE", "ACCOUNT2", "100"},
            {"2", "WITHDRAW", "ACCOUNT1", "50"}, 
            {"1", "SAVE", "ACCOUNT2", "100"}, 
            {"4", "SAVE", "ACCOUNT3", "500"}, 
            {"3", "WITHDRAW", "ACCOUNT2", "30"} 
        };
        solution(snapshots, transactions);
    }

    public static String[][] solution(String[][] snapshots, String[][] transactions) {
        Map<String, Integer> map = new HashMap<>();
        Map<String, Integer> check = new HashMap<>();

        for(int i = 0; i< snapshots.length; i++) {
            map.put(snapshots[i][0], Integer.parseInt(snapshots[i][1]));
        }
        //transactions = new HashSet<String[]>(Arrays.asList(transactions)).toArray(new String[0][]);

        for(int i = 0; i< transactions.length; i++) {
            if (check.containsKey(transactions[i][0])) {
                continue;
            }
            check.put(transactions[i][0], 1);

            if(transactions[i][1].equals("SAVE")) {
                if(map.containsKey(transactions[i][2])) {
                    int val = map.get(transactions[i][2]);
                    val += Integer.parseInt(transactions[i][3]);
                    map.put(transactions[i][2], val);
                }else {
                    map.put(transactions[i][2], Integer.parseInt(transactions[i][3]));
                }

            }else {
                int val = map.get(transactions[i][2]);
                val -= Integer.parseInt(transactions[i][3]);
                map.put(transactions[i][2], val);
            }
        }

        List<String> keySetList = new ArrayList<>(map.keySet());
        // 내림차순 //
        Collections.sort(keySetList, (o1, o2) -> (map.get(o1).compareTo(map.get(o2))));
        String[][] answers = new String[map.size()][2];
        int idx = 0;
        for (String key : keySetList) {
            answers[idx][0] = key;
            answers[idx++][1] = Integer.toString(map.get(key));
        }

        return null;
    }
}