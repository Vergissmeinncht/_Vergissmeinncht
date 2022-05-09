/*
给定一个正整数 n ，输出外观数列的第 n 项。

「外观数列」是一个整数序列，从数字 1 开始，序列中的每一项都是对前一项的描述。

你可以将其视作是由递归公式定义的数字字符串序列：

countAndSay(1) = "1"
countAndSay(n) 是对 countAndSay(n-1) 的描述，然后转换成另一个数字字符串。

作者：力扣 (LeetCode)
链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xnpvdm/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class CountAndSay {
    public String countAndSay(int n) {
        String ans = "1";
        while(n-1>0) {
            ans = andSay(ans);
            n--;
        }
        return ans;
    }

    public String andSay(String ans) {
        int count = 0;
        String a;
        String b;
        String s = " ";
        char[] chars = ans.toCharArray();
        char c= chars[0];
        for(int i = 0;i<chars.length;i++) {
            if(chars[i]==c) {
                count++;
            }else {
                a = String.valueOf(count);
                b = String.valueOf(c);
                s = s.concat(a+b);
                c=chars[i];
                count=1;
            }
        }
        a = String.valueOf(count);
        b = String.valueOf(c);
        s = s.concat(a+b);
        return s;
    }
}
