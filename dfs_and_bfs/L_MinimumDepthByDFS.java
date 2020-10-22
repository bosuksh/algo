package org.example.leetcode;

public class MinimumDepthByDFS {
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
        minVal = -1;
        dfs(root,1);
        return minVal;

    }

    public void dfs(TreeNode cur, int depth) {
        if(cur.left == null && cur.right == null)  {
            if(minVal == -1) {
                minVal = depth;
                return;
            }
            if(minVal > depth)
                minVal = depth;
            return;
        }
        if(cur.left != null){
            dfs(cur.left , depth+1);
        }
        if(cur.right != null) {
            dfs(cur.right, depth+1);
        }

    }
}
