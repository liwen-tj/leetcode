/**
 * 字符串相乘
 * 
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 * 
 * 示例 1: 输入: num1 = "2", num2 = "3" 输出: "6"
 * 
 * 示例 2: 输入: num1 = "123", num2 = "456" 输出: "56088"
 * 
 * 说明： num1 和 num2 的长度小于110。 num1 和 num2 只包含数字 0-9。 num1 和 num2 均不以零开头，除非是数字 0
 * 本身。 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。
 */

class Solution {
    // 高精度乘法
    public String multiply(String num1, String num2) {
        char[] nums1 = num1.toCharArray();
        char[] nums2 = num2.toCharArray();
        int n = nums1.length, m = nums2.length, i, j, k;
        // 一般来说两个数相乘，其最大位数也不会大于2个乘数位数之和
        int[] result = new int[n + m];
        // 转换成数字
        for (i = 0; i < n; i++)
            nums1[i] -= '0';
        for (i = 0; i < m; i++)
            nums2[i] -= '0';

        // 用nums2的每一位去乘nums1 累加到result
        for (i = 0; i < m; i++) {
            int carry = 0;
            for (j = 0; j < n; j++) {
                result[i + j] = result[i + j] + nums2[m - 1 - i] * nums1[n - 1 - j] + carry;
                carry = result[i + j] / 10;
                result[i + j] %= 10;
            }
            k = i + j;
            // 处理进位
            while (carry != 0) {
                result[k] += carry;
                carry = result[k] / 10;
                result[k] %= 10;
                k++;
            }
        }

        StringBuilder tmp = new StringBuilder(n + m);
        i = m + n - 1;
        while (i > 0 && result[i] == 0)
            i--;
        while (i >= 0)
            tmp.append(result[i--]);
        return tmp.toString();
    }
}

public class Multiply {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.multiply("123", "100"));
    }
}