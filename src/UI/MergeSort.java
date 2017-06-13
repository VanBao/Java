package UI;

import java.util.*;

/**
 *
 * @author LE BAO
 */

public class MergeSort extends AlgorithmSort {

    public <E> void sort(E[] a, Comparator<? super E> comp) {

        mergeSort(a, 0, a.length - 1, comp);

    }

    private static <E> void mergeSort(E[] a, int from, int to, Comparator<? super E> comp) {

        if (from == to) {
            return;
        }

        int mid = (from + to) / 2;

        mergeSort(a, from, mid, comp);

        mergeSort(a, mid + 1, to, comp);

        merge(a, from, mid, to, comp);
    }

    private static <E> void merge(E[] a, int from, int mid, int to, Comparator<? super E> comp) {

        int n = to - from + 1;

        Object[] b = new Object[n];

        int i1 = from;

        int i2 = mid + 1;

        int j = 0;

        while (i1 <= mid && i2 <= to) {

            if (comp.compare(a[i1], a[i2]) < 0) {

                b[j] = a[i1];

                i1++;

            } else {

                b[j] = a[i2];

                i2++;

            }

            j++;

        }

        while (i1 <= mid) {

            b[j] = a[i1];

            i1++;

            j++;

        }

        while (i2 <= to) {

            b[j] = a[i2];

            i2++;

            j++;

        }

        for (j = 0; j < n; j++) {

            a[from + j] = (E) b[j];

        }

    }

}
