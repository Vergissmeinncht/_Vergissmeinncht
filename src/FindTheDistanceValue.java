/*
给你两个整数数组arr1，arr2和一个整数d，请你返回两个数组之间的距离值。

「距离值」定义为符合此距离要求的元素数目：对于元素arr1[i]，不存在任何元素arr2[j]满足 |arr1[i]-arr2[j]| <= d 。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/find-the-distance-value-between-two-arrays
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindTheDistanceValue {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int ans = 0;
        for (int x:arr1) {
            if(isDistanceValue(x,arr2,d)){
                ans++;
            }
        }
        return ans;
    }

    public boolean isDistanceValue(int x,int[] arr,int d) {
        for(int y: arr) {
            if(Math.abs(x-y) <= d){
                return false;
            }
        }
        return true;
    }
}
