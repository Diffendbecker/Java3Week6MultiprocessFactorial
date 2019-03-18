import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class MergeSortTest {
    @Test
    public void mergeSort(){
        int values[] = {5,4,7,6};
        System.out.println(Arrays.toString(MergeSort.mergeSort(values)));

    }

    @Test
    public void parallelMergeSort(){
        int values[] = {5,4,7,6};
        System.out.println(Arrays.toString(MergeSort.parallelMergeSort(values)));

    }

}