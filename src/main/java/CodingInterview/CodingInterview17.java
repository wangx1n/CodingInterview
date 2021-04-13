package CodingInterview;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: CodingInterview
 * @description:
 * @author: wang xin
 * @create: 2021/3/20 23:51
 **/
public class CodingInterview17 {
    StringBuilder res;
    int count = 0, n;
    List result = new ArrayList();
    char[] num, loop = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    public int[] printNumbers(int n) {

        this.n = n;
        res = new StringBuilder(); // 数字字符串集
        num = new char[n]; // 定义长度为 n 的字符列表
        dfs(0); // 开启全排列递归
        int[] intArr = result.stream().mapToInt(i -> (int) i).toArray();
        return intArr;
    }
    void dfs(int x) {
        if(x == n) { // 终止条件：已固定完所有位
            if(Integer.parseInt(String.valueOf(num)) == (0))
                return;
            result.add(Integer.parseInt(String.valueOf(num))); // 拼接 num 并添加至 res 尾部，使用逗号隔开
            return;
        }
        for(char i : loop) { // 遍历 ‘0‘ - ’9‘
            num[x] = i; // 固定第 x 位为 i
            dfs(x + 1); // 开启固定第 x + 1 位
        }
    }

    void cutoff(String num){

    }

    @Test
    public void test(){
        printNumbers(3);
    }
}
