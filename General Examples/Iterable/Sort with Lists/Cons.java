public class Cons<T> {
    public T value;
    
    public Cons<T> next;
    public Cons<T> prev;

    public Cons(T value) {
        this.value = value;
    }
}
