public class Cons{
    public int value; //Zahlenwert (auch mit allen anderen Datentypen möglich, u.a. Generics)
    public Cons next; //Referenz aufs Nachfolger-Element

    public Cons(int value){ //Konstruktor
        this.value = value;
        next = null;
    }
}