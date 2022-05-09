import java.util.Arrays;

/*
给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。

最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。

你可以假设除了整数 0 之外，这个整数不会以零开头。


作者：力扣 (LeetCode)
链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x2cv1c/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class PlusOne {
    public int[] plusOne(int[] digits){
        int i = digits.length - 1;
        digits[i] = digits[i] + 1;
        for(;i>=0;i--) {
            if(digits[i] < 10||i==0) {
                break;
            }else {
                digits[i] = 0;
                digits[i-1] = digits[i-1]+1;
            }
        }
        if(digits[0] >= 10) {
            int[] ans = new int[digits.length+1];
            ans[0] = 1;
            ans[1] = 0;
            if(digits.length>1){
                System.arraycopy(digits, 1, ans, 2, digits.length - 1);
            }
            return ans;
        }
        return digits;
    }
}
