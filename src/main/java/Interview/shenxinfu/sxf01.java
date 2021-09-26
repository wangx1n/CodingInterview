package InterviewTest.Meituan.meituan2021.shenxinfu;

public class sxf01 {
    public int ncov_defect (int[][] grid) {
        int result = 0;
        int[] x = {0, 1, 0, -1}, y = {-1, 0, 1, 0};
        int n = grid.length, m = grid[0].length;
        for(int i = 0 ; i <n; ++i) {
            for (int j = 0; j <m; j++) {
                if (grid[i][j] == 1){
                    for(int k = 0; k < 4;k++) {
                        int gox = i + x[k], goy = j + x[k];
                        if (gox >= 0 && gox < n && goy >=0 && goy < m && grid[gox][goy] == 0) {
                            grid[gox][goy] = 2;
                            result++;
                        }
                    }
                }
            }
        }
        return result;
    }
}
