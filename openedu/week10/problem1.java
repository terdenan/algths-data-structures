// Префикс-функция

import mooc.*;
import java.util.ArrayList;


class Index {

    public static void main(String args[]) {
        try (EdxIO io = EdxIO.create()) {
            String s = io.next();
            int n = s.length();
            int p[] = new int[n];

            for (int i = 0; i < n; i++) {
                p[i] = 0;
            }

            for (int i = 1; i < n; i++) {
                int j = p[i - 1];
                while (j > 0 && s.charAt(i) != s.charAt(j))
                    j = p[j - 1];
                if (s.charAt(i) == s.charAt(j))
                    j++;
                p[i] = j;
            }

            for (int i = 0; i < n; i++) {
                io.print(p[i] + " ");
            }
        }
    }
}
