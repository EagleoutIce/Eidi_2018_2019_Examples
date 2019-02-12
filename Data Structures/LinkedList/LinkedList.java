public class LinkedList{
    /**
     * Implementiert eine einfach verkettete Liste
     */
    public Cons head; //Erstes
    public Cons foot; //bzw. letzes Element der Liste

    public LinkedList(){ //Erstellt eine neue leere Liste
        head = foot = null;
    }

    public boolean contains(int searched){ //Gibt zurück ob die Liste einen bestimmten Wert enthält
        if (head == null){ //Leere Liste kann nichts enthalten
            return false;
        }
        return contains(head,searched); //Aufruf der rekursiven Hilfsmethode mit dem ersten Element
    }

    public boolean contains(Cons cons, int searched){
        if (cons.value == searched){ //Falls das derzeitige Element den gesuchten Wert besitzt
            return true;
        }
        else {
            if (cons.next == null){ //Das derzeitige Element ist das letze und besitzt nicht den gesuchten Wert
                return false; //Also ist der gesuchte Wert nicht in der Liste
            }
            else { //Falls noch Nachfolger-Elemente existieren werden diese rekursiv überprüft
                return contains(cons.next,searched);
            }
        }
    }

    public void insert(int value){ //Fügt neues Element am Anfang der Liste hinzu
        Cons newElement = new Cons(value); //Erstellt neues Element
        if (head == null){ //Falls die Liste Leer ist werden sowohl head als auch foot auf das neue einzige Element gesetzt
            head = foot = newElement;
        }
        else {
            newElement.next = head; //Referenz auf das aktuell Erste Element erstellen
            head = newElement; //New Element ist der neue head
        }
    }

    public void append(int value) { //Fügt neues Element am Ende der Liste hinzu
        Cons newElement = new Cons(value); //Erstellt neues Element
        if (head == null){ //Falls die Liste Leer ist werden sowohl head als auch foot auf das neue einzige Element gesetzt
            head = foot = newElement;
        }
        else {
            foot.next = newElement; //Referenz vom aktuellen auf das neue letze Element
            foot = newElement; //New Element ist der neue foot
        }
    }

    public boolean remove(int toBeRemoved){ //Liefert false wenn das element gar nicht enthalten war
        if (head == null){ //Leere Liste enthält nichts
            return false;
        }
        if (head.value == toBeRemoved){ //Kopf entfernen
            if (head == foot){ //Falls Liste einelementig ist
                head = foot = null;
            }
            else { //Falls sie mehrelementig ist
                head = head.next;
            }
            return true;
        }
        else if (head.next != null){ //Aufruf der rekursiv Hilfsmethode
            return remove(head,head.next,toBeRemoved);
        }
        else { //Liste war einelemntig und head wurde schon überprüft
            return false;
        }
    }

    public boolean remove(Cons prev,Cons cons, int toBeRemoved){ //Rekursive Hilfsmethode
        if (cons.value == toBeRemoved){
            if (cons.next != null){ //Falls cons nicht das letze Element ist
                prev.next = cons.next;
            }
            else {      //Falls es das letze Element ist
                prev.next = null;
                foot = prev;//Vorgänger wird foot
            }
            return true; //Wurde entfernt --> True wird zurückgegeben
        }
        else {
            if (cons.next != null){ //Falls das Ende der Liste noch nicht erreicht wurde wird rekursiv das nächste Element untersucht
                return remove(cons,cons.next,toBeRemoved);
            }
            else { //Ansonsten ist es nicht in der Liste
                return false;
            }
        }
    }

    public void print(){
        if (head == null){ //Leere Liste
            System.out.println("Liste: []");
        }
        else { //Nicht leere Liste
            System.out.print("Liste: [");
            print(head); //Aufruf der rekursiven Hilfsmethode
            System.out.print("]");

        }
    }

    public void print(Cons cons){
        if (cons.next != null){//Falls das derzeitige Elemnt nicht das letze ist
            System.out.print(cons.value+", ");//Wert wird passend formatiert ausgegeben
            print(cons.next); //Rekurisver Aufrufmit dem Nachfolger
        }
        else {
            System.out.print(cons.value); //Falls das derzeitige Element das Letze ist wird nur der Wert ausgegeben
        }
    }

    public boolean isEmpty(){
        return head == null;
    }
}