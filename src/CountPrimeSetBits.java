/*
给你两个整数left和right ，在闭区间 [left, right]范围内，统计并返回 计算置位位数为质数 的整数个数。

计算置位位数 就是二进制表示中 1 的个数。

例如， 21的二进制表示10101有 3 个计算置位

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/prime-number-of-set-bits-in-binary-representation
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CountPrimeSetBits {
    public int countPrimeSetBits(int L, int R) {
        int res = 0;
        for (int i = L; i <= R; i++) {
            res += 665772 >> Integer.bitCount(i) & 1;//665772二进制上的1为所有质数的二进制。
        }
        return res;
    }
}
