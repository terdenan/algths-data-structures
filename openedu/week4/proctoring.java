import mooc.*;
import java.util.Stack;


class Index {
    public static void main(String args[]) {
        try (EdxIO io = EdxIO.create()) {
            int n;
            Stack<Integer> st = new Stack<Integer>();
            n = io.nextInt();

            for (int i = 0; i < n; i++) {
                String sym = io.next();

                if (sym.equals("+") || sym.equals("-") || sym.equals("*")) {
                    int num1, num2;

                    num1 = st.pop();
                    num2 = st.pop();

                    switch(sym) {
                        case "*":
                            st.push(num1 * num2);
                            break;
                        case "+":
                            st.push(num1 + num2);
                            break;
                        case "-":
                            st.push(num2 - num1);
                            break;

                    }
                }
                else {
                    st.push(Integer.parseInt(sym));
                }
            }

            io.print(st.pop());
        }
    }
}
