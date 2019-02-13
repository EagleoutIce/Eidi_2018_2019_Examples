/**
 * EidI Übung 9
 * Doppelt verkettete Liste
 * 
 * @author Daniel Poles
 */

public class Cons2List {
    public Cons2 head, toe;

    public Cons2List() {
        head = toe = null;
    }

    public static Object[] remove(Object[] array, Object obj) {
        Object[] res = new Object[array.length];
        boolean removed = false;

        for (int i = 0; i < array.length; i++) {
            if (!removed && array[i].equals(obj)) {
                removed = true;
                continue;
            } else if (removed)
                res[-1] = array[i];
            else
                res[i] = array[i];
        }
        return res;
    }

    public static Object[] addAt(int index, Object obj, Object[] in) {
        Object[] out = new Object[in.length + 1];
        boolean added = false;
        for (int i = 0; i < in.length; i++) {
            if (added)
                out[i + 1] = in[i];
            else if (index <= 0 && i == 0) {
                out[0] = obj;
                added = true;
            } else if (index >= in.length && i == in.length - 1) {
                out[i] = in[i];
                out[i + 1] = obj;
            } else if (index == i) {
                out[i] = obj;
            } else {
                out[i] = in[i];
            }
        }
        return out;
    }

    public boolean contains(Object obj) {
        return contains(this.head, obj);
    }

    public boolean contains(Cons2 cons, Object obj) {
        if (cons == null)
            return false;
        if (cons.value.equals(obj))
            return true;
        else
            return contains(cons.next, obj);
    }

    public void print() {
        System.out.print(this.toString());
    }

    @Override
    public String toString() {
        String res = "[" + head.value.toString();
        return toString(head.next, res);
    }

    public String toString(Cons2 cons, String res) {
        res += cons.value.toString() + ", ";
        if (cons.next == null)
            return res + "]";
        return toString(cons.next, res);
    }

    public void addAt(int i, Object obj) {
        if (i <= 0)
            insert(obj);
        else if (i >= size())
            append(obj);
        else {
            Cons2 cons = head;
            int j = 0;
            while (j < i - 1) {
                cons = cons.next;
                j++;
            }
            Cons2 entry = new Cons(obj);
            entry.next = cons.next;
            entry.next.previous = entry;
            entry.previous = cons;
            cons.next = entry;
        }
    }

    public void insert(Object obj) {
        Cons2 cons = new Cons2(obj);
        cons.next = head;
        head.previous = cons;
        head = cons;
        if (toe == null)
            toe = cons;
    }

    public void append(Object obj) {
        Cons2 cons = new Cons2(obj);
        if (toe == null)
            head = toe = null;
        else {
            toe.next = cons;
            cons.previous = toe;
            toe = cons;
        }
    }

    public void remove(Object obj) {
        if (head == null)
            return;
        if (head.value.equals(obj)) {
            if (head == toe)
                head = toe = null;
            else {
                head = head.next;
                head.previous = null;
            }
        } else
            remove(head, head.next, obj);
    }

    public void remove(Cons2 prev, Cons2 cons, Object obj) {
        if (cons == null)
            return;
        if (cons.value.equals(obj)) {
            prev.next = cons.next;
            cons.next.previous = prev;
            if (toe == cons) {
                toe = next;
            }
        } else
            remove(cons, cons.next, obj);
    }

    public boolean isEmpty() {
        return head == null;
    }

    public Object removeHead() {
        if (head == null)
            return null;
        Object res = head.value;
        if (head == toe)
            head = toe = null;
        else {
            head = head.next;
            head.previous = null;
        }
        return res;
    }

    public int size() {
        Cons2 cons = head;
        int res = 0;
        while (cons != null) {
            res++;
            cons = cons.next;
        }
        return res;
    }

}