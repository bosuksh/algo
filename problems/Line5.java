import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Line5 {

    public static void main(String[] args) {
        String[][] datatSource = {
            {"doc1", "t1", "t2", "t3"},
            {"doc2", "t0", "t2", "t3"},
            {"doc3", "t1", "t6", "t7"},
            {"doc4", "t1", "t2", "t4"},
            {"doc5", "t6", "t100", "t8"}};
        String[] tags = {
            "t1","t2","t3"
        };
        solution(datatSource, tags);
    }

    public static String[] solution(String[][] dataSource, String[] tags) {
        HashMap<String, Integer> hashMap = new HashMap<String, Integer>();
        for(int i = 0; i< tags.length; i++) {
            for(int j = 0; j< dataSource.length; j++) {
                if(Arrays.stream(dataSource[j]).anyMatch(tags[i]::equals)) {
                    if(hashMap.containsKey(dataSource[j][0])) {
                        int val = hashMap.get(dataSource[j][0]);
                        val++;
                        hashMap.put(dataSource[j][0],val);
                    }else {
                        hashMap.put(dataSource[j][0],1);
                    }
                }
            }
        }

        String[] answer = new String[hashMap.size()];
        List<Map.Entry<String, Integer>> list = new LinkedList<>(hashMap.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                int comparision = (o1.getValue() - o2.getValue()) * -1;
                return comparision == 0 ? o1.getKey().compareTo(o2.getKey()) : comparision;
            }
        });

        int idx = 0;
        for (Iterator<Map.Entry<String, Integer>> iter = list.iterator(); iter.hasNext();) {
            Map.Entry<String, Integer> entry = iter.next();
            answer[idx++] = entry.getKey();
            //sortedMap.put(entry.getKey(), entry.getValue());
        }
        
        return answer;
    }
}