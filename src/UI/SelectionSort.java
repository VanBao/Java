package UI;

import java.util.*;

/**
 *
 * @author LE BAO
 */

public class SelectionSort extends AlgorithmSort {

    public <E> void sort(E[] a, Comparator<? super E> comp) {

        for (int i = 0; i < a.length - 1; i++) {

            for (int j = i + 1; j < a.length; j++) {

                if (comp.compare(a[j], a[i]) < 0) {

                    E temp = a[j];

                    a[j] = a[i];

                    a[i] = temp;

                }
            }

        }

    }

}
