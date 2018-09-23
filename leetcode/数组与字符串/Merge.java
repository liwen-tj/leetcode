/**
 * 合并两个有序数组
 * 
 * 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
 * 
 * 说明: 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存
 * nums2 中的元素。
 * 
 * 示例: 输入: nums1 = [1,2,3,0,0,0], m = 3 nums2 = [2,5,6], n = 3 输出: [1,2,2,3,5,6]
 */

// naive solution hahahaha
// class Solution {
//     public void merge(int[] nums1, int m, int[] nums2, int n) {
//         int[] nums = new int[m + n];
//         int i = 0, j = 0, k = 0;
//         // 两个指针
//         while (i < m && j < n) {
//             if (nums1[i] < nums2[j]) {
//                 nums[k] = nums1[i];
//                 i += 1;
//             } else {
//                 nums[k] = nums2[j];
//                 j += 1;
//             }
//             k += 1;
//         }
//         // 处理尾巴
//         if (i == m) {
//             for (; j < n; ++j) {
//                 nums[k] = nums2[j];
//                 k += 1;
//             }
//         }
//         else{
//             for(; i<m; ++i){
//                 nums[k] = nums1[i];
//                 k += 1;
//             }
//         }
//         // 赋值给nums1
//         for(int p =0; p<m+n; ++p){
//             nums1[p] = nums[p];
//         }
//     }
// }

// 空间复杂度是O(1) (时间复杂度也更低，值得参考)
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int count = m + n - 1;
        m--;
        n--;
        while (m != -1 && n != -1) {
            nums1[count--] = nums1[m] > nums2[n] ? nums1[m--] : nums2[n--];
        }
        while (n != -1) {
            nums1[count--] = nums2[n--];
        }
    }
}

public class Merge {
    public static void main(String[] args) {
        Solution s = new Solution();
        int [] nums1 = {1,2,3,9,0,0,0}; //m = 3
        int [] nums2 = {2,5,6};      //n = 3
        s.merge(nums1, 4, nums2, 3);
        for(int n: nums1){
            System.out.println(n);
        }
    }
}