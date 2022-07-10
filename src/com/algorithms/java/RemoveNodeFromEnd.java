package com.algorithms.java;

import java.util.List;

public class RemoveNodeFromEnd {
    public static void main (String[] args) {
        LinkList linkList = new LinkList() ;
        linkList.push(20);
        linkList.push(30);
        linkList.push(40);
        linkList.push(50);
        linkList.push(60);

        System.out.println("Linklist before removal");
        linkList.printLinkList();

        linkList.removeNthNodeFromLast(3);

        System.out.println("Linklist after removal of " + "2" + " node from the end");
        linkList.printLinkList();
    }

    static class LinkList {

        Node head ;

        class Node {
            int data ;
            Node next ;
            Node (int data) {
                this.data = data;
                this.next = null;
            }
        }

        /* inserts new Node at the front of the list */
        public void push (int newData) {
            /* 1 & 2: Allocate the Node &
                  Put in the data*/
            Node newNode = new Node(newData);

            /* 3. Make next of new Node as head */
            newNode.next = head ;

            /* 4. Move the head to point to new Node */
            head = newNode ;
        }

        public void removeNthNodeFromLast (int removeNode) {
            Node nthNodeFromStart = head;
            Node tempNode = head ;
            for (int i=0; i<removeNode; i++) {
                // If count of nodes in the given
                // linked list is <= removeNode
                if (nthNodeFromStart.next == null) {
                    // If i = removeNode-1 i.e. delete the head node
                    if (i == removeNode-1) {
                        head = head.next;
                    }
                    return;
                }
                nthNodeFromStart = nthNodeFromStart.next;
            }

            while (nthNodeFromStart.next!=null) {
                nthNodeFromStart = nthNodeFromStart.next;
                tempNode = tempNode.next;
            }
            tempNode.next = tempNode.next.next;
        }

        public void printLinkList () {
            int count = 1 ;
            Node tempNode = head ;
            while (tempNode != null) {
                System.out.println("node " + count + " = " + tempNode.data);
                count++;
                tempNode = tempNode.next ;
            }
        }

    }
}
