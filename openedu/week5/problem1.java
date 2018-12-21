import mooc.*;
import java.util.Stack;


class Index {
    public static void main(String args[]) {
        try (EdxIO io = EdxIO.create()) {
            int n;
            int[] a = new int[1000010];
            boolean ans = true;

            n = io.nextInt();

            for (int i = 1; i <= n; i++) {
                a[i] = io.nextInt();
            }

            for (int i = 1; i <= n; i++) {
                if (i * 2 <= n && a[i] > a[i * 2]) ans = false;
                if (i * 2 + 1 <= n && a[i] > a[i * 2 + 1]) ans = false;
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
