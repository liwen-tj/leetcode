/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为1000。
 * 
 * 示例 1： 输入: "babad" 输出: "bab" 注意: "aba"也是一个有效答案。 示例 2： 输入: "cbbd" 输出: "bb"
 */
class Solution {
    public String longestPalindrome(String s) {
        // 空串直接返回
        if (s.length() == 0) {
            return s;
        }
        // 加入#号
        char[] Ma = String.join("#", s.split("")).toCharArray();
        int MaxExt = 0; // 记录最长单向扩展长度
        int MaxLength = 1; // 有效回文串的长度
        int index = 0; // 最长回文串的中心索引

        int B = Ma.length;
        for (int i = 0; i < B; ++i) {
            int ext = 1;
            while (i + ext < B && i - ext >= 0) {
                if (Ma[i + ext] == Ma[i - ext]) {
                    ext += 1;
                } else {
                    break;
                }
            }
            ext = ext - 1;
            int vaildLength;
            if (Ma[i] == '#') {
                vaildLength = ((ext + 1) / 2) * 2;
            } else {
                vaildLength = (ext / 2) * 2 + 1;
            }
            if (vaildLength > MaxLength) {
                MaxLength = vaildLength;
                MaxExt = ext;
                index = i;
            }
        }

        // 返回结果
        int begin = index - MaxExt;
        int end = index + MaxExt;
        if (Ma[begin] == '#') {
            char[] results = new char[MaxExt];
            int id = 0;
            for (int i = begin + 1; i <= end; i += 2) {
                results[id] = Ma[i];
                id += 1;
            }
            return new String(results);
        } else {
            char[] results = new char[MaxExt + 1];
            int id = 0;
            for (int i = begin; i <= end; i += 2) {
                results[id] = Ma[i];
                id += 1;
            }
            return new String(results);
        }
    }
}

public class LongestPalindrome {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.longestPalindrome("cbbd"));
    }
}
