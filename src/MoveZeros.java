/*
给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。

请注意 ，必须在不复制数组的情况下原地对数组进行操作。
 */
public class MoveZeros {
    public void moveZeroes(int[] nums) {
        int i = 0;
        while(i<nums.length&&nums[i]!=0){
            i++;
        }
        for(int j = i+1;j<nums.length;j++){
            if(nums[j] != 0) {
                nums[i] = nums[j];
                nums[j] = 0;
                i++;
            }
        }
    }
}
