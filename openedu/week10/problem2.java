// Z-функция

import mooc.*;
import java.util.ArrayList;


class Index {

    public static void main(String args[]) {
        try (EdxIO io = EdxIO.create()) {
            String s = io.next();
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

            for (int i = 1; i < n; i++) {
                io.print(z[i] + " ");
            }
        }
    }
}
