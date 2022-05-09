/*
给你两个整数数组nums1 和 nums2 ，请你以数组形式返回两数组的交集。返回结果中每个元素出现的次数，应与元素在两个数组中都出现的次数一致（如果出现次数不一致，则考虑取较小值）。可以不考虑输出结果的顺序。


作者：力扣 (LeetCode)
链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x2y0c2/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Intersect {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer,Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for (int j : nums1) {
            if (!map.containsKey(j)) {
                map.put(j, 1);
            } else {
                map.replace(j, map.get(j) + 1);
            }
        }
        for(int num:nums2) {
            if(map.containsKey(num)) {
                map.replace(num,map.get(num)-1);
                list.add(num);
                if(map.get(num)==0) {
                    map.remove(num);
                }
            }
        }
        int[] ans = new int[list.size()];
        for (int i = 0;i<list.size();i++){
            ans[i] = list.get(i);
        }
        return ans;
    }
}
