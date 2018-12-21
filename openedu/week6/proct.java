import mooc.*;


class Elem {
    int key, l, r, p, index;
}

class Res {
    boolean ans;
    int max, min;
}


class Index {
    public static Res depth(Elem[] lst, Elem cur) {
        Res res, res_l, res_r;

        res = new Res();

        res.ans = true;
        res.max = cur.key;
        res.min = cur.key;

        if (cur.l != 0) {
            res_l = depth(lst, lst[cur.l]);
            res.min = res_l.min;
            res.ans = res.ans & res_l.ans & (cur.key > res_l.max);
        }
        if (cur.r != 0) {
            res_r = depth(lst, lst[cur.r]);
            res.max = res_r.max;
            res.ans = res.ans & res_r.ans & (cur.key < res_r.min);
        }

        return res;
    }

    public static void main(String args[]) {
        try (EdxIO io = EdxIO.create()) {
            int n, key, left, right;
            Res res;
            Elem[] lst = new Elem[200010];

            n = io.nextInt();

            if (n == 0) {
                io.print("YES");
                return;
            }

            for (int i = 1; i <= n; i++) {
                lst[i] = new Elem();
            }
            
            for (int i = 1; i <= n; i++) {
                lst[i].key = io.nextInt();
                lst[i].l = io.nextInt();
                lst[i].r = io.nextInt();
            }

            res = depth(lst, lst[1]);

            if (res.ans) {
                io.print("YES");
            }
            else {
                io.print("NO");
            }
        }
    }
}
