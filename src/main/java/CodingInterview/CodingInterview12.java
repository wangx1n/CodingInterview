package CodingInterview;

/**
 * @program: CodingInterview
 * @description: dfs
 * @author: wang xin
 * @create: 2021-02-20 15:09
 *
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一格开始，每一步可以在矩阵中向左、右、上、下移动一格。如果一条路径经过了矩阵的某一格，那么该路径不能再次进入该格子。例如，在下面的3×4的矩阵中包含一条字符串“bfce”的路径（路径中的字母用加粗标出）。
 *
 * [["a","b","c","e"],
 * ["s","f","c","s"],
 * ["a","d","e","e"]]
 *
 * 但矩阵中不包含字符串“abfb”的路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入这个格子。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 * 输出：true
 * 示例 2：
 *
 * 输入：board = [["a","b"],["c","d"]], word = "abcd"
 * 输出：false
 *  
 *
 * 提示：
 *
 * 1 <= board.length <= 200
 * 1 <= board[i].length <= 200
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ju-zhen-zhong-de-lu-jing-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
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
