/*
 In this solution, we are maintaining two pointers pointerP and pointerQ, initialized to 
 the node P and Q respectively. Then we keep traversing the tree upwards towards the root 
 of the tree using the parent reference in each node.
When pointerP reaches the root, then we will redirect it to the node Q. Similarly when 
pointerQ reaches the root, then we will redirect it to the node P. If at any point 
pointerP == pointerQ, then pointerP or pointerQ is the Lowest Common Ancestor (LCA) of 
node P and Q.
Let us consider the following binary tree that fulfills all the given constraints.
          3
         /
        5
         \
          2
           \
            4
Root Node = 3, P = 5, Q = 4
Path from node P to root: 5 -> 3
Path from Node Q to root: 4 -> 2 -> 5 -> 3
In this case, pointerP will reach the root node first, as it's closer to the root node and
 thus has to travel less distance. But pointerQ will take three hops to reach the root node. 
The difference in depth of both the nodes is two. By redirecting the pointerP to node Q,
and pointerQ to node P, we are making pointerP travel two extra hops and pointerQ travel 
two fewer hops. Thus they end up traveling the same number of hops and are guaranteed to 
reach the lowest common node at the same time. 
Total number of hops required to find the LCA = Depth of P + Depth of Q - Depth of 
LCA node.
Time Complexity = O(depthP + depthQ - depthLCA)
depthP -> Depth of the Node p
depthQ -> Depth of the Node q
depthLCA -> Depth of the LCA
Space Complexity = O(1)
We are using constant space in this solution.

*/


package com.algorithms.java.leetcode.pattern.twopointers;

// Simple Node structure with parent pointer only
class Node {
    int val;
    Node parent;

    Node (int val) {
        this.val = val;
    }
}

public class LowestCommonAncestor {

    public static Node lowestCommonAncestorWithTwoPointers (Node p, Node q) {
        // PointerP starts at p, pointerQ starts at q
        Node pointerP = p;
        Node pointerQ = q;

        /**
         * LOOP LOGIC:
         *
         * - If pointerP reaches null (past root), jump it to pointerQ
         * - If pointerQ reaches null (past root), jump it to pointerP
         *
         * Why this works:
         * ----------------------------------------
         * Both pointers walk EXACTLY the same total distance.
         *
         * Example:
         *   pointerP path length = 10
         *   pointerQ path length = 6
         *
         * After switching:
         *   pointerP walks: 10 (p to root) + 6 (q to root) = 16 steps
         *   pointerQ walks: 6  (q to root) + 10 (p to root) = 16 steps
         *
         * When distances equal → they meet exactly at LCA.
         */

        while (pointerP != pointerQ) {
            pointerP = (pointerP == null) ? q : pointerP.parent;
            pointerQ = (pointerQ == null) ? p : pointerQ.parent;
        }
        return pointerP;
    }

    public static void main (String[] args) {
        Node root = new Node(1);
        Node a = new Node(2);
        Node b = new Node(3);
        Node c = new Node(4);
        Node d = new Node(5);

        // Constructing parent pointers
        a.parent = root;
        b.parent = root;
        c.parent = a;
        d.parent = a;

        // Find LCA of c & d
        Node lca = lowestCommonAncestorWithTwoPointers(c, d);
        System.out.println("LCA of Node " + c.val + " and Node " + d.val + " is Node " + lca.val);

    }
}
