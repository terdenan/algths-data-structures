import mooc.*;


class Index {
    public static void main(String args[]) {
        try (EdxIO io = EdxIO.create()) {
            int n;
            double a, l, r, m, pr1, pr2, pr3 = 0;
            boolean marker = true;

            n = io.nextInt();
            a = io.nextDoublePrecise();

            l = 0;
            r = a;

            while (r - l >= 0.000000001) {
                m = (l + r) / 2;
                marker = true;

                pr1 = a;
                pr2 = m;

                for (int i = 3; i <= n; i++) {
                    pr3 = 2 * pr2 + 2 - pr1;

                    if (pr3 < 0) {
                        marker = false;
                        break;
                    }

                    pr1 = pr2;
                    pr2 = pr3;
                }

                if (marker) {
                    r = m;
                }
                else {
                    l = m;
                }
            }

            pr1 = a;
            pr2 = r;

            for (int i = 3; i <= n; i++) {
                pr3 = 2 * pr2 + 2 - pr1;

                pr1 = pr2;
                pr2 = pr3;
            }

            io.print(pr3);
        }
    }
}
