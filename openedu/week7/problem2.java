import mooc.*;
import java.util.ArrayDeque;


class Elem {
    int key, index, balance;
    Elem left, right;

    Elem() {}

    Elem(Elem cur) {
        if (cur == null)
            return;

        key = cur.key;
        balance = cur.balance;
        left = cur.left;
        right = cur.right;
    }


}

class Index {

    static Elem copy(Elem cur) {
        if (cur == null)
            return null;
        else
            return new Elem(cur);
    }

    public static int dfs(Elem cur) {
        if (cur == null)
            return -1;

        int depthL = dfs(cur.left);
        int depthR = dfs(cur.right);

        cur.balance = depthR - depthL;
        
        return Math.max(depthL, depthR) + 1;
    }

    static void smallLeftRotate(Elem a) {
        Elem b, x, y, z, tempA;

        b = copy(a.right);
        x = copy(a.left);
        y = copy(b.left);
        z = copy(b.right);
        tempA = copy(a);

        a.key = b.key;
        a.right = z;
        a.left = tempA;
        a.left.left = x;
        a.left.right = y;

        if (b.balance == 1) {
            a.balance = 0;
            a.left.balance = 0;
        }
        else {
            a.balance = -1;
            a.left.balance = 1;
        }
    }

    static void smallRightRotate(Elem a) {
        Elem b, x, y, z, tempA;

        b = copy(a.left);
        x = copy(a.right);
        y = copy(b.right);
        z = copy(b.left);
        tempA = copy(a);

        a.key = b.key;
        a.left = z;
        a.right = tempA;
        a.right.right = x;
        a.right.left = y;

        if (b.balance == 1) {
            a.balance = 0;
            a.right.balance = 0;
        }
        else {
            a.balance = -1;
            a.right.balance = 1;
        }
    }

    static void bigLeftRotate(Elem a) {
        Elem b, c, x, y, z, w, tempA;

        w = copy(a.left);
        b = copy(a.right);
        c = copy(b.left);
        x = copy(c.left);
        y = copy(c.right);
        z = copy(b.right);
        tempA = copy(a);

        a.key = c.key;
        a.left = tempA;
        a.left.left = w;
        a.left.right = x;
        a.right.left = y;
        a.right.right = z;

        if (c.balance == -1) {
            a.balance = 0;
            a.left.balance = 1;
            a.right.balance = 0;
        }
        else if (c.balance == 0) {
            a.balance = 0;
            a.left.balance = 0;
            a.right.balance = 0;
        }
        else {
            a.balance = 0;
            a.left.balance = 0;
            a.right.balance = -1;
        }

    }

    static void bigRightRotate(Elem a) {
        Elem b, c, x, y, z, w, tempA;

        w = copy(a.right);
        b = copy(a.left);
        c = copy(b.right);
        x = copy(c.right);
        y = copy(c.left);
        z = copy(b.left);
        tempA = copy(a);

        a.key = c.key;
        a.right = tempA;
        a.right.right = w;
        a.right.left = x;
        a.left.right = y;
        a.left.left = z;

        if (c.balance == -1) {
            a.balance = 0;
            a.right.balance = 1;
            a.left.balance = 0;
        }
        else if (c.balance == 0) {
            a.balance = 0;
            a.right.balance = 0;
            a.left.balance = 0;
        }
        else {
            a.balance = 0;
            a.right.balance = 0;
            a.left.balance = -1;
        }

    }

    public static void balance(Elem cur) {
        int b, bRightChild;

        if (cur.balance == 2) {
            if (cur.right != null && cur.right.balance == -1) {
                bigLeftRotate(cur);
            }
            else {
                smallLeftRotate(cur);
            }
        }
        else if (cur.balance == -2) {
            if (cur.left != null && cur.left.balance == -1) {
                bigRightRotate(cur);
            }
            else {
                smallRightRotate(cur);
            }
        }
    }

    public static void main(String args[]) {
        try (EdxIO io = EdxIO.create()) {
            int n, key, l, r, cnt, x;
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
                }
                if (r != 0) {
                    lst[i].right = lst[r];
                }

            }

            dfs(lst[1]);

            balance(lst[1]);

            ArrayDeque<Elem> q = new ArrayDeque<Elem>();
            q.add(lst[1]);
            cnt = 1;

            io.println(n);
            while (!q.isEmpty()) {
                Elem cur = q.remove();
                l = r = 0;

                io.print(cur.key + " ");

                if (cur.left != null) {
                    q.add(cur.left);
                    io.print(++cnt + " ");
                }
                else {
                    io.print(0 + " ");
                }
                if (cur.right != null) {
                    q.add(cur.right);
                    io.print(++cnt + " ");
                }
                else {
                    io.print(0 + " ");
                }

                io.println();
            }
        }
    }
}
