/**
 * 螺旋矩阵 II
 * 
 * 给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
 * 
 * 示例: 输入: 3 输出: [ [ 1, 2, 3 ], [ 8, 9, 4 ], [ 7, 6, 5 ] ]
 */
class Solution {
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int m = n;
        int i = 0, j = 0;
        int PM = 0, PN = 0; // 已经遍历的行数和列数(左上)
        int aha = 1;
        while (m > 0 && n > 0) { // 四个角
            if (i == 0 && j == 0) { // -----------------------------左上角
                for (int k = 0; k < n; ++k) {
                    result[PM][PN + k] = aha;
                    aha += 1;
                }
                PM += 1;
                m -= 1; // 当前总行数
                i = 0;
                j = n - 1;
            } else if (i == 0 && j == n - 1) { // -----------------------------右上角
                for (int k = 0; k < m; ++k) {
                    result[PM + k][PN + j] = aha;
                    aha += 1;
                }
                n -= 1; // 当前总列数
                i = m - 1;
                j = n - 1;
            } else if (i == m - 1 && j == 0) { // -----------------------------左下角
                for (int k = m - 1; k >= 0; --k) {
                    result[PM + k][PN] = aha;
                    aha += 1;
                }
                PN += 1;
                n -= 1;
                i = 0;
                j = 0;
            } else if (i == m - 1 && j == n - 1) { // -----------------------------右下角
                for (int k = n - 1; k >= 0; --k) {
                    result[PM + i][PN + k] = aha;
                    aha += 1;
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

public class GenerateMatrix {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] matrix = s.generateMatrix(6);
        for (int[] r : matrix) {
            for(int m: r){
                System.out.print(m);
                System.out.print(" ");
            }
            System.out.println("");
        }
    }
}