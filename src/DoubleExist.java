/*
给你一个整数数组arr，请你检查是否存在两个整数N 和 M，满足N是M的两倍（即，N = 2 * M）。

更正式地，检查是否存在两个下标i 和 j 满足：

i != j
0 <= i, j < arr.length
arr[i] == 2 * arr[j]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/check-if-n-and-its-double-exist
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
import java.util.HashMap;
import java.util.Map;

class DoubleExist {
    public boolean checkIfExist(int[] arr) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0;i<arr.length;i++){
            map.put(arr[i],i);
        }
        for (int j = 0;j<arr.length;j++) {
            if(map.containsKey(2*arr[j])&&j!=map.get(2*arr[j])){
                return true;
            }
        }
        return false;
    }
}
