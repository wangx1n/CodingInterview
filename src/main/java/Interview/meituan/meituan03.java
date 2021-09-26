//package InterviewTest.Meituan.meituan2021.meituan;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Scanner;
//小美在听歌。歌单给小美推送了一个歌单序列，歌单中的歌会严格按顺序播放。
//
//歌单中有很多歌曲，听每首歌曲会给小美带来ai点愉悦值。但是某些歌曲是一个系列的。如果小美在听这首歌曲之前没有按顺序听过这个系列的所有前面的歌曲，就会给小美带来-bi的愉悦值（即最后选择这首歌可获得的总愉悦值为ai-bi。）歌单并不会保证这首歌在系列中前面的歌曲都在歌单中。
//
//因此，小美可以预先去除中间的一些歌曲，使得自己更加愉悦。由于去掉歌曲需要花费时间，所以每去掉一首歌曲都会让自己的愉悦值减小k。
//
//由于歌单是智能的，所以其中不会包含重复的歌曲。
//
//请问小美能获得的最大愉悦值是多少？
//
//
//
//输入描述
//第一行两个空格隔开的整数n,k(1≤n,k≤105)代表歌曲数量和删除歌曲减少的愉悦值。
//
//接下来n行每行包括四个空格隔开的整数ai,bi,ci,di(1≤ai,bi,ci,di≤105)分别代表听这首歌获得的愉悦值，没有按顺序听完这个系列之前的歌所需要扣除的愉悦值，这首歌所在的系列，这首歌在系列中是第几首。
//
//输出描述
//输出一个数字代表小美能获得的最大愉悦值
//
//
//样例输入
//5 1
//20 1000 1 2
//1 1 1 1
//5 3 1 3
//20 1 2 2
//22 2 2 3
//样例输出
//41
//
//提示
//样例解释
//
//小美删去了第一首歌，愉悦值为 (-1+1+2+19+20)=41 ，其中第一个 -1为进行删除操作时损失的愉悦值
//public class meituan03 {
//    private static List<happy> h = new ArrayList();
//    public static void main(String args[]) {
//        Scanner cin = new Scanner(System.in);
//        HashMap<Integer,Integer> map = new HashMap();
//        int n = cin.nextInt();
//        int panish = cin.nextInt();
//        for (int i = 0; i < n; i++) {
//            int a = cin.nextInt();
//            int b = cin.nextInt();
//            int c = cin.nextInt();
//            int d = cin.nextInt();
//            happy ha = new happy();
//            ha.set(a, b, c, d);
//            h.add(ha);
//            if (!map.containsKey(c)) {
//                map.put(c, 1);
//            }
//        }
//        int tempkey = Integer.MAX_VALUE;
//        for (Integer key : map.keySet()) {
//            for (happy ha : h){
//                if (ha.c == key && ha)
//            }
//        }
//
//    }
//}
//
//class happy {
//    public int a;
//    public int b;
//    public int c;
//    public int d;
//    public void set(int a, int b, int c, int d) {
//        this.a = a;
//        this.b = b;
//        this.c = c;
//        this.d = d;
//    }
//}
