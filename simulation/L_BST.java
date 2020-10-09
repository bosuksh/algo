package org.example.leetcode;

public class BST {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode curNode = root;
        TreeNode parentNode = root;
        if(curNode == null) {
            return new TreeNode(val);
        }
        while(curNode != null) {
            parentNode = curNode;
            if(curNode.val > val) {
                curNode = curNode.left;
            }else {
                curNode = curNode.right;
            }
        }
        if(parentNode.val > val) {
            parentNode.left = new TreeNode(val);
        }else {
            parentNode.right = new TreeNode(val);
        }
        return root;
    }
}
