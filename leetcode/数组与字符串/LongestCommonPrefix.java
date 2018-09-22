/**
 * 最长公共前缀
 * 
 * 编写一个函数来查找字符串数组中的最长公共前缀。 如果不存在公共前缀，返回空字符串 ""。
 * 
 * 示例 1: 输入: ["flower","flow","flight"] 输出: "fl"
 * 
 * 示例 2: 输入: ["dog","racecar","car"] 输出: "" 解释: 输入不存在公共前缀。 说明:
 * 
 * 所有输入只包含小写字母 a-z 。
 */
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0)
            return "";
        String result = "";
        int n = strs.length, min_length = Integer.MAX_VALUE;
        for (int i = 0; i < n; ++i)
            min_length = Math.min(min_length, strs[i].length());
        for (int i = 0; i < min_length; ++i) {
            char x = strs[0].charAt(i);
            int j = 1;
            for (; j < n; ++j) {
                if (strs[j].charAt(i) != x)
                    break;
            }
            if (j == n)
                result += String.valueOf(x);
            else
                break;
        }
        return result;
    }
}

public class LongestCommonPrefix {
    public static void main(String[] args) {
        Solution s = new Solution();
        String [] strs = {"", "flow", "flight"};
        String x = s.longestCommonPrefix(strs);
        System.out.println(x);
    }
}