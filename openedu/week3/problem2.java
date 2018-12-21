import mooc.*;


class RadixSort {
    static int[] sort(byte[][] arr, int[] indexes, int n, int m, int k) {
        int[] counted = new int[123];
        int[] b = new int[n];
        int[] temp;
        byte[] cur;

        for (int j = m - 1; j > m - 1 - k; j--) {
            cur = arr[j];

            for (int i = 97; i <= 122; i++) {
                counted[i] = 0;
            }

            for (int i = 0; i < n; i++) {
                counted[cur[i]] += 1;
            }

            for (int i = 98; i <= 122; i++) {
                counted[i] += counted[i - 1];
            }

            for (int i = n - 1; i >= 0; i--) {
                int index = indexes[i];
                int symbol = cur[index];
                b[counted[symbol] - 1] = index;
                counted[symbol] -= 1;
            }

            temp = indexes;
            indexes = b;
            b = temp;
        }

        return indexes;
    }
}


class Index {
    public static void main(String args[]) {
        try (EdxIO io = EdxIO.create()) {
            int n, m, k;
            
            n = io.nextInt();
            m = io.nextInt();
            k = io.nextInt();

            byte[][] arr = new byte[m][];
            int indexes[] = new int[n];

            for (int j = 0; j < m; j++) {
                arr[j] = io.nextBytes();
            }

            for (int i = 0; i < n; i++) {
                indexes[i] = i;
            }

            indexes = RadixSort.sort(arr, indexes, n, m, k);

            for (int i = 0; i < n; i++) {
                io.print(indexes[i] + 1).print(' ');
            }
        }
    }
}
