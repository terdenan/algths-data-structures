import mooc.*;
import java.util.ArrayList;

class Index {
    public static void main(String args[]) {
        try (EdxIO io = EdxIO.create()) {
            int n;
            ArrayList<Integer> lst = new ArrayList<Integer>();
            ArrayList<Integer> ans = new ArrayList<Integer>();
            ans.add(1);

            n = io.nextInt();
            for (int i = 0; i < n; i++) {
                int item = io.nextInt();
                lst.add(item);
            }

            for (int j = 1; j < n; j++) {
                int i = j;
                while (i > 0 && lst.get(i - 1) > lst.get(i)) {
                    int c = lst.get(i - 1);
                    lst.set(i - 1, lst.get(i));
                    lst.set(i, c);
                    i -= 1;
                }
                ans.add(i + 1);
            }

            for (int item : ans) {
                io.print(item + " ");
            }
            io.println();
            for (int item : lst) {
                io.print(item + " ");
            }

        }
    }
}