public class ListQuickSort{
    public static void quicksort(ConsList<Integer> list){
        if(list.head == null) return;
        ConsList<Integer> left = new ConsList<Integer>();
        ConsList<Integer> right= new ConsList<Integer>();
        int pivot = list.removeHead();
        while(!list.isEmpty()){
            int insert = list.removeHead();
            if(insert < pivot) left.append(insert);
            else right.append(insert);
        }
        quicksort(left);
        quicksort(right);
        while(!left.isEmpty()){
            list.append(left.removeHead());
        }
        list.append(pivot);
        while(!right.isEmpty()){
            list.append(right.removeHead());
        }    
    }
    
    
    public static void main(String[] args){
        ConsList<Integer> a = new ConsList<Integer>();
        a.append(3); a.append(42); a.append(-13); a.append(12); a.append(43); a.append(-5); a.append(19);
        System.out.println(a);
        quicksort(a);
        System.out.println(a);
    }
} 
