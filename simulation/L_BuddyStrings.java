package org.example.leetcode;

import java.util.ArrayList;
import java.util.List;

public class BuddyStrings {
    public static void main(String[] args) {
        System.out.println(buddyStrings("ab","ba"));
        System.out.println(buddyStrings("ab","ab"));
        System.out.println(buddyStrings("aa","aa"));
        System.out.println(buddyStrings("aaaaaabc","aaaaaacb"));
        System.out.println(buddyStrings("","aa"));
        System.out.println(buddyStrings("abab","abab"));

    }
    public static boolean buddyStrings(String A, String B) {
        if(A.length() != B.length())
            return false;

        List<Integer> indexList = new ArrayList<>();
        int[] charArray = new int[26];
        for(int i = 0; i < A.length(); i++) {
            charArray[A.charAt(i)-'a']++;
            if(A.charAt(i) != B.charAt(i)) {
                indexList.add(i);
            }
        }

        if(A.equals(B)) {
            for(int i = 0; i< 26; i++) {
                if(charArray[i] >=2)
                    return true;
            }
            return false;
        }

        if(indexList.size() != 2)
            return false;
        if((A.charAt(indexList.get(0)) == B.charAt(indexList.get(1))) && A.charAt(indexList.get(1)) == B.charAt(indexList.get(0)))
            return true;
        return false;

    }
}
