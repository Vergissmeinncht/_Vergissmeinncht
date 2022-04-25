/*
给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。

如果数组中不存在目标值 target，返回[-1, -1]。

进阶：

你可以设计并实现时间复杂度为O(log n)的算法解决此问题吗？

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SearchRange {
    public int[] searchRange(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        int[] ans = {-1,-1};
        if(nums.length<=0){
            return ans;
        }
        while(left<right){
            int mid = left + (right - left)/2;
            if(nums[mid]<target) {
                left = mid + 1;
            }else {
                right = mid;
            }
        }
        if(nums[left]==target){
            ans[0] = left;
        }else {
            return ans;
        }
        while(nums[left]==target&&left<nums.length-1){
            left++;
        }
        if(nums[left]>target){
            ans[1] = left -1;
        }else {
            ans[1] = left;
        }
        return ans;
    }
}
