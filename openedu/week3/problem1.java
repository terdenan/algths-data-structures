// Поразрядная сортировка

import mooc.*;

class RadixSort {

    static int[] sort(int[] lst, int len) {
        int c[] = new int[256];
        int[] b = new int[36000001];

        for (int i = 1; i <= 4; i++) {
            int[] temp;

            for (int j = 0; j <= 255; j++) {
                c[j] = 0;
            }

            for (int j = 0; j < len; j++) {
                int d = (lst[j] >> (i - 1) * 8) & 255;
                c[d] += 1;
                b[j] = 0;
            }

            for (int j = 1; j <= 255; j++) {
                c[j] += c[j - 1];
            }

            for (int j = len - 1; j >= 0; j--) {
                int d = (lst[j] >> (i - 1) * 8) & 255;
                b[c[d] - 1] = lst[j];
                c[d] -= 1;
            }

            temp = lst;
            lst = b;
            b = temp;
        }

        return lst;
    }
}

class Index {
    public static void main(String args[]) {
        try (EdxIO io = EdxIO.create()) {
            int n, m;
            int a[] = new int[6001];
            int b[] = new int[6001];
            int d[] = new int[36000001];
            long ans = 0;

            n = io.nextInt();
            m = io.nextInt();

            for (int i = 0; i < n; i++) {
                a[i] = io.nextInt();
            }
            for (int i = 0; i < m; i++) {
                b[i] = io.nextInt();
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    d[m * i + j] = a[i] * b[j];
                }
            }

            d = RadixSort.sort(d, n * m);

            for (int i = 0; i < n * m; i += 10) {
                ans += d[i];
            }

            io.print(ans);
        }
    }
}