import mooc.*;
import java.util.HashMap;


class Index {

    public static void main(String args[]) {
        try (EdxIO io = EdxIO.create()) {
            int n;
            String command;
            long key;
            HashMap<Long, Boolean> m = new HashMap<Long, Boolean>();

            n = io.nextInt();

            for (int i = 1; i <= n; i++) {
                command = io.next();
                key = io.nextLong();

                if (command.equals("A")) {
                    m.put(key, true);
                }
                else if (command.equals("D")) {
                    m.remove(key);
                }
                else {
                    if (m.containsKey(key)) {
                        io.println("Y");
                    }
                    else {
                        io.println("N");
                    }
                }
            }

        }
    }
}
