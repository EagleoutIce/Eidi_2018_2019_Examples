public class Mergesort{
    public static void mergesort(ConsList<Integer> list){
        if(list.isEmpty() || list.size() == 1) return;
        ConsList<Integer> left = new ConsList<Integer>();
        ConsList<Integer> right = new ConsList<Integer>();
        int size = list.size();
        for(int i = 0; i<size/2; i++){
            left.append(list.removeHead());
        }
        for(int j = size/2; j < size; j++){
            right.append(list.removeHead());
        }
        mergesort(left);
        mergesort(right);

        /******************
         *merge that shit!*
         ******************/

        while(!(left.isEmpty() && right.isEmpty())){
            if(left.isEmpty()){
                while(!right.isEmpty()){
                    list.append(right.removeHead());
                }
            }
            else if(right.isEmpty()){
                while(!left.isEmpty()){
                    list.append(left.removeHead());
                }
            }    
            else {
                if(left.head.value> right.head.value){
                    list.append(right.removeHead());
                }
                else {
                    list.append(left.removeHead());    
                }    
            }
        }    
    }
    public static void main(String[] args){
        ConsList<Integer> a = new ConsList<Integer>();
        a.append(3); a.append(42); a.append(-13); a.append(12); a.append(43); a.append(-5); a.append(19);
        System.out.println(a);
        mergesort(a);
        System.out.println(a);
    }
}
