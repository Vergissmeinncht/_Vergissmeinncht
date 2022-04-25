/*
给定一个 正整数 num ，编写一个函数，如果 num 是一个完全平方数，则返回 true ，否则返回 false 。

进阶：不要 使用任何内置的库函数，如 sqrt 。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/valid-perfect-square
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class IsPerfectSquare {
    public int is(int num){
        int x = num;
        int i = 0;
        while(x>0) {
            x/=10;
            i++;
        }
        return i;
    }

    public boolean isPerfectSquare(int num) {
        int left = 1;
        int right = 1;
        int i = is(num)/2+1;
        while(i>0){
            right *= 10;
            i--;
        }
        if(right>46340){
            right=46340;
        }
        while(left<right){
            int mid = left+(right-left)/2;
            if(mid*mid<num){
                left=mid+1;
            }else {
                right=mid;
            }
        }
        return left * left == num;
    }
}
