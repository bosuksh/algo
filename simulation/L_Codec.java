package org.example.leetcode;

public class Codec {
    private static int index;
    private static String serializedString;
    public static void main(String[] args) {
        // Your Codec object will be instantiated and called as such:

        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);

        Codec ser = new Codec();
        Codec deser = new Codec();
        String tree = ser.serialize(root);
        System.out.println(tree);
        TreeNode ans = deser.deserialize(tree);
        System.out.println(ans.val);
        System.out.println(ans.left.val);
        System.out.println(ans.right.val);
    }
    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        String serializedString = "";
        serializedString = serializeDFS(root,serializedString);
        return serializedString;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] dataArray = data.split(",");
        if(dataArray.length == 1)
            return null;

        TreeNode treeNode = null;

        treeNode = deserializeDFS(treeNode,dataArray);
        return treeNode;
    }

    private String serializeDFS(TreeNode root, String serializedString) {
        if(root == null) {
            serializedString +="-1,";
            return serializedString;
        }
        serializedString += root.val+",";
        serializedString = serializeDFS(root.left,serializedString);
        serializedString = serializeDFS(root.right,serializedString);
        return serializedString;
    }

    private TreeNode deserializeDFS(TreeNode root, String[] dataArray) {
        if(dataArray[index].equals("-1")) {
            index++;
            return null;
        }
        root = new TreeNode(Integer.valueOf(dataArray[index++]));
        root.left = deserializeDFS(root.left,dataArray);
        root.right = deserializeDFS(root.right,dataArray);
        return root;
    }
}
