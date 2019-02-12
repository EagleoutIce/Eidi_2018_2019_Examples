public class Stack{

    /**
     * Implementiert einen FIFO-Stack (First-in-First-out)
     */

    public Cons head; //Oberstes Element des Stack

    public Stack(){ //Erstellt neuen Stack
        head = null;
    }

    public boolean isEmpty(){ //Oberstes Element == Null --> Stack ist leer
        return head == null;
    }

    public void push(int value){ //"Pusht" ein neues Element oben auf den Stack
        if (head == null){ //Falls head null ist wird er erstellt
            head = new Cons(value);
        }
        else { //Ansonsten wird er oben angefügt
            Cons newElement = new Cons(value); //Neues Element wird erstellt
            newElement.next = head; //Referenz wird auf das derzeit oberste gesetzt
            head = newElement; //Das neue Element ist das neue oberste
        }
    }

    public int pop(){ //Entfernt das oberste Element des Stacks und gibt den Wert zurück
        if (head == null){ //Falls der Stack Leer ist
            return Integer.MIN_VALUE; //Irgendein Wert muss zurückgegeben werden, üblich sind -1 oder minimale bzw. maximale Werte
        }
        else {
            int result = head.value; //Wert des obersten Elements
            if (head.next != null){ //Falls es ein zweites Element gibt wird es zum neusten obersten Element gemacht
                head = head.next;
            }
            else { //Ansonsten wird es auf null gesetzt
                head = null;
            }
            return result; //Gibt den Wert zurück
        }
    }



}