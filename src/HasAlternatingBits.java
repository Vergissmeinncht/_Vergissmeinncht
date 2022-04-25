/*
给定一个正整数，检查它的二进制表示是否总是 0、1 交替出现：换句话说，就是二进制表示中相邻两位的数字永不相同。
 */
public class HasAlternatingBits {
    public boolean hasAlternatingBits(int n) {
        int a;
        while(n>0) {
            a = n % 2;
            n /= 2;
            if(a==n%2){
                return false;
            }
        }
        return true;
    }
}
