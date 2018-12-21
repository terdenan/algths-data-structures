import mooc.*;
import java.util.Stack;


class Index {
    public static void main(String args[]) {
        try (EdxIO io = EdxIO.create()) {
            int n;
            Stack<Byte> st = new Stack<Byte>();

            n = io.nextInt();

            for (int i = 0; i < n; i++) {
                byte[] seq = io.nextBytes();
                boolean ans = true;

                for (int j = 0; j < seq.length; j++) {
                    if (seq[j] == 40 || seq[j] == 91) {
                        st.push(seq[j]);
                    }
                    else {
                        if (st.empty()) {
                            ans = false;
                            break;
                        }
                        byte top = st.pop();
                        if (top == 40 && seq[j] != 41 || top == 91 && seq[j] != 93) {
                            ans = false;
                            break;
                        }
                    }
                }

                if (!st.empty()) {
                    ans = false;
                }

                st.clear();

                if (ans) {
                    io.println("YES");
                }
                else {
                    io.println("NO");
                }
            }
        }
    }
}
