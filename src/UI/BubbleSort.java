package UI;

import java.util.*;

/**
 *
 * @author LE BAO
 */

public class BubbleSort extends AlgorithmSort {

    public <E> void sort(E[] a, Comparator<? super E> comp) {

        goSort(a, comp);

    }

    private static <E> void goSort(E[] a, Comparator<? super E> comp) {

        for (int i = 0; i < a.length - 1; i++) {

            for (int j = 0; j < a.length - 1 - i; j++) {

                if (comp.compare(a[j], a[j + 1]) > 0) {

                    E tmp = a[j];

                    a[j] = a[j + 1];

                    a[j + 1] = tmp;

                }

            }

        }

    }

}
