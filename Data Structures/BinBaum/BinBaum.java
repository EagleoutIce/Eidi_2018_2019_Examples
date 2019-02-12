public class BinBaum{

    /**
     * Implementiert einen Binärbaum ohne Suchbaum-Eigenschaft
     */

    public Node root; //Wurzelknoten

    public BinBaum(){ //Neuer, leerer Baum
        root = null;
    }

    public int size() {
        if (root == null) {
            return 0;
        } else {
            return root.size(); //Aufruf der rekursiven Methode in der Node-Klasse
        }
    }

    public void insert(int value){
        if (root == null){
            root = new Node(value); //Falls der Baum leer ist wird eine neue Root erstellt
        }
        else{
            root.insert(value); //Die rekursive Hilfsmethode wird aufgerufen (siehe Node-Klasse)
        }
    }

    public boolean isEmpty(){
        return root == null;
    }

    public boolean contains(int value){
        if (root == null){ //Leerer Baum kann nichts enthalten
            return false;
        }
        else {
            return root.contains(value); //Die rekurisve Hilfsmethode wird aufgerufen(siehe Node-Klasse)
        }
    }

}