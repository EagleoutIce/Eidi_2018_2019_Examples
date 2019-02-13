import java.util.Random;
public class Sorts{

    /**
     * Vorgestellt werden hier Bubblesort, Insertion Sort, Selection Sort und die interessanteren Sortieralgorithmen Quick- und Merge Sort
     *
     */

    public static void main(String[]args){
        //Beispiel für Bubble Sort
        int [] a = createUnsortedArray();
        System.out.println(arrayToString(a));
        bubbleSort(a);
        System.out.println(arrayToString(a));
        //Beispiel für SelectionSort
        int [] b = createUnsortedArray();
        System.out.println("\n"+arrayToString(b));
        selectionSort(b);
        System.out.println(arrayToString(b));
        //Beispiel für insertionSort
        int[]  c = createUnsortedArray();
        System.out.println("\n"+arrayToString(c));
        insertionSort(c);
        System.out.println(arrayToString(c));
        //Beispiel für QuickSort
        int[] d = createUnsortedArray();
        System.out.println("\n"+arrayToString(d));
        quickSort(d,0,a.length-1);
        System.out.println(arrayToString(d));
    }

    //Laufzeitkomplexität: O(n*log(n));
    public static void quickSort (int []a , int left, int right) {
        int pivIndex = left; //Auswahl des Pivot-Elements
        int pivValue = a[left];

        int leftcopy = left; //Kopie des Wertes left, wird später gebraucht
        int rightcopy = right; // ""

        while (left <= right) { //Läuft bis das ganze Array sortiert ist
            while (a[left] < pivValue) { //Nähert sich dem pivot-Element von links an
                left++;
            }

            while (a[right] > pivValue) { //Von Rechts
                right--;
            }

            if (left <= right) { // Vertauscht 2 Elemente, so dass sie auf der richtigen Seite des Pivot-Elements sind
                int tmp = a[left];
                a[left] = a[right];
                a[right] = tmp;
                left++;
                right--;
            }
            if (leftcopy < left) { //Rekrusiver Aufruf auf die linke Array-Hälfte
                quickSort(a, leftcopy, right);
            }
            if (rightcopy > left) { //Rekurisver Aufruf auf die rechte Array-Hälfte
                quickSort(a, left, rightcopy);
            }
        }
    }

    //Laufzeitkomplexität: O(n^2)
    public static void insertionSort(int[] unsorted){
        for (int i = 1; i<unsorted.length; i++){ //Läuft i-mal durch das ganze Array
            for (int j = i; j>0; j--){ //Läuft von i gegen 0
                if (unsorted[j] < unsorted[j-1]){ //Fügt das i-te Element sortiert ein
                    int tmp = unsorted[j];
                    unsorted[j] = unsorted[j-1];
                    unsorted[j-1] = tmp;
                }
            }
        }
    }

    //Laufzeitkomplexität: O(n^2)
    public static void selectionSort(int [] a){
        for (int i = 0; i<a.length; i++){ //Läuft i-mal durch das ganze Array
            int minPos = i; //Die Position des minimalen Elements
            for (int j = i+1; j<a.length;j++){ //Diese Schleife findet das kleinste Element im Array
                if (a[j] < a[minPos]){
                    minPos = j;
                }
            }
            int tmp = a[minPos]; //Es wird mit Stelle i vertauscht
            a[minPos] = a[i];
            a[i] = tmp;
        }
    }

    //Laufzeitkomplexität: O(n^2)
    public static void bubbleSort(int[]a){
        for (int i = 0; i<a.length;i++){ //Läuft i-mal durch das ganze Array
            for (int k = 0; k<a.length-1-i;k++){ //Läuft bis zu a.length-1-i, da die oberen i Elemente immer schon sortiert sind
                if (a[k] > a[k+1]){ //Falls ein vorhergehendes Element größer ist als der Nachfolger werden sie vertauscht
                    int tmp = a[k];
                    a[k] = a[k+1];
                    a[k+1] = tmp;
                }
            }
        }
    }

    //Erstellt neues Array mit 15 Elementen zwischen 1 und 5
    public static int[] createUnsortedArray(){
        int[] array = new int[15];
        Random random = new Random();
        for (int i = 0; i<array.length;i++){
            array[i] = random.nextInt(15)+1;
        }
        return array;
    }

    //Formatiert ein Array so, dass es in der Konsole lesbar ist
    public static String arrayToString(int[] array){
        String s = "Array: [";
        for (int i = 0; i<array.length;i++){
            if (i == array.length -1){
                s += array[i];
            }
            else {
                s += array[i]+", ";
            }
        }
        s += "]";
        return s;
    }
}