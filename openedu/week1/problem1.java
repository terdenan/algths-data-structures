import mooc.*;

class Index {
    public static void main(String args[]) {
        try (EdxIO io = EdxIO.create()) {
            long a = io.nextLong();
            long b = io.nextLong();
            io.println(a + b);
        }
    }
}