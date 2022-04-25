/*
给你一个数组，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
 */
public class Rotate {
    public void rotate(int[] nums, int k) {
        int r = k%nums.length;
        sort(nums,0,nums.length-r-1);
        sort(nums,nums.length-r,nums.length-1);
        sort(nums,0,nums.length-1);
    }

    public void sort(int[] nums,int left,int right) {
        int temp = 0;
        while(left<right) {
            temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }
}
