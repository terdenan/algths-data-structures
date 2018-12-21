import mooc.*;


class Index {
    public static int hashOf(String s, int multiple) {
        int rv = 0;
        for (int i = 0; i < s.length(); ++i) {
            rv = multiple * rv + s.charAt(i);
        }
        return rv;
    }

    static String tueMors(String s) {
        String new_s = "";

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'b')
                new_s += "a";
            else
                new_s += "b";
        }

        return new_s;
    }

    static String[] raise(String[] s) {
        int inserted = 0;
        int size = Math.min(s.length, 40);
        String[] new_s = new String[s.length * size];

        for (int i = 0; i < s.length; i++) {
            for (int j = 0; j < size; j++) {
                if (inserted >= 10000) {
                    return new_s;
                }
                new_s[inserted++] = s[i] + s[j];
            }
        }

        return new_s;
    }

    public static void main(String args[]) {
        try (EdxIO io = EdxIO.create()) {
            String[] s = new String[2];
            s[0] = "abbabaabbaababbabaababbaabbabaabbaababbaabbabaababbabaabbaababbabaababbaabbabaababbabaabbaababbaabbabaabbaababbabaababbaabbabaab";
            s[1] = "baababbaabbabaababbabaabbaababbaabbabaabbaababbabaababbaabbabaababbabaabbaababbabaababbaabbabaabbaababbaabbabaababbabaabbaababba";

            for (int i = 2; i <= 5; i++) {
                s = raise(s);
            }
            
            int n;
            n = io.nextInt();
            for (int i = 0; i < n; i++) {
                io.println(s[i] + "cccccccccccccccccccccccccccccccccccccccccc");
            }
        }
    }
}
