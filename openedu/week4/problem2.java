import mooc.*;
import java.util.Stack;
import java.util.ArrayDeque;


class Index {
    public static void main(String args[]) {
        try (EdxIO io = EdxIO.create()) {
            int m;
            ArrayDeque<Integer> q = new ArrayDeque<Integer>();

            m = io.nextInt();

            for (int i = 0; i < m; i++) {
                String command;
                int num;

                command = io.next();

                if (command.equals("+")) {
                    num = io.nextInt();
                    q.add(num);
                }
                else {
                    io.println(q.remove());
                }
            }
        }
    }
}
