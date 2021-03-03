package CodingInterview;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: CodingInterview
 * @description: dfs
 * @author: wang xin
 * @create: 2021/3/2 19:12
 *
地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？



示例 1：

输入：m = 2, n = 3, k = 1
输出：3
示例 2：

输入：m = 3, n = 1, k = 0
输出：1
提示：

1 <= n,m <= 100
0 <= k <= 20
 **/

public class CodingInterview13 {
    /**
     * DFS
     */
//    public int movingCount(int m, int n, int k) {
//        //1.如果m或n小于等于0，则返回0
//        if(m*n <= 0) {
//            return 0;
//        }
//
//        //2.构造m*n大小的矩阵
//        int[][] metrix = new int[m][n];
//
//        return DFS(metrix,0,0,m,n,k);
//    }

    /**
     * BFS
     * @param m
     * @param n
     * @param k
     * @return
     */
    public int movingCount(int m, int n, int k) {

        return BFS(m,n,k);
    }

    int DFS(int[][] metrix,int metrixX,int metrixY,int m,int n,int k){

        //3.判断metrixX和metrixY是否越界
        if(metrixX < 0 || metrixX >= m || metrixY < 0 || metrixY >= n || metrix[metrixX][metrixY] == 1 || !canIn(metrixX,metrixY,k)){
            return 0;
        }

        //4.如果这个点没有被走过，且m+n<k，则能进入
        metrix[metrixX][metrixY] = 1;

        //3.进行DFS，向上下左右移动
        return 1 + DFS(metrix,metrixX+1,metrixY,m,n,k) + DFS(metrix,metrixX,metrixY+1,m,n,k);
    }

    int BFS(int m,int n,int k){

        if (k == 0) {
            return 1;
        }

        //1.构建辅助数组
        boolean[][] isVisited = new boolean[m][n];
        //2.构建上下左右移动,这里只能向左，向右走
        int[] goX = new int[]{1,0};
        int[] goY = new int[]{0,1};

        //3，构建队列，并将[0,0]元素入队
        Queue<int[]> goQueue = new LinkedList<>();
        goQueue.offer(new int[]{0,0});

        isVisited[0][0] = true;
        int count = 1;

        //4.队首出队列，并依次向下向右走
        while(!goQueue.isEmpty()){
            int[] temp = goQueue.poll();
            int x = temp[0]; int y = temp[1];

            for(int i = 0; i < 2; ++i){
                int tempx = x + goX[i];
                int tempy = y + goY[i];

                //数组越界或已经访问过或不能进入
                if(tempx < 0 || tempx >= m || tempy < 0 || tempy >=n || isVisited[tempx][tempy] || !canIn(tempx,tempy,k)){
                    continue;
                }
                else{
                    isVisited[tempx][tempy] = true;
                    count++;

                    //5.将能走的路继续加入队列
                    goQueue.offer(new int[]{tempx,tempy});
                }
            }
        }

        return count;
    }

    /**
     * 判断各位数相加是否小于K
     * @param m
     * @param n
     * @param k
     * @return
     */
    boolean canIn(int m,int n,int k){
        int CountM = m;
        int CountN = n;

        int modM = 0;
        int modN = 0;
        while(CountM!=0){
            modM = CountM % 10 + modM;

            if(modM > k){
                return false;
            }

            CountM /=10 ;
        }

        while(CountN!=0){
            modN = CountN % 10 + modN;

            if(modN > k){
                return false;
            }

            CountN /=10 ;
        }

        if(modM + modN > k){
            return false;
        }
        else{
            return true;
        }
    }

    @org.junit.Test
    public void test1(){
        System.out.println(movingCount(7,2,3));
    }
}
