package Interview.jd;

import java.util.*;

public class jd02 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        int q = cin.nextInt();
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int c = cin.nextInt();
            if (c == 0) {
                continue;
            } else {
                ArrayList l = map.getOrDefault(c, new ArrayList<>());
                l.add(cin.nextInt());
                map.put(c, l);
            }
        }
        ArrayList live = new ArrayList();
        ArrayList dead = new ArrayList();
        for (int i = 0; i < q; i++) {
            Integer x = cin.nextInt();
            Integer y = cin.nextInt();
            if (x == 1) {
                if (!live.contains(y)){
                    live.add(y);
                    if(!live.containsAll(map.get(y))){
                        live.addAll(map.get(y));
                    }
                }
                if(!dead.isEmpty() && dead.contains(y)) {
                    dead.remove(y);
                }
                if(!dead.isEmpty() && dead.containsAll(map.get(y))) {
                    dead.removeAll(map.get(y));
                }
                System.out.println(live.size());
            } else {
                if (!dead.contains(y)) {
                    dead.add(y);
                    if (!live.isEmpty() && live.contains(y)){
                        live.remove(y);
                    }
                    for(Integer key : map.keySet()) {
                        if (key == y) {
                            if (!live.isEmpty() && live.contains(key)) {
                                live.remove(key);
                            }
                            if (!dead.containsAll(map.get(key))) {
                                dead.add(map.get(key));
                            }
                        }

                    }
                }
                System.out.println(live.size());
            }
        }
    }
}
