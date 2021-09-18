package LC100;

import java.sql.Connection;
import java.util.*;

/**
 * @program: CodingInterview
 * @description:
 * @author: wang xin
 * @create: 2021/9/18 16:31
 **/
public class TU {
    public static ArrayList result = new ArrayList<Integer>();;
    public static void main(String[] args) {
        LinkedHashMap<Integer, ArrayList<Integer>> map = new LinkedHashMap<>();
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        int m = cin.nextInt();
        for (int i = 0; i < m ; i++) {
            int from = cin.nextInt();
            int to = cin.nextInt();
            ArrayList<Integer> l = map.getOrDefault(from, new ArrayList<>());
            l.add(to);
            map.put(from, l);
        }
        ArrayList<Integer> tempRes = new ArrayList<>();
        dfs(map, tempRes, 1);
        System.out.println(result.size());

    }

    public static void dfs(LinkedHashMap<Integer, ArrayList<Integer>> map, ArrayList tempRes, int k) {
        if (tempRes.size() == 5) {
            Collections.sort(tempRes);
            for (int i = 0; i < result.size();i++) {
                if (result.get(i).equals(tempRes)) {
                    return;
                }
            }
            result.add(tempRes);
            return;
        }

        for (int i = k; i < map.size(); i++) {
            ArrayList<Integer> l = map.get(i);
            tempRes.add(i);
            for (int j = 0; j < l.size();j++) {
                tempRes.add(l.get(j));
                dfs(map, tempRes, l.get(j));
                tempRes.remove(tempRes.size() - 1);
            }
            tempRes.remove(tempRes.size() - 1);
        }
    }
}
