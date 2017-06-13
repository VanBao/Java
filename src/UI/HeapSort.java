package UI;

import java.util.*;

/**
 *
 * @author LE BAO
 */

public class HeapSort extends AlgorithmSort {

    public <E> void sort(E[] a, Comparator<? super E> comp) {

        for (int i = 0; i < a.length; i++) {

            add(a, i, comp);

        }

        for (int i = a.length - 1; i >= 0; i--) {

            a[i] = removeFirst(a, i, comp);

        }
    }

    private static int left(int i) {

        return 2 * i + 1;

    }

    private static int right(int i) {

        return 2 * i + 2;

    }

    private static int parent(int i) {

        return (i - 1) / 2;

    }

    private static <E> void add(E[] a, int size, Comparator<? super E> comp) {

        int i = size;

        while (i > 0) {

            int p = parent(i);

            if (comp.compare(a[i], a[p]) > 0) {

                E tmp = a[i];

                a[i] = a[p];

                a[p] = tmp;

            }

            i = parent(i);

        }

    }

    private static <E> E removeFirst(E[] a, int size, Comparator<? super E> comp) {

        E ret = a[0];

        a[0] = a[size];

        int i = 0;

        while (true) {

            int r = right(i);

            int l = left(i);

            if (l >= size) {

                break;

            }

            if (comp.compare(a[i], a[l]) >= 0) {

                if (r >= size || comp.compare(a[i], a[r]) >= 0) {

                    break;

                } else {

                    E tmp = a[i];

                    a[i] = a[r];

                    a[r] = tmp;

                    i = r;

                }
            } else {
                
                if (comp.compare(a[l], a[r]) >= 0) {

                    E tmp = a[i];

                    a[i] = a[l];

                    a[l] = tmp;

                    i = l;

                } else {

                    E tmp = a[i];

                    a[i] = a[r];

                    a[r] = tmp;

                    i = r;
                }

            }

        }

        return ret;

    }

}
