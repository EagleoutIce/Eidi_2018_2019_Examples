/**
 * EidI Übung 9
 * Doppelt verkettete Liste
 * 
 * @author Daniel Poles
 */

public class Cons2 {
    public Object value;
    public Cons2 next, previous;
    public ObjectCons(Object obj) {
        this.value = obj;
        this.next = this.previous = null;
    }

    public String toString() {
        return this.value.toString();
    }
}