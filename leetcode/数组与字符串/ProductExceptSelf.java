/**
 * 除自身以外数组的乘积
 * 
 * 给定长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，其中 output[i] 等于 nums 中除 nums[i]
 * 之外其余各元素的乘积。
 * 
 * 示例: 输入: [1,2,3,4] 输出: [24,12,8,6] 说明: 请不要使用除法，且在 O(n) 时间复杂度内完成此题。
 * 
 * 进阶： 你可以在常数空间复杂度内完成这个题目吗？（ 出于对空间复杂度分析的目的，输出数组不被视为额外空间。）
 */
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        // 之前的乘积
        int[] pre = new int[len];
        pre[0] = 1;
        for (int i = 1; i < len; ++i) {
            pre[i] = pre[i - 1] * nums[i - 1];
        }
        // 之后的乘积
        int[] aft = new int[len];
        aft[len - 1] = 1;
        for (int i = len - 2; i >= 0; --i) {
            aft[i] = aft[i + 1] * nums[i + 1];
        }

        int[] result = new int[len];
        for (int i = 0; i < len; ++i) {
            result[i] = pre[i] * aft[i];
        }
        return result;
    }
}

public class ProductExceptSelf {
    public static void main(String[] args) {
        Solution s = new Solution();
        int x[] = { 1, 2, 3, 4 };
        int y[] = s.productExceptSelf(x);
        for (int m : y) {
            System.out.println(m);
        }
    }
}