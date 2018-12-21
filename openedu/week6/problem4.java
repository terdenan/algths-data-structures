import mooc.*;


class Elem {
    int key, cnt, index;
    Elem l, r, p;
}


class Index {

    public static int count(Elem cur) {
        if (cur == null)
            return 0;

        cur.cnt = count(cur.l) + count(cur.r) + 1;

        return cur.cnt;
    }

    static Elem getByKey(Elem cur, int key) {
        if (cur.key == key) {
            return cur;
        }
        else if (cur.l != null && cur.key > key) {
            return getByKey(cur.l, key);
        }
        else if (cur.r != null && cur.key < key) {
            return getByKey(cur.r, key);
        }

        return null;
    }

    static void updateCounters(Elem cur, int cnt) {
        if (cur == null) {
            return;
        }
        cur.cnt -= cnt;
        updateCounters(cur.p, cnt);
    }

    public static void main(String args[]) {
        try (EdxIO io = EdxIO.create()) {
            int n, m;
            Elem[] lst = new Elem[200010];

            n = io.nextInt();

            for (int i = 1; i <= n; i++) {
                lst[i] = new Elem();
            }
            
            for (int i = 1; i <= n; i++) {
                int l, r, key;

                key = io.nextInt();
                l = io.nextInt();
                r = io.nextInt();

                lst[i].key = key;
                lst[i].cnt = 0;
                lst[i].index = i;
                if (l != 0) {
                    lst[i].l = lst[l];
                    lst[l].p = lst[i];
                }
                if (r != 0) {
                    lst[i].r = lst[r];
                    lst[r].p = lst[i];
                }
            }

            count(lst[1]);

            m = io.nextInt();

            for (int i = 1; i <= m; i++) {
                int key = io.nextInt();
                Elem nodeToDel = getByKey(lst[1], key);


                if (nodeToDel != null) {
                    updateCounters(nodeToDel.p, nodeToDel.cnt);

                    lst[nodeToDel.index] = null;
                    if (nodeToDel.p.l == nodeToDel)
                        nodeToDel.p.l = null;
                    else 
                        nodeToDel.p.r = null;
                }   

                io.println(lst[1].cnt);
            }

        }
    }
}
