package UI;

import java.util.*;

/**
 *
 * @author LE BAO
 */

public class InsertionSort extends AlgorithmSort {

    public <E> void sort(E[] a, Comparator<? super E> comp) {

        goSort(a, comp);

    }

    private static <E> void goSort(E[] a, Comparator<? super E> comp) {

        for (int i = 1; i < a.length; i++) {

            E curr = a[i];

            int j = i;

            while(j > 0 && comp.compare(a[j - 1], curr) > 0){
                
                a[j] = a[j - 1];
                
                j--;
                
            }
            
            a[j] = curr;

        }

    }

}
