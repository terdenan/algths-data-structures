import mooc.*;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.PriorityQueue;

class Index {
    public static void main(String args[]) {
        try (EdxIO io = EdxIO.create()) {
            int n;
            Integer init[] = {1, 2};
            ArrayList<Integer> lst = new ArrayList<Integer>(Arrays.asList(init));

            n = io.nextInt();
            
            if (n == 1) {
                io.print("1");
                return;
            }
            if (n == 2) {
                io.print("1 2");
                return;
            }

            for (int i = 3; i <= n; i++) {
                lst.add(i);
                int buff = lst.get((i - 1) / 2);
                lst.set((i - 1) / 2, i);
                lst.set(i - 1, buff);
            }

            for (int item : lst) {
                io.print(item + " ");
            }
        }
    }
}