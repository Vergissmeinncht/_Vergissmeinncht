/*
给定一个二叉树的根节点 root ，返回 它的 中序 遍历 。
 */
import java.util.ArrayList;
import java.util.List;

public class InorderTraversal {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        list.addAll(0, inorderTraversal(root.left));
        list.add(root.val);
        list.addAll(list.size(), inorderTraversal(root.right));
        return list;
    }
}
