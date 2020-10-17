package org.example.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RepeatedDNASequences {

    public static void main(String[] args) {
        String s = "AAAAAAAAAAA";

        List<String> repeatedDnaSequences = findRepeatedDnaSequences(s);
        for(String sequence: repeatedDnaSequences) {
            System.out.println(sequence);
        }
    }

    public static List<String> findRepeatedDnaSequences(String s) {
        Map<String, Integer> map = new HashMap<>();
        List<String> answer = new ArrayList<>();
        for(int i = 0; i <= s.length()-10; i++) {
            String subString = s.substring(i,i+10);
            if(map.containsKey(subString)) {
                answer.add(subString);
                continue;
            }
            map.put(subString,1);
        }
        return answer;
    }
}
