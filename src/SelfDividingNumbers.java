/*
自除数是指可以被它包含的每一位数整除的数。

例如，128 是一个 自除数 ，因为128 % 1 == 0，128 % 2 == 0，128 % 8 == 0。
自除数 不允许包含 0 。

给定两个整数left和right ，返回一个列表，列表的元素是范围[left, right]内所有的 自除数 。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/self-dividing-numbers
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
import java.util.ArrayList;
import java.util.List;

public class SelfDividingNumbers {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> ans = new ArrayList<>();
        while(left <= right) {
            if (self(left)) {
                ans.add(left);
            }
            left++;
        }
        return ans;
    }

    private boolean self(int i) {
        int num = i;
        while (num > 0) {
            int last = num % 10;
            if (last == 0 || i % last != 0)
                return false;
            num /= 10;
        }
        return true;
    }
}
