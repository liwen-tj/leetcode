import java.util.HashMap;

/**
 * 给定一个整数数组和一个目标值，找出数组中和为目标值的两个数。 你可以假设每个输入只对应一种答案，且同样的元素不能被重复利用。
 * 
 * 示例: 给定 nums = [2, 7, 11, 15], target = 9 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 * 
 */

class Solution {
  public int[] twoSum(int[] nums, int target) {
    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    for (int i = 0; i < nums.length; ++i) {
      int sub = target - nums[i]; // 还需要的另一个数字
      if (map.containsKey(sub)) { // 找到匹配的另一个数字
        int[] results = { map.get(sub), i };
        return results;
      } else {
        map.put(nums[i], i);
      }
    }

    // 没有找到这样的两个数
    int[] results = { 0, 0 };
    return results;
  }
}

public class TwoSum {
  public static void main(String[] args) {
    int[] nums = { 1, 2, 3, 4 };
    int target = 5;

    Solution s = new Solution();
    int[] results = s.twoSum(nums, target);

    System.out.println(results[0]);
    System.out.println(results[1]);
  }
}