package com.algorithms.java.leetcode;

public class MorrisTraversal {

    public static class Node {
        int data;
        Node left, right;
    }

    public static Node newNode (int data) {
        Node tempNode = new Node();
        tempNode.data = data;
        tempNode.left = null;
        tempNode.right = null;
        return tempNode;
    }

    public static void main (String[] args) {
        Node root = newNode(50);
        root.left = newNode(40);
        root.right = newNode(60);
        root.left.left = newNode(30);
        root.left.right = newNode(35);
    }
}
