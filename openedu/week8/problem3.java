// Hashtable открытая адресация

import mooc.*;
// import java.util.LinkedList;
// import java.util.ArrayList;


class MyHashtable {
    private long[] lst;
    private int size = 20000000;
    private long p1  = 11956333;
    private long p2  =  3050759;

    MyHashtable() {
        lst = new long[size];
        for (int i = 0; i < size; i++) {
            lst[i] = (long) -1;
        }
    }

    private long firstHash(long key) {
        return key % p1;
    }

    private long secondHash(long key) {
        return (long) (key * p2);
    }

    private int mainHash(long key, int step) {
        return (int) ((firstHash(key) + step * secondHash(key)) % (size / 2) + (size / 2));
    }

    boolean containsKey(long key) {
        int step = 0;
        int hash = mainHash(key, step);


        while (lst[hash] != key && lst[hash] != -1) {
            step += 1;
            hash = mainHash(key, step);
        }

        return key == lst[hash];
    }

    void put(long key) {
        if (!containsKey(key)) {
            int step = 0;
            int hash = mainHash(key, step);


            while (lst[hash] != key && lst[hash] != -1) {
                step += 1;
                hash = mainHash(key, step);
            }
            
            lst[hash] = key;
        }
    }
}


class Index {

    public static void main(String args[]) {
        try (EdxIO io = EdxIO.create()) {
            long n, x, a, b;
            long ac, bc, ad, bd;
            int cnt = 0;
            MyHashtable m = new MyHashtable();

            n = io.nextLong();
            x = io.nextLong();
            a = io.nextLong();
            b = io.nextLong();

            ac = io.nextLong();
            bc = io.nextLong();
            ad = io.nextLong();
            bd = io.nextLong();

            for (int i = 1; i <= n; i++) {
                if (m.containsKey(x)) {
                    a = (a + ac) % (long) 1e3;
                    b = (b + bc) % (long) 1e15;
                }
                else {
                    m.put(x);

                    a = (a + ad) % (long) 1e3;
                    b = (b + bd) % (long) 1e15;
                }

                x = (x * a + b) % (long) 1e15;
            }

            io.print(x + " " + a + " " + b);
        }
    }
}
