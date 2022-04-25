/*
给你一个大小为m* n的矩阵mat，矩阵由若干军人和平民组成，分别用 1 和 0 表示。

请你返回矩阵中战斗力最弱的k行的索引，按从最弱到最强排序。

如果第i行的军人数量少于第j行，或者两行军人数量相同但 i 小于 j，那么我们认为第 i 行的战斗力比第 j 行弱。

军人 总是 排在一行中的靠前位置，也就是说 1 总是出现在 0 之前。


来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/the-k-weakest-rows-in-a-matrix
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KWeakestRows {
    public int[] kWeakestRows(int[][] mat, int k) {
        int[] nums = new int[k];
        int[] arr = new int[mat.length];
        List<Integer> list = new ArrayList<>();
        for(int i = 0;i<mat.length;i++){
            arr[i]=kWeakesNumber(mat[i]);
        }
        Arrays.sort(arr);
        for(int i = 0;i < k;i++) {
            for(int j = 0;j<mat.length;j++) {
                if(!list.contains(j)){
                    if(arr[i]==kWeakesNumber(mat[j])){
                        list.add(j);
                        break;
                    }
                }
            }
        }
        for (int i = 0;i<k;i++){
            nums[i] = list.get(i);
        }
        return nums;
    }

    public int kWeakesNumber(int[] row) {
        int left = 0;
        int right = row.length - 1;
        if(row[right]==1){
            return row.length;
        }
        int mid;
        while(left < right) {
            mid = left + (right - left)/2;
            if(row[mid]==1) {
                left = mid+1;
            }else {
                right = mid;
            }
        }
        return left;
    }
}
