import mooc.*;
import java.util.ArrayList;
import java.util.PriorityQueue;

class InsertionSort {
    static long N = 0;
    static void sort(ArrayList<Integer> lst, int l, int r, EdxIO io) {
        if (l == r) {
            return;
        }

        int m = (l + r) / 2;
        sort(lst, l, m, io);
        sort(lst, m + 1, r, io);

        PriorityQueue<Integer> q = new PriorityQueue<Integer>();
        int i, j;
        long cur;
        i = l;
        j = m + 1;
        cur = 0;

        while (i <= m || j <= r) {
            if (j == r + 1 || (i <= m && lst.get(i) <= lst.get(j))) {
                q.add(lst.get(i));
                i += 1;
                N += cur;
            }
            else {
                q.add(lst.get(j));
                j += 1;
                cur += 1;
            }
        }

        for (int k = l; k <= r; k++) {
            lst.set(k, q.poll());
        }

    }
}

class Index {
    public static void main(String args[]) {
        try (EdxIO io = EdxIO.create()) {
            int n;
            ArrayList<Integer> lst = new ArrayList<Integer>();

            n = io.nextInt();
            for (int i = 0; i < n; i++) {
                int cur = io.nextInt();
                lst.add(cur);
            }

            InsertionSort.sort(lst, 0, n - 1, io);

            io.println(InsertionSort.N);
        }
    }
}