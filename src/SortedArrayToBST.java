/*
给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 高度平衡 二叉搜索树。

高度平衡 二叉树是一棵满足「每个节点的左右两个子树的高度差的绝对值不超过 1 」的二叉树。

作者：力扣 (LeetCode)
链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xninbt/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class SortedArrayToBST {
    public static class TreeNode {
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
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length==0) {
            return null;
        }
        return sortedArrayTo(nums,0,nums.length-1);
    }

    public TreeNode sortedArrayTo(int[] nums,int begin,int end) {
        if(end<begin) {
            return null;
        }
        TreeNode root = new TreeNode();
        root.val = nums[(begin+end)/2];
        root.left = sortedArrayTo(nums,begin,(begin+end)/2-1);
        root.right = sortedArrayTo(nums,(begin+end)/2+1,end);
        return root;
    }
}
