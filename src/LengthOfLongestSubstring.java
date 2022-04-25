/*
给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度
 */
import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        char[] arr = s.toCharArray();
        if(arr.length==0){
            return 0;
        }
        int leg = 0;
        int p1 = 0;
        Map<Character,Integer> map = new HashMap<>();
        for(int i = 0;i<arr.length;i++) {
            if(!map.containsKey(arr[i])){
                map.put(arr[i],i);
            }else {
                leg = Math.max(i-p1,leg);
                p1 = Math.max(p1,map.get(arr[i])+1);
                map.replace(arr[i],i);
            }
        }
        if(arr[p1]==arr[arr.length-1]&&p1!=arr.length-1){
            p1=arr.length-1;
        }
        leg = Math.max(arr.length-p1,leg);
        return leg;
    }
}
