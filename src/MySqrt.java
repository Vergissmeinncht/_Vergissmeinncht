/*
给你一个非负整数 x ，计算并返回x的 算术平方根 。

由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去 。

注意：不允许使用任何内置指数函数和算符，例如 pow(x, 0.5) 或者 x ** 0.5 。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/sqrtx
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MySqrt {
    public int is(int num){
        int x = num;
        int i = 0;
        while(x>0) {
            x/=10;
            i++;
        }
        return i;
    }

    public int mySqrt(int x) {
        if(x==0){
            return 0;
        }
        int left = 1;
        int right = 1;
        int i = is(x)/2+1;
        while(i>0){
            right *= 10;
            i--;
        }
        if(right>46340){
            right=46340;
        }
        while(left<right){
            int mid = left+(right-left)/2;
            if(mid*mid<x&&(mid+1)*(mid+1)>x){
                return mid;
            }
            if(mid*mid<x){
                left=mid+1;
            }else {
                right=mid;
            }
        }
        return left;
    }
}
