import java.util.ArrayList;

/**
 * 字符串转整数 (atoi) 实现 atoi，将字符串转为整数。
 * 该函数首先根据需要丢弃任意多的空格字符，直到找到第一个非空格字符为止。如果第一个非空字符是正号或负号，选取该符号，并将其与后面尽可能多的连续的数字组合起来，这部分字符即为整数的值。如果第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成整数。
 * 字符串可以在形成整数的字符后面包括多余的字符，这些字符可以被忽略，它们对于函数没有影响。
 * 当字符串中的第一个非空字符序列不是个有效的整数；或字符串为空；或字符串仅包含空白字符时，则不进行转换。 若函数不能执行有效的转换，返回 0。 说明：
 * 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231, 231 − 1]。如果数值超过可表示的范围，则返回 INT_MAX (231 −
 * 1) 或 INT_MIN (−231) 。
 * 
 * 示例 1: 输入: "42" 输出: 42
 * 
 * 示例 2: 输入: " -42" 输出: -42 解释: 第一个非空白字符为 '-', 它是一个负号。
 * 我们尽可能将负号与后面所有连续出现的数字组合起来，最后得到 -42 。
 * 
 * 示例 3: 输入: "4193 with words" 输出: 4193 解释: 转换截止于数字 '3' ，因为它的下一个字符不为数字。
 * 
 * 示例 4: 输入: "words and 987" 输出: 0 解释: 第一个非空字符是 'w', 但它不是数字或正、负号。 因此无法执行有效的转换。
 * 
 * 示例 5: 输入: "-91283472332" 输出: -2147483648 解释: 数字 "-91283472332" 超过 32
 * 位有符号整数范围。 因此返回 INT_MIN (−231) 。
 */
class Solution {

    private int convertToInteger(ArrayList<Character> nums) {
        // 除去开头无用的0
        //System.out.println(nums.size());
        int begin = (nums.get(0) =='+' || nums.get(0) =='-') ? 1 : 0;
        while(nums.size() > 1){
            if(nums.get(begin)=='0') nums.remove(begin);
            else break;
        }
        //System.out.println(nums.size());
        if (nums.size() == 0) return 0;


        int flag = nums.get(0);
        if(nums.get(0) == '+' && nums.size() > "+2147483647".length())return 2147483647;
        if(nums.get(0) == '-' && nums.size() > "-2147483648".length())return -2147483648;
        if(nums.get(0) >= '0' && nums.get(0) <= '9' && nums.size() > "2147483647".length())return 2147483647;
        if(nums.get(0) == '+' || nums.get(0)=='-') nums.remove(0);

        long pom = 1, result = 0;
        for (int i = nums.size() - 1; i >= 0; --i) {
            result += pom * (nums.get(i) - '0');
            pom *= 10;
        }
        if(flag=='-') result = 0 - result;
        if(result > Integer.MAX_VALUE)return Integer.MAX_VALUE;
        else if(result<Integer.MIN_VALUE) return Integer.MIN_VALUE;
        else{
            int x = (int)result;
            return x;
        }
    }

    public int myAtoi(String str) {
        // 删除头尾空白符的字符串
        str = str.trim();
        if (str.length() == 0) {
            return 0;
        }

        char[] x = str.toCharArray();
        ArrayList<Character> nums = new ArrayList<Character>();
        nums.add(x[0]);
        if ((x[0] >= '0' && x[0] <= '9') || x[0] == '+' || x[0] == '-') {
            for (int i = 1; i < x.length && (x[i] >= '0' && x[i] <= '9'); ++i) {
                nums.add(x[i]);
            }
            return this.convertToInteger(nums);
        } else
            return 0;
    }

}

public class MyAtoi {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.myAtoi("-00001"));
    }
}