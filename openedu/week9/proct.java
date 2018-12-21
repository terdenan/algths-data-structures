import mooc.*;
import java.util.ArrayList;


class Index {

    public static void main(String args[]) {
        try (EdxIO io = EdxIO.create()) {
            ArrayList<Integer> ans = new ArrayList<Integer>();
            String p = io.next();
            String t = io.next();
            String s = p + "#" + t;
            int n = s.length(), l = 0, r = 0;
            int z[] = new int[n];

            for (int i = 0; i < n; i++) {
                z[i] = 0;
            }

            for (int i = 1; i < n; i++) {
                if (i <= r)
                    z[i] = Math.min(z[i - l], r - i + 1);
                while (z[i] + i < n && s.charAt(z[i]) == s.charAt(z[i] + i))
                    z[i] += 1;
                if (i + z[i] - 1 > r) {
                    r = i + z[i] - 1;
                    l = i;
                }
            }

            for (int i = p.length() + 1; i < n; i++) {
                if (z[i] == p.length())
                    ans.add(i - p.length());
            }

            io.println(ans.size());
            for (Integer item : ans) {
                io.print(item + " ");
            }
        }
    }
}
