import mooc.*;
import java.util.ArrayList;


class Index {
    public static void main(String args[]) {
        try (EdxIO io = EdxIO.create()) {
            int n;
            ArrayList<Integer> lst = new ArrayList<Integer>();
            ArrayList<Integer> lst_copy = new ArrayList<Integer>();
            String ans = "";

            n = io.nextInt();
            for (int i = 0; i < n; i++) {
                int cur = io.nextInt();
                lst.add(cur);
                lst_copy.add(cur);
            }

            for (int j = 1; j < n; j++) {
                int i = j;
                while (i > 0 && lst.get(i - 1) > lst.get(i)) {
                    int c = lst.get(i - 1);
                    lst.set(i - 1, lst.get(i));
                    lst.set(i, c);
                    i -= 1;
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    if (lst.get(i).equals(lst_copy.get(j))) {
                        int c = lst_copy.get(i);
                        lst_copy.set(i, lst_copy.get(j));
                        lst_copy.set(j, c);
                        ans += "Swap elements at indices " + (i + 1) + " and " + (j + 1) + ".\n";
                        break;
                    }
                }
            }
            
            io.println(ans + "No more swaps needed.");

            for (int item : lst) {
                io.print(item + " ");
            }
        }
    }
}