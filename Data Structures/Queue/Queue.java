public class Queue{

    /**
     * Implementiert eine FIFO-Queue (First-In-First-Out)
     **/

    public Cons head; //Referenz auf das erste Element der Queue
    public Cons foot; //Referenz auf das letze Element der Queue

    public
    Queue() { //Erstellt neue leere Liste
        head = null;
        foot = null;
    }

    public
    void enqueue(int value) { //Fügt ein neues Element ans Ende der Liste an
        if (isEmpty()) { //Falls die Liste leer ist
            head = foot = new Cons(value);
        } else { //Falls nicht wird sie am Ende angefügt
            Cons newElement = new Cons(value); //Erstelle Cons-Element
            foot.next = newElement; //Setze Referenz vom derzeitig letzen Element auf das neue Cons-Element
            foot = newElement; //Setze das neue Cons-Element als foot (letzes Element)
        }
    }

    public
    boolean isEmpty() { //Falls head und foot null sind ist die Liste leer
        return head == null && foot == null;
    }

    public
    int dequeue() {
        if (head == null) { //Liste ist leer
            return Integer.MIN_VALUE; //Platzhalter, da es bei primitiven Datentypen keinen null-Pointer geben kann
        } else {
            int result = head.value; //Speichere Zahl des head
            if (head.next != null) { //Falls es ein nächstes Element gibt
                head = head.next; //Setze head auf das nächste Element
            }
            else { //Falls nicht ist die Queue wieder leer
                head = null;
            }
            return result; //Gib die Zahl zurück
        }
    }
}