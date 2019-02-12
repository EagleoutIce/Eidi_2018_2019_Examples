public class Node{

    public int value;
    public Node left; //Linker Kindknoten
    public Node right; //Rechter Kindknoten

    public Node(int value){ //Neuer Blattknoten
        this.value = value;
        left = null;
        right = null;
    }

    public int size(){ //Gibt die Anzahl der Knoten zurück
        int size = 1; //Aktueller Knoten
        if (left != null){ //+ alle Knoten im linken Teilbaum
            size += left.size();
        }
        if (right != null){ //+ alle Knoten im rechten Teilbaum
            size += right.size();
        }
        return size;
    }

    //Es wird versucht einen möglichst vollen Baum zu erzeugen
    public void insert(int value){
        if (left == null){ //Wenn der linke Kindknotenplatz frei ist, wird der neue Knoten dort angehängt
            Node newNode = new Node(value);
            left = newNode;
            return;
        }
        if (right == null){ //Wenn der rechte Kindknotenplatz frei ist, wird der neue Knoten dort angehängt
            Node newNode = new Node(value);
            left = newNode;
            return;
        }
        if (left.size() <= right.size()){ //Ansonsten wird rekursiv der kleiner Teilbaum aufgerufen
            left.insert(value);
            return;
        }
        else {
            right.insert(value);
        }
    }

    public boolean contains(int value){
        if (this.value == value){ //Jetziger Knoten hat den gesuchte Wert --> return true
            return true;
        }
        if (left != null){
            if (right != null){
                return left.contains(value) || right.contains(value); //Falls beide Teilbäume nicht leer sind werden beide durchsucht
            }
            else {
                return left.contains(value); //Falls nur der Linke nicht leer ist
            }
        }
        else {
            if (right != null){
                return right.contains(value); //Bzw. der rechte
            }
            else{
                return false; //Falls beide leer sind kann es nicht enthalten sein
            }
        }
    }





}