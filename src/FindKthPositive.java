/*
给你一个 严格升序排列 的正整数数组 arr 和一个整数 k 。

请你找到这个数组里第 k 个缺失的正整数。
 */
public class FindKthPositive {
    public int findKthPositive(int[] arr, int k) {
        int left = 0;
        int right = arr.length - 1;
        if(arr[0] - 1 >= k) {
            return  k;
        }else {
            k = k -(arr[0] - 1);
        }
        while(left < right) {
            int mid = left +(right -left + 1)/2;
            int m = (arr[mid]-arr[left])-(mid-left);
            if( m < k) {
                left = mid;
                k -= m;
            }else {
                right = mid - 1;
            }
        }
        return arr[left] + k;
    }
}
