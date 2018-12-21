import mooc.*;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.ArrayDeque;
import java.lang.Math;

class Elem {
    int value;
    int index;

    Elem(int v, int i) {
        value = v;
        index = i;
    }
}

class InsertionSort {
    static void sort(ArrayList<Elem> lst, int l, int r, int f) {
        if (l == r) {
            return;
        }

        int m = (l + r) / 2;
        sort(lst, l, m, f);
        sort(lst, m + 1, r, f);

        ArrayDeque<Elem> q = new ArrayDeque<Elem>();
        int i, j;
        i = l;
        j = m + 1;

        while (i <= m || j <= r) {
            int pos_to_insert = l + q.size();
            if (j == r + 1 || (i <= m && lst.get(i).value < lst.get(j).value
                                      || i <= m && lst.get(i).value == lst.get(j).value 
                                      && Math.abs(lst.get(i).index % f - pos_to_insert % f) 
                                      < Math.abs(lst.get(j).index % f - pos_to_insert % f))) {
                q.add(lst.get(i));
                i += 1;
            }
            else {
                q.add(lst.get(j));
                j += 1;
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
            int n, k;
            ArrayList<Elem> lst = new ArrayList<Elem>();

            n = io.nextInt();
            k = io.nextInt();

            for (int i = 0; i < n; i++) {
                int value = io.nextInt();
                Elem item_to_insert = new Elem(value, i);
                lst.add(item_to_insert);
            }

            InsertionSort.sort(lst, 0, n - 1, k);

            boolean ans = true;

            for (int i = 0; i < lst.size(); i++) {
                if (i % k != lst.get(i).index % k) ans = false;
            }

            if (ans) {
                io.print("YES");
            }
            else {
                io.print("NO");
            }
        }
    }
}