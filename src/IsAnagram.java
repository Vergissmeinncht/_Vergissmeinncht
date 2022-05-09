import java.util.HashMap;
import java.util.Map;

public class IsAnagram {
    public boolean isAnagram(String s, String t) {
        char[] chars1 = s.toCharArray();
        char[] chars2 = t.toCharArray();
        Map<Character,Integer> map = new HashMap<>();
        for (char c : chars1) {
            if (map.containsKey(c)) {
                map.replace(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        for (char c : chars2) {
            if (map.containsKey(c)) {
                map.replace(c, map.get(c) - 1);
                if(map.get(c)==0) {
                    map.remove(c);
                }
            }else {
                return false;
            }
        }
        return map.isEmpty();
    }
}
