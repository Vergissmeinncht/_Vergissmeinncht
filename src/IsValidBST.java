import java.util.Stack;

/*
给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。

有效 二叉搜索树定义如下：

节点的左子树只包含 小于 当前节点的数。
节点的右子树只包含 大于 当前节点的数。
所有左子树和右子树自身必须也是二叉搜索树。

作者：力扣 (LeetCode)
链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xn08xg/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class IsValidBST {
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

    public boolean isValidBST(TreeNode root) {
        return isValidBST(root,-(Math.pow(2,31)+1),Math.pow(2,31));
    }

    public boolean isValidBST(TreeNode root,double minValue,double maxValue) {
        if(root==null) {
            return true;
        }
        if(root.val<=minValue||root.val>=maxValue) {
            return false;
        }
        return isValidBST(root.left,minValue,root.val)&&isValidBST(root.right, root.val, maxValue);
    }
}
