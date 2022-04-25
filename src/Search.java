/*给定一个n个元素有序的（升序）整型数组nums 和一个目标值target ，写一个函数搜索nums中的 target，如果目标值存在返回下标，否则返回 -1。
*/
public class Search {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        while(left<=right){
            if(nums[left]==target){
                return left;
            }else if(nums[right]==target){
                return right;
            }
            left++;
            right--;
        }
        return -1;
    }
}
