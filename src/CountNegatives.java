/*
给你一个 m * n 的矩阵 grid，矩阵中的元素无论是按行还是按列，都以非递增顺序排列。 请你统计并返回 grid 中 负数 的数目。
 */
public class CountNegatives {
    public int left = 0;
    public int right = 0;
    public int mid = 0;
    public int countNegatives(int[][] grid) {
        int ans = 0;
        for (int[] nums:grid){
            ans += count(nums);
        }
        return ans;
    }

    public int count(int[] nums) {
        left = 0;
        right = nums.length - 1;
        while(left < right) {
            mid = left + (right -left)/2;
            if(nums[mid] < 0) {
                right = mid;
            }else {
                left = mid + 1;
            }
        }
        if(nums[left]>= 0) {
            return 0;
        }
        return nums.length - left;
    }
}
