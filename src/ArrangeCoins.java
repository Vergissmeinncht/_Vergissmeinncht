/*
你总共有n枚硬币，并计划将它们按阶梯状排列。对于一个由 k 行组成的阶梯，其第 i 行必须正好有 i 枚硬币。阶梯的最后一行 可能 是不完整的。

给你一个数字n ，计算并返回可形成 完整阶梯行 的总行数。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/arranging-coins
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ArrangeCoins {
    public int arrangeCoins(int n) {
        int left = 1;
        int right = n;
        while(left<right) {
            int mid = left + (right - left+1)/2;
            if((long) mid*(mid+1) <= (long) 2*n) {
                left = mid;
            }else {
                right = mid - 1;
            }
        }
        return left;
    }
}
