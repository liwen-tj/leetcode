/**
 * 反转字符串 编写一个函数，其作用是将输入的字符串反转过来。
 */
// 基本解法： 战胜20.24%
// class Solution {
//     public String reverseString(String s) {
//         int length = s.length();
//         char[] array = s.toCharArray();
//         for (int i = 0; i < length; i++) {
//             array[i] = s.charAt(length - 1 - i);
//         }
//         return new String(array);
//     }
// }

// 逆序遍历 战胜 47.78%
// class Solution {
//     public String reverseString(String s) {
//         int length = s.length();
//         StringBuilder sb = new StringBuilder();
//         for(int i = length-1; i>=0; i--){
//             sb.append(s.charAt(i));
//         }
//         return sb.toString();
//     }
// }

// 遍历次数减半： 战胜74.94%
// class Solution {
//     public String reverseString(String s) {
//         int length = s.length();
//         char[] array = s.toCharArray();
//         for (int i = 0; i < length / 2; i++) {
//             array[i] = s.charAt(length - 1 - i);
//             array[length-1-i] = s.charAt(i);
//         }
//         return new String(array);
//     }
// }

// 太精彩了，不仅想到可以遍历次数减半，还能想到用异或运算直接交换，既节省空间，又非常高效
class Solution {
    public String reverseString(String s) {
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
}

public class ReverseString {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.reverseString("hi hey"));
        ;
    }
}