import java.util.HashMap;
import java.util.Stack;

/**
 * 有效的括号
 * 
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * 
 * 有效字符串需满足： 左括号必须用相同类型的右括号闭合。 左括号必须以正确的顺序闭合。 注意空字符串可被认为是有效字符串。
 * 
 * 示例 1: 输入: "()" 输出: true
 * 
 * 示例 2: 输入: "()[]{}" 输出: true
 * 
 * 示例 3: 输入: "(]" 输出: false
 * 
 * 示例 4: 输入: "([)]" 输出: false
 * 
 * 示例 5: 输入: "{[]}" 输出: true
 */
class Solution {
    public boolean isValid(String s) {
        if (s == "")
            return true;

        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('(', -3);
        map.put(')', 3);
        map.put('[', -2);
        map.put(']', 2);
        map.put('{', -1);
        map.put('}', 1);

        int len = s.length();
        Stack<Character> st = new Stack<Character>();
        for (int i = 0; i < len; ++i) {
            if (st.empty() || map.get(s.charAt(i)) < 0) { // 不可消除
                st.push(s.charAt(i));
            } else {
                if (map.get(st.peek()) + map.get(s.charAt(i)) == 0)
                    st.pop();
                else
                    st.push(s.charAt(i));
            }
        }
        return st.empty();
    }
}

public class IsValid {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.isValid("[({}]"));
    }
}