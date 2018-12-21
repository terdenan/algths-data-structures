import mooc.*;
import java.util.HashMap;

class Elem {
    String value;
    Elem prev, next;

    Elem(String v) {
        value = v;
    }
}


class Index {

    public static void main(String args[]) {
        try (EdxIO io = EdxIO.create()) {
            int n;
            String command, key, value;
            HashMap<String, Elem> m = new HashMap<String, Elem>();
            Elem lastElem = null;

            n = io.nextInt();

            for (int i = 1; i <= n; i++) {
                command = io.next();
                key = io.next();

                if (command.equals("get")) {
                    if (m.containsKey(key)) {
                        io.println(m.get(key).value);
                    }
                    else {
                        io.println("<none>");
                    }
                }
                else if (command.equals("prev")) {
                    if (m.containsKey(key) && m.get(key).prev != null) {
                        io.println(m.get(key).prev.value);
                    }
                    else {
                        io.println("<none>");
                    }
                }
                else if (command.equals("next")) {
                    if (m.containsKey(key) && m.get(key).next != null) {
                        io.println(m.get(key).next.value);
                    }
                    else {
                        io.println("<none>");
                    }
                }
                else if (command.equals("put")) {
                    value = io.next();

                    if (m.containsKey(key)) {
                        Elem elemToUpd = m.get(key);
                        elemToUpd.value = value;
                    }
                    else {
                        Elem newElem = new Elem(value);

                        if (lastElem != null) {
                            lastElem.next = newElem;
                            newElem.prev = lastElem;
                        }

                        lastElem = newElem;

                        m.put(key, newElem);
                    }
                }
                else {
                    if (m.containsKey(key)) {
                        Elem elemToDel = m.get(key);

                        if (elemToDel == lastElem) {
                            if (elemToDel.prev != null) {
                                elemToDel.prev.next = null;
                                lastElem = elemToDel.prev;
                            }
                            else {
                                lastElem = null;
                            }
                        }
                        else {
                            if (elemToDel.prev != null) {
                                elemToDel.prev.next = elemToDel.next;
                                elemToDel.next.prev = elemToDel.prev;
                            }
                            else {
                                elemToDel.next.prev = null;
                            }
                        }

                        m.remove(key);
                    }
                }
            }

        }
    }
}
