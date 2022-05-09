/*
给你一个二叉树的根节点 root ， 检查它是否轴对称。
 */
public class IsSymmetric {
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

    public boolean isSymmetric(TreeNode root) {
        if(root == null) {
            return true;
        }

        return isSymmetricSons(root.left,root.right);
    }

    public boolean isSymmetricSons(TreeNode left,TreeNode right) {
        if(left==null&&right==null) {
            return true;
        }
        if(left==null||right==null||left.val!=right.val){
            return false;
        }
        return isSymmetricSons(left.left,right.right)&&isSymmetricSons(left.right,right.left);
    }
}
