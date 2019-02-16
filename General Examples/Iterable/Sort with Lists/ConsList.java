import java.util.Iterator;
public class ConsList<T> implements Iterable<T> {
        Cons<T> head = null, foot = null;

        public ConsList() {}

        public void append(T obj){
            if(head == null) {head = new Cons<T>(obj); foot = head;}
            else if (head==foot) {
                head.next = new Cons<T>(obj);
                foot = head.next; 
            } else {
                Cons<T> t = new Cons<T>(obj);
                foot.next = t;
                foot =t;    
            }
        }

        public boolean isEmpty() {return head == null;}
        
        public boolean contains(T obj){
            Cons it = head;
            while(it != null) {
                if( it.value.equals(obj)) return true;
                it = it.next;
            }
            return false;
        }

        public void remove(T obj) {
            if(head == null) return;
            if(head.value.equals(obj)){
                if (head == foot)
                    head = foot = null;
                else
                    head = head.next;
            } 
            else remove(this.head, this.head.next, obj);
        }

        public void remove(Cons<T> before_it, Cons<T> it, T obj){
            if(it == null) return;
            if(it.value.equals(obj)) {
                before_it.next = it.next;
            } else remove(it, it.next, obj);
        }

        public T removeHead(){
            if (head == null) return null;
            if (head == foot) {
                T tmp = head.value;
                head = foot = null;
                return tmp;
            }
            T tmp = head.value;
            head = head.next;
            return tmp;
        }

        @Override
        public String toString(){
            Cons it = head;
            String ret = "[";
            while(it != null){
                ret += it.value + ",";
                it = it.next;
            }
            return ret + "]";
        }

        public Iterator<T> iterator() {
            return new ConsListIterator();
        }

        public class ConsListIterator implements Iterator<T> {
            Cons<T> it = new Cons<T>(null);
            public ConsListIterator() {it.next = ConsList.this.head;}
            @Override
            public boolean hasNext() {return it.next != null;}
            @Override
            public T next () {it = it.next; return it.value;}
        }


}
