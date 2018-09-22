/**
 * 三数之和
 * 
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0
 * 找出所有满足条件且不重复的三元组。 注意：答案中不可以包含重复的三元组。
 * 
 * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]， 满足要求的三元组集合为： [ [-1, 0, 1], [-1, -1, 2]
 * ]
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    // O(N^2)的解法
    public List<List<Integer>> threeSum(int[] numbers) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Arrays.sort(numbers); // 先排序
        for (int i = 0; i < numbers.length;) {
            int l = i + 1, r = numbers.length - 1;
            while (l < r) {
                ArrayList<Integer> stepRes = new ArrayList<Integer>();
                int sum = numbers[i] + numbers[l] + numbers[r];
                if (sum == 0) {
                    stepRes.add(numbers[i]);
                    stepRes.add(numbers[l]);
                    stepRes.add(numbers[r]);
                    res.add(stepRes);

                    // 为了保证不重复
                    int l_temp = numbers[l];
                    while(l>i && l<numbers.length && l_temp == numbers[l])++l;

                    int r_temp = numbers[r];
                    while(r>i && r<numbers.length && r_temp == numbers[r])--r;
                }
                else if (sum < 0) ++l;
                else --r;
            }
            // 为了保证不重复
            int temp = numbers[i];
            while(i<numbers.length && numbers[i]==temp){
                i += 1;
            }
        }
        return res;
    }
}

public class ThreeSum {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] x = { 0,0,0 };
        List<List<Integer>> results = s.threeSum(x);
        for (List<Integer> m : results) {
            for (Integer n : m) {
                System.out.print(n);
                System.out.print(" ");
            }
            System.out.println("");
        }
    }
}