/**
 * 最接近的三数之和
 * 
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target
 * 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 * 
 * 例如，给定数组 nums = [-1，2，1，-4], 和 target = 1. 与 target 最接近的三个数的和为 2. (-1 + 2 + 1
 * = 2).
 */

import java.util.Arrays;

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums); // 先排序
        int SUM = target;
        int dis = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length-2; ++i) {
            int l = i + 1, r = nums.length - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum > target) {
                    --r;
                    if (sum - target < dis){
                        SUM = sum;
                        dis = sum - target;
                    }
                } else if (sum < target) {
                    ++l;
                    if (target - sum < dis){
                        SUM = sum;
                        dis = target - sum;
                    }
                } else
                    return target;
            }
        }
        return SUM;
    }
}

public class ThreeSumClosest {
    public static void main(String[] args) {
        Solution s = new Solution();
        int [] x = {-1, 2, 1, -4};
        System.out.println(s.threeSumClosest(x, 1));
    }
}