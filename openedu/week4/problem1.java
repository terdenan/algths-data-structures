import mooc.*;
import java.util.Stack;


class Index {
    public static void main(String args[]) {
        try (EdxIO io = EdxIO.create()) {
            int m;
            Stack<Integer> st = new Stack<Integer>();

            m = io.nextInt();

            for (int i = 0; i < m; i++) {
                String command;
                int num;

                command = io.next();

                if (command.equals("+")) {
                    num = io.nextInt();
                    st.push(num);
                }
                else {
                    io.println(st.pop());
                }
            }
        }
    }
}
