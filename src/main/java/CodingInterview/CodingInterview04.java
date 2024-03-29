package CodingInterview;

import org.junit.Test;

import java.lang.annotation.Target;

/**
 * @program: CodingInterview.CodingInterview
 * @description: 剑指offer 04
 * @author: wang xin
 * @create: 2021-01-29 14:09
 *
 * 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 *-
 *
 * 示例:
 *
 * 现有矩阵 matrix 如下：
 *
 * [
 *   [1,   4,  7, 11, 15],
 *   [2,   5,  8, 12, 19],
 *   [3,   6,  9, 16, 22],
 *   [10, 13, 14, 17, 24],
 *   [18, 21, 23, 26, 30]
 * ]
 * 给定 target=5，返回true。
 *
 * 给定target=20，返回false。
 *
 * 限制：
 *
 * 0 <= n <= 1000
 *
 * 0 <= m <= 1000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class CodingInterview04 {

    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if(matrix.length == 0){
            return false;
        }

        int lenX = matrix.length;
        int lenY = matrix[0].length;

        for(int x = 0, y = lenY -1;x < lenX && y >= 0;){
            if(matrix[x][y] == target){
                return true;
            }

            if(matrix[x][y] > target){
                y--;
                continue;
            }

            if(matrix[x][y] < target){
                x++;
                continue;
            }
        }
        return false;
    }

    @Test
    public void Test04(){
        int[][] matrix = {{-5}};
        findNumberIn2DArray(matrix,-10);

    }

}
