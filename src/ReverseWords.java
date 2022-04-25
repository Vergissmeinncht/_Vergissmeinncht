/*
给定一个字符串 s ，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
 */
public class ReverseWords {
    public String reverseWords(String s) {
        char[] arr = s.toCharArray();
        int i = 0;
        int j = 1;
        while(j< arr.length) {
            if(arr[j] == ' ') {
                reverseString(arr,i,j-1);
                i = j+1;
            }
            j++;
        }
        reverseString(arr,i,j-1);
        return new String(arr);
    }

    public void reverseString(char[] s,int left,int right) {
        char temp = ' ';
        while(left<right) {
            temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }
}
