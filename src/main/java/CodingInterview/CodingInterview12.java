package CodingInterview;

/**
 * @program: CodingInterview
 * @description: dfs
 * @author: wang xin
 * @create: 2021-02-20 15:09
 **/
public class CodingInterview12 {
    public boolean exist(char[][] board, String word) {

        char[] wordCharArray = word.toCharArray();

        //1.遍历矩阵，对每一个元素DFS
        for(int i = 0;i < board.length;i++){
            for(int j = 0;j <board[0].length;j++) {
                if (DFS(board,wordCharArray,i,j,0)) return true;
            }
        }
        return false;
    }

    boolean DFS(char[][] board,char[] word,int i,int j,int k){
        //1.如果越界，进行剪枝
        if(i < 0 || j < 0 || i >= board.length || j >= board[0].length) return false;
        //2.如果不是k号元素，进行剪枝
        if(board[i][j] != word[k]) return false;
        //3.如果k是最后一个word的下标，直接返回true
        if(k == word.length - 1) return true;

        //4.对当前元素填充'\0'
        board[i][j] = '\0';

        //5.对当前元素继续DFS
        boolean result = DFS(board,word,i+1,j,k+1) || DFS(board,word,i,j+1,k+1) ||
                DFS(board,word,i-1,j,k+1)|| DFS(board,word,i,j-1,k+1);

        //6.对当前元素进行复原
        board[i][j] = word[k];

        return result;

    }
}
