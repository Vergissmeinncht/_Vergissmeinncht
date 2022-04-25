/*
给你一个非负整数数组 nums 。如果存在一个数 x ，使得 nums 中恰好有 x 个元素 大于或者等于 x ，那么就称 nums 是一个 特殊数组 ，而 x 是该数组的 特征值 。

注意： x 不必 是 nums 的中的元素。

如果数组 nums 是一个 特殊数组 ，请返回它的特征值 x 。否则，返回 -1 。可以证明的是，如果 nums 是特殊数组，那么其特征值 x 是 唯一的 。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/special-array-with-x-elements-greater-than-or-equal-x
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SpecialArray {
    public int specialArray(int[] nums) {
        int left = 0;
        int right = nums.length;
        while(left < right) {
            int mid = left + (right - left )/2;
            if(mid < bigger(nums,mid)) {
                left = mid + 1;
            }else {
                right = mid;
            }
        }
        if(left != bigger(nums,left)) {
            return -1;
        }
        return left;
    }

    public int bigger(int[] nums,int k) {
        int n = 0;
        for(int num:nums) {
            if(num >= k) {
                n++;
            }
        }
        return n;
    }
}
