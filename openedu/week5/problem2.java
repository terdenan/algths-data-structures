import mooc.*;
import java.util.Stack;


class Elem {
    int value, index;

    Elem(int v, int i) {
        value = v;
        index = i;
    }
}

class Index {

    public static void main(String args[]) {
        try (EdxIO io = EdxIO.create()) {
            int n, size = 0;
            String command;
            Elem[] a = new Elem[1000010];
            Elem[] storage = new Elem[1000010];
            Elem temp;
            
            n = io.nextInt();

            for (int i = 1; i <= n; i++) {
                command = io.next();

                if (command.equals("A")) {
                    int num = io.nextInt();

                    size += 1;

                    Elem elem = new Elem(num, size);

                    storage[i] = elem;
                    a[size] = elem;

                    int j = size;
                    while (j / 2 >= 1 && a[j].value < a[j / 2].value) {
                        temp = a[j];

                        a[j] = a[j / 2];
                        a[j].index = j;

                        a[j / 2] = temp;
                        a[j / 2].index = j / 2;

                        j /= 2;
                    }
                }
                else if (command.equals("X")) {
                    if (size == 0) {
                        io.println("*");
                    }
                    else {
                        io.println(a[1].value);

                        a[1] = a[size];
                        a[1].index = 1;
                        size -= 1;

                        int j = 1;
                        while (j * 2 <= size && a[j].value > a[j * 2].value ||
                               j * 2 + 1 <= size && a[j].value > a[j * 2 + 1].value) {

                            if (j * 2 + 1 <= size && a[j * 2 + 1].value < a[j * 2].value) {
                                temp = a[j];

                                a[j] = a[j * 2 + 1];
                                a[j].index = j;

                                a[j * 2 + 1] = temp;
                                a[j * 2 + 1].index = j * 2 + 1;

                                j = j * 2 + 1;
                            }
                            else {
                                temp = a[j];

                                a[j] = a[j * 2];
                                a[j].index = j;

                                a[j * 2] = temp;
                                a[j * 2].index = j * 2;

                                j = j * 2;
                            }
                        }
                    }
                }
                else {
                    int x, y;

                    x = io.nextInt();
                    y = io.nextInt();

                    storage[x].value = y;

                    int j = storage[x].index;

                    while (j / 2 >= 1 && a[j].value < a[j / 2].value) {
                        temp = a[j];

                        a[j] = a[j / 2];
                        a[j].index = j;

                        a[j / 2] = temp;
                        a[j / 2].index = j / 2;

                        j /= 2;
                    }
                }
            }
        }
    }
}
