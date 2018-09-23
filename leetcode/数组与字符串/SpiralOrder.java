import java.util.ArrayList;
import java.util.List;
/**
 * 螺旋矩阵 给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
 * 
 * 示例 1:
 * 输入: [ [ 1, 2, 3 ], [ 4, 5, 6 ], [ 7, 8, 9 ] ] 输出: [1,2,3,6,9,8,7,4,5] 
 * 
 * 示例 2:
 * 输入: [ [1, 2, 3, 4], [5, 6, 7, 8], [9,10,11,12] ] 输出:
 * [1,2,3,4,8,12,11,10,9,5,6,7]
 */
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        // 获取矩阵的行数和列数
        int m = matrix.length;
        if (m == 0) {
            return new ArrayList<Integer>();
        }
        int n = matrix[0].length;

        // 螺旋输出
        List<Integer> result = new ArrayList<Integer>();
        int i = 0, j = 0;
        int PM = 0, PN = 0; // 已经遍历的行数和列数(左上)
        while (m > 0 && n > 0) { // 四个角
            if (i == 0 && j == 0) { // -----------------------------左上角
                for (int k = 0; k < n; ++k) {
                    result.add(matrix[PM][PN + k]);
                }
                PM += 1;
                m -= 1; // 当前总行数
                i = 0;
                j = n - 1;
            } else if (i == 0 && j == n - 1) { // -----------------------------右上角
                for (int k = 0; k < m; ++k) {
                    result.add(matrix[PM + k][PN + j]);
                }
                n -= 1; // 当前总列数
                i = m - 1;
                j = n - 1;
            } else if (i == m - 1 && j == 0) { // -----------------------------左下角
                for (int k = m - 1; k >= 0; --k) {
                    result.add(matrix[PM + k][PN]);
                }
                PN += 1;
                n -= 1;
                i = 0;
                j = 0;
            } else if (i == m - 1 && j == n - 1) { // -----------------------------右下角
                for (int k = n - 1; k >= 0; --k) {
                    result.add(matrix[PM + i][PN + k]);
                }
                m -= 1;
                i = m - 1;
                j = 0;
            } else {
                System.out.println("error");
            }
        }
        return result;
    }
}

public class SpiralOrder {
    public static void main(String[] args) {
        Solution s = new Solution();
        int [][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9,10,11,12}};
        List<Integer> result = s.spiralOrder(matrix);
        for(int r: result){
            System.out.println(r);
        }
    }
}