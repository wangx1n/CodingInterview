import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class alioo1 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int t = cin.nextInt();
        while (t > 0) {
            int n = cin.nextInt(), k = cin.nextInt();
            int[] in = new int[n], out = new int[n];
            for (int i = 0; i < n;i++){
                in[i] = cin.nextInt();
            }
            for (int i = 0; i < n;i++){
                out[i] = cin.nextInt();
            }
            int ans = 0, inIndex = 0;
            Set<Integer> inSet = new HashSet<>(), outSet = new HashSet<>();
            while (inIndex < k &&  inIndex < n) {
                inSet.add(in[inIndex++]);
            }
            for (int i = 0; i < n; i++) {
                int cur = out[i];
                outSet.add(cur);
                if (inSet.contains(cur)){
                    inSet.remove(cur);
                    while(inIndex < n && outSet.contains(in[inIndex])){
                        inIndex++;
                    }
                    if (inIndex < n) {
                        inSet.add(in[inIndex]);
                        ++inIndex;
                    }
                }else {
                    ++ans;
                }
            }
            System.out.println(ans);
            --t;
        }
    }
}
