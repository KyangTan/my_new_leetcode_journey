package com.my_new_leetcode_journey.linked_list;

public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode newHead = head;

        if (head.next != null) {
            newHead = reverseList(head.next);
            head.next.next = head;
        }

        head.next = null;

        return newHead;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
