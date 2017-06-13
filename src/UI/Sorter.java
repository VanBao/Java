package UI;

import java.util.*;

/**
 *
 * @author LE BAO
 */

public class Sorter implements Runnable {

    private Integer[] values;

    private String algorithm;

    private ArrayComponent panel;

    private int speed;
    
    private int order;

    private final String SELECTION_SORT = "select";

    private final String HEAP_SORT = "heap";

    private final String INSERTION_SORT = "insert";

    private final String QUICK_SORT = "quick";

    private final String MERGE_SORT = "merge";

    private final String BUBBLE_SORT = "bubble";
    
    private final int ASCENDING = 1;
    
    private final int DESCENDING = 2;
    
    private boolean isLessThan20;

    public Sorter(ArrayComponent panel, Integer[] values, String algorithm, int speed, int order) {

        this.panel = panel;

        this.values = values;

        this.algorithm = algorithm;

        this.speed = speed;
        
        this.order = order;
        
        if(isLessThan20()){
            
            this.isLessThan20 = true;
            
        }else{
            
            this.isLessThan20 = false;
            
        }

    }
    
    private boolean isLessThan20(){
        
        for(int i = 0; i < values.length; i++){
            
            if(values[i] > 20){
                
                return false;
                
            }
            
        }
        
        return true;
    }

    @Override
    public void run() {

        panel.reset();

        Comparator<Integer> comp = new Comparator<Integer>() {

            @Override
            public int compare(Integer d1, Integer d2) {

                panel.setValues(values, d1, d2, isLessThan20);

                try {

                    Thread.sleep(speed);

                } catch (InterruptedException exception) {

                    Thread.currentThread().interrupt();

                }
                if(order == DESCENDING){
                    
                    return (d2).compareTo(d1);
                    
                }
                return (d1).compareTo(d2);
                
            }

        };
        
        AlgorithmSort algorithmSort = null;

        switch (algorithm) {

            case SELECTION_SORT:
                
                algorithmSort = new SelectionSort();

                algorithmSort.sort(values, comp);

                break;

            case HEAP_SORT:
                
                algorithmSort = new HeapSort();

                algorithmSort.sort(values, comp);

                break;

            case INSERTION_SORT:
                
                algorithmSort = new InsertionSort();

                algorithmSort.sort(values, comp);

                break;

            case QUICK_SORT:
                
                algorithmSort = new QuickSort();

                algorithmSort.sort(values, comp);

                break;

            case MERGE_SORT:
                
                algorithmSort = new MergeSort();

                algorithmSort.sort(values, comp);

                break;

            case BUBBLE_SORT:
                
                algorithmSort = new BubbleSort();

                algorithmSort.sort(values, comp);

                break;

        }

        panel.setValues(values, null, null, this.isLessThan20);

    }
}
