/*
编写一个高效的算法来判断m x n矩阵中，是否存在一个目标值。该矩阵具有如下特性：

每行中的整数从左到右按升序排列。
每行的第一个整数大于前一行的最后一个整数。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/search-a-2d-matrix
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SeachMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int a = 0;
        int b = matrix.length - 1;
        while(a < b) {
            int mid = a + (b - a)/2;
            if(matrix[mid][0]>target) {
                b = mid;
            }else if(matrix[mid][matrix[mid].length-1] < target) {
                a = mid + 1;
            }else {
                return searchMat(matrix[mid],target);
            }
        }
        return searchMat(matrix[a],target);
    }

    public boolean searchMat(int[] nums,int target) {
        int left = 0;
        int right = nums.length - 1;
        while(left<right) {
            int mid = left + (right - left)/2;
            if(nums[mid] < target) {
                left = mid + 1;
            }else {
                right = mid;
            }
        }
        return nums[left] == target;
    }
}
