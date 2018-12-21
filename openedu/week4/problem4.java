import mooc.*;
import java.util.ArrayDeque;


class Elem {
    int value, cnt;

    Elem(int v, int c) {
        value = v;
        cnt = c;
    }
}

class Index {
    public static void main(String args[]) {
        try (EdxIO io = EdxIO.create()) {
            int n, cntToDel = 0;
            ArrayDeque<Elem> q = new ArrayDeque<Elem>();

            n = io.nextInt();

            for (int i = 0; i < n; i++) {
                String command;
                int num;

                command = io.next();

                if (command.equals("+")) {
                    int cnt = 0;
                    num = io.nextInt();

                    while (!q.isEmpty() && q.getLast().value > num) {
                        cnt += q.getLast().cnt + 1;
                        q.pollLast();
                    }

                    q.add(new Elem(num, cnt));
                }
                else if (command.equals("?")) {
                    io.println(q.getFirst().value);
                }
                else {
                    if (q.getFirst().cnt == cntToDel) {
                        cntToDel = 0;
                        q.pollFirst();
                    }
                    else {
                        cntToDel += 1;
                    }
                }
            }
        }
    }
}
