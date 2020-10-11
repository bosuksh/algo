package org.example.leetcode;

import java.util.HashMap;
import java.util.Map;

public class RemoveDuplicate {
    public static void main(String[] args) {
        String s = "bcabc";
        System.out.println(removeDuplicateLetters(s));
        String s1 = "cbacdcbc";
        System.out.println(removeDuplicateLetters(s1));
    }

    public static String removeDuplicateLetters(String s) {
        int[] alphabetCount = new int[26];
        boolean[] visited = new boolean[26];
        for(int i = 0; i< s.length(); i++){
            alphabetCount[s.charAt(i)-'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            alphabetCount[cur-'a']--;
            if(!visited[cur-'a']) {
                //현재까지 완성된 문자열에서 아직 사용안한 단어가 있고,
                while(sb.length() > 0 && sb.charAt(sb.length()-1) > cur && alphabetCount[sb.charAt(sb.length()-1)-'a'] > 0){
                    visited[sb.charAt(sb.length()-1)-'a'] = false;
                    sb.deleteCharAt(sb.length()-1);
                }
                sb.append(cur);
                visited[cur-'a']= true;
            }
        }
        return sb.toString();
    }
}
