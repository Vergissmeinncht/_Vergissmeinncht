import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class FristUniqChar {
    public int firstUniqChar(String s) {
        char[] arr = s.toCharArray();
        Map<Character,Integer> map = new HashMap<>();
        for (char c : arr) {
            if (map.containsKey(c)) {
                map.replace(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        for (int i = 0;i<arr.length;i++) {
            if(map.get(arr[i])==1) {
                return i;
            }
        }
        return -1;
    }
}
