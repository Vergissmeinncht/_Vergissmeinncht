import java.util.*;

public class Solution {
    public long minSum(int[] nums1, int[] nums2) {
        int count1 = 0;
        int count2 = 0;
        long sum1 = 0;
        long sum2 = 0;
        for(int x:nums1){
            if(x==0){
                count1+=1;
            }
            sum1+= x;
        }
        for(int x:nums2){
            if(x==0){
                count2+=1;
            }
            sum2+= x;
        }
        sum1+=count1;
        sum2+=count2;
        if((sum1<sum2&&count1==0)||(sum1>sum2&&count2==0)){
            return -1;
        }
        return Math.max(sum1,sum2);
    }
}
