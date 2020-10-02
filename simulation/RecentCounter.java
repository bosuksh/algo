package org.example.leetcode;

import java.util.ArrayList;
import java.util.List;

public class RecentCounter {
    private List<Integer> requests;
    private int lastIndex;
    private int firstIndex;
    public RecentCounter() {
        requests = new ArrayList<>();
        firstIndex = 0;
        lastIndex = 0;
    }

    public int ping(int t) {
        int startRange = t - 3000;
        int endRange = t;
        requests.add(t);
        lastIndex++;
        while(firstIndex < lastIndex) {
            if(requests.get(firstIndex) >= startRange) {
                break;
            }
            firstIndex++;
        }

        return lastIndex-firstIndex;

    }
}
