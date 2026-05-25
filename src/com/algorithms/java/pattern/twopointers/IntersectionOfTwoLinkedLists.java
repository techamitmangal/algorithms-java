package com.algorithms.java.pattern.twopointers;


/*

Given the heads of two singly linked-lists headA and headB, return the node at which the two lists intersect.
If the two linked lists have no intersection at all, return null.

Note: Linked lists intersect if they share a common node in memory, not just a node with the same value.


Constraints:

The number of nodes of listA is in the m.
The number of nodes of listB is in the n.
1 < node.val ≤ 100000
Follow up: Could you write a solution that runs in O(m + n) time and use only O(1) memory?

 */

import java.util.List;

 class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}

public class IntersectionOfTwoLinkedLists {

    public static void main (String[] args) {
        // Common intersection part
        ListNode common = new ListNode(8);
        common.next = new ListNode(4);
        common.next.next = new ListNode(5);

        // List A: 4 -> 1 -> 8 -> 4 -> 5
        ListNode headA = new ListNode(4);
        headA.next = new ListNode(1);
        headA.next.next = common;

        // List B: 5 -> 6 -> 1 -> 8 -> 4 -> 5
        ListNode headB = new ListNode(5);
        headB.next = new ListNode(6);
        headB.next.next = new ListNode(1);
        headB.next.next.next = common;
        if (getIntersectionNode(headA, headB) == null) {
            System.out.println("Intersection Not found" );
        } else {
            System.out.println("Intersection Exists at node = " );
        }
    }

    static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode pointerOne = headA ;
        ListNode pointerTwo = headB;
        while (pointerOne != pointerTwo) {
            pointerOne = (pointerOne == null) ? headB : pointerOne.next;
            pointerTwo = (pointerTwo == null) ? headA : pointerTwo.next;
        }
        return pointerOne;
    }
}
