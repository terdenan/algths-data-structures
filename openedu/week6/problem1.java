import mooc.*;


class Index {
    public static void main(String args[]) {
        try (EdxIO io = EdxIO.create()) {
            int n, k, a[], req;
            int l, r, m;

            n = io.nextInt();
            a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = io.nextInt();
            }
            k = io.nextInt();

            for (int i = 0; i < k; i++) {
                req = io.nextInt();

                l = -1; r = n;
                while (l + 1 != r) {
                    m = (l + r) / 2;
                    if (a[m] < req) {
                        l = m;
                    }
                    else {
                        r = m;
                    }
                }
                if (r < n && a[r] == req) {
                    io.print(r + 1);
                }
                else {
                    io.print(-1);
                }
                io.print(' ');

                l = -1; r = n;
                while (l + 1 != r) {
                    m = (l + r) / 2;
                    if (a[m] > req) {
                        r = m;
                    }
                    else {
                        l = m;
                    }
                }
                if (l >= 0 && a[l] == req) {
                    io.print(l + 1);
                }
                else {
                    io.print(-1);
                }
                io.println();

            }
        }
    }
}
