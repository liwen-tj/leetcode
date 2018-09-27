import java.util.Arrays;

class Solution {
    // --------------- naive me ---------------
    // public int majorityElement(int[] nums) {
    //     int len = nums.length;
    //     int times = len / 2;
    //     Arrays.sort(nums);
    //     int t = 1;
    //     int a = nums[0];
    //     for (int i = 1; i < len; ++i) {
    //         if (nums[i] == nums[i-1]) {
    //             t += 1;
    //         } else {
    //             if (t > times)
    //                 return nums[i-1];
    //             else {
    //                 t = 1;
    //                 a = nums[i];
    //             }
    //         }
    //     }
    //     if (t > times)
    //         return nums[len-1];
    //     else return -1; // 没有众数(This is guranteed not to happen.)
    // }

    // 摩尔投票法 Moore Voting O(n)的时间和O(1)的空间
    // 
    public int majorityElement(int[] nums) {
        int result = nums[0], count = 0;
        for (int num : nums) {
          if (count == 0) {
            result = num;
            count++;
          } else {
            if (result == num) {
              count++;
            } else {
              count--;
            }
          }
        }
        return result;
      }
}

public class MajorityElement {
    public static void main(String[] args) {
        int[] nums = { 3,2,3 };
        Solution s = new Solution();
        System.out.println(s.majorityElement(nums));
    }
}