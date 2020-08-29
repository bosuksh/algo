import java.util.Map;
import java.util.HashMap;

public class Programmer1 {
    public static void main(String[] args) {
        String[] participants = {"leo","kiki","eden"};
        String[] completion = {"eden", "kiki"};

        String answer = solution(participants, completion);
        System.out.println(answer);
    }

    public static String solution(String[] participant, String[] completion) {
        
        String answer = "";
        Map<String,Integer> pmap = new HashMap<String,Integer>();
        Map<String,Integer> cmap = new HashMap<String,Integer>();
        for(int i = 0; i< participant.length; i++) {
            if(pmap.containsKey(participant[i])) {
                Integer val = pmap.get(participant[i]);
                val++;
                pmap.put(participant[i], val);
            }else {
                pmap.put(participant[i], 1);
            }
            
        }

        for(int i = 0; i< completion.length; i++) {
            if(cmap.containsKey(completion[i])) {
                Integer val = cmap.get(completion[i]);
                val++;
                cmap.put(completion[i], val);
            }else {
                cmap.put(completion[i], 1);
            }
        }

        for(String key : pmap.keySet())  {
            if(pmap.get(key) != cmap.get(key)) {
                answer = key;
                break;
            }
        }
        return answer;
    }
}