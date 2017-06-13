package UI;

import java.util.*;

/**
 *
 * @author LE BAO
 */

public class QuickSort extends AlgorithmSort {

    public <E> void sort(E[] a, Comparator<? super E> comp) {

        goSort(a, 0, a.length - 1, comp);

    }

    private static <E> void goSort(E[] a, int from, int to, Comparator<? super E> comp) {

        if (from >= to) {
            return;
        }

        E mid = a[from];

        int midIndex = partition(a, from, mid, to, comp);

        a[midIndex] = mid;

        goSort(a, from, midIndex - 1, comp);

        goSort(a, midIndex + 1, to, comp);
    }

    private static <E> int partition(E[] a, int from, E mid, int to, Comparator<? super E> comp) {

        int next = from;

        while (true) {

            if (to == from) {

                break;

            }
            E curr = a[next];

            if (comp.compare(mid, curr) > 0) {

                a[from] = curr;

                from++;

                next = from;

            } else {

                a[to] = curr;

                to--;

                next = to;

            }

        }

        return from;

    }

}
