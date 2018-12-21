import mooc.*;


class Elem {
    int key, l, r;

    Elem(int k, int left, int right) {
        key = k;
        l = left;
        r = right;
    }
}


class Index {
    public static int depth(Elem[] lst, Elem cur, int d) {
        if (cur == null) {
            return 0;
        }
        return Math.max(depth(lst, lst[cur.l], d), depth(lst, lst[cur.r], d)) + 1;
    }

    public static void main(String args[]) {
        try (EdxIO io = EdxIO.create()) {
            int n, key, left, right, ans = 1;
            Elem[] lst = new Elem[200010];
            Elem cur;

            n = io.nextInt();
            
            for (int i = 1; i <= n; i++) {
                key = io.nextInt();
                left = io.nextInt();
                right = io.nextInt();

                lst[i] = new Elem(key, left, right);
            }

            cur = lst[1];

            ans = depth(lst, cur, 1);

            io.print(ans);
        }
    }
}
