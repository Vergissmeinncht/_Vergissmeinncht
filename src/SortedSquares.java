/*
给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
 */
public class SortedSquares {
    public int[] sortedSquares(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        int index = nums.length-1;
        int[] ans = new int[nums.length];
        while(left<=right){
            if(nums[left]*nums[left]>nums[right]*nums[right]){
                ans[index] = nums[left]*nums[left];
                left++;
                index--;
            }else {
                ans[index] = nums[right]*nums[right];
                right--;
                index--;
            }
        }
        return ans;
    }
}
