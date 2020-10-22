package org.example.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class MinimumDepthByBFS {
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
    public int minVal;
    public int minDepth(TreeNode root) {
        if(root == null)
            return 0;
        minVal = bfs(root);

        return minVal;

    }

    public int bfs(TreeNode cur) {
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> depth = new LinkedList<>();
        queue.add(cur);
        depth.add(1);
        while(!queue.isEmpty()) {
            TreeNode curNode = queue.peek();
            Integer curDepth = depth.peek();
            queue.poll();
            depth.poll();

            if(curNode.left == null && curNode.right == null) {
                return curDepth;
            }
            if(curNode.left != null) {
                queue.add(curNode.left);
                depth.add(curDepth+1);
            }
            if(curNode.right != null){
                queue.add(curNode.right);
                depth.add(curDepth+1);
            }
        }
        return -1;
    }
}
