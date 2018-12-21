import mooc.*;
import java.util.ArrayList;


class Elem {
    int key, index, depth;
    Elem left, right, p;
}

class Index {

    public static int dfs(Elem cur) {
        if (cur == null)
            return -1;

        cur.depth = Math.max(dfs(cur.left), dfs(cur.right)) + 1;

        return cur.depth;
    }

    public static void main(String args[]) {
        try (EdxIO io = EdxIO.create()) {
            int n, key, l, r;
            Elem[] lst;

            n = io.nextInt();
            lst = new Elem[n + 1];

            for (int i = 1; i <= n; i++) {
                lst[i] = new Elem();
            }

            for (int i = 1; i <= n; i++) {
                key = io.nextInt();
                l = io.nextInt();
                r = io.nextInt();

                lst[i].key = key;
                if (l != 0) {
                    lst[i].left = lst[l];
                    lst[l].p = lst[i];
                }
                if (r != 0) {
                    lst[i].right = lst[r];
                    lst[r].p = lst[i];
                }

            }

            dfs(lst[1]);

            for (int i = 1; i <= n; i++) {
                l = -1;
                r = -1;

                if (lst[i].left != null)
                    l = lst[i].left.depth;

                if (lst[i].right != null)
                    r = lst[i].right.depth;

                io.println(r - l);
            }

        }
    }
}
