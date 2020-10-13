package org.example.leetcode;

import java.util.*;

public class SortingListNode {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode sortListByPQ(ListNode head) {
        ListNode cur = head;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o));
        while(cur != null) {
            pq.add(cur.val);
            cur = cur.next;
        }
        cur = head;
        while(cur != null) {
            cur.val = pq.peek();
            pq.poll();
            cur = cur.next;
        }
        return head;
    }
    public ListNode sortListByArrayListSort(ListNode head) {

        ListNode cur = head;
        List<Integer> arrayList = new ArrayList<>();
        while(cur != null) {
            arrayList.add(cur.val);
            cur = cur.next;
        }
        int i = 0;
        arrayList.sort(Comparator.naturalOrder());
        cur = head;
        while(cur != null) {
            cur.val = arrayList.get(i++);
            cur = cur.next;
        }
        return head;
    }
}
