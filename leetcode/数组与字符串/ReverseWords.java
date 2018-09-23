/**
 * 
 * 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
 * 
 * 示例 1: 输入: "Let's take LeetCode contest" 输出: "s'teL ekat edoCteeL tsetnoc"
 * 
 * 注意：在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。
 */
class Solution {
    // reverse a string without space.
    private String reverseString(String s) {
        char[] c = s.toCharArray();
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (c[i] != c[j]) {
                c[i] ^= c[j];
                c[j] ^= c[i];
                c[i] ^= c[j];
            }
            ++i;
            --j;
        }
        return new String(c);
    }
    // reverse the order of characters in each word within a sentence
    public String reverseWords(String s) {
        String[] x = s.split(" ");
        StringBuilder sb = new StringBuilder(x.length * 2 - 1);
        sb.append(this.reverseString(x[0]));
        for (int i = 1; i < x.length; ++i) {
            sb.append(" ");
            sb.append(this.reverseString(x[i]));
        }
        return sb.toString();
    }
}

public class ReverseWords {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.reverseWords("hi hey"));
    }
}