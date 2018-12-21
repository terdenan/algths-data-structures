import mooc.*;
import java.util.ArrayList;


class QSort {
    static void sort(int[] lst, int l, int r, int k1, int k2) {
        int i, j, key;

        key = lst[(l + r) / 2];
        i = l;
        j = r;

        while (i <= j) {
            while (lst[i] < key) i += 1;
            while (key < lst[j]) j -= 1;

            if (i <= j) {
                int tmp = lst[i];
                lst[i] = lst[j];
                lst[j] = tmp;
                i += 1;
                j -= 1;
            }
        }
        if (l < j && (k1 <= l && j <= k2 || l <= k1 && k1 <= j || l <= k2 && k2 <= j)) {
            sort(lst, l, j, k1, k2);
        }
        if (i < r && (k1 <= i && r <= k2 || i <= k1 && k1 <= r || i <= k2 && k2 <= r)) {
            sort(lst, i, r, k1, k2);
        }

        return;
    }
}


class Index {
    public static void main(String args[]) {
        try (EdxIO io = EdxIO.create()) {
            int n, k1, k2, a, b, c;
            int lst[] = new int[40000010];

            n = io.nextInt();
            k1 = io.nextInt();
            k2 = io.nextInt();
            a = io.nextInt();
            b = io.nextInt();
            c = io.nextInt();

            lst[1] = io.nextInt();
            lst[2] = io.nextInt();

            for (int i = 3; i <= n; i++) {
                lst[i] = (int)(a * lst[i - 2] + b * lst[i - 1] + c);
            }

            QSort.sort(lst, 1, n, k1, k2);

            for (int i = k1; i <= k2; i++) {
                io.print(lst[i] + " ");
            }
            
        }
    }
}