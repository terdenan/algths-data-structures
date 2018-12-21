import mooc.*;
import java.util.ArrayList;

class MyClass {
    public double value;
    public int index;

    public MyClass(double v, int i) {
        value = v;
        index = i;
    }
}

class Index {
    public static void main(String args[]) {
        try (EdxIO io = EdxIO.create()) {
            int n;
            ArrayList<MyClass> lst = new ArrayList<MyClass>();

            n = io.nextInt();
            for (int i = 0; i < n; i++) {
                MyClass item = new MyClass(io.nextDoublePrecise(), i + 1);
                lst.add(item);
            }

            for (int j = 1; j < n; j++) {
                int i = j;
                while (i > 0 && lst.get(i - 1).value > lst.get(i).value) {
                    MyClass c = lst.get(i - 1);
                    lst.set(i - 1, lst.get(i));
                    lst.set(i, c);
                    i -= 1;
                }
            }

            io.print(lst.get(0).index + " " + lst.get(n / 2).index + " " + lst.get(n - 1).index);
        }
    }
}