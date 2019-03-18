import java.util.Arrays;

public class MergeSort {

    public static int[] parallelMergeSort(int[] a) {
        int cores = 8;
        return parallelMergeSort(a, cores);
    }

    public static int[] parallelMergeSort(int[] data, int threadCount) {
        if (threadCount <= 1) {
            return data;
        } else if (data.length >= 2) {
            int middle_point = data.length/2;
            int[] left  = Arrays.copyOfRange(data, 0, middle_point);
            int[] right = Arrays.copyOfRange(data, middle_point, data.length);

            Thread lThread = new Thread(new Sorter(left,  threadCount / 2));
            Thread rThread = new Thread(new Sorter(right, threadCount / 2));
            lThread.start();
            rThread.start();

            try {
                lThread.join();
                rThread.join();
            } catch (InterruptedException ie) {}

            data = merge(left, right, data);
        }
        return data;
    }

    public static int[] merge(int[] left, int[] right, int[] a) {
        int i1 = 0;
        int i2 = 0;
        for (int i = 0; i < a.length; i++) {
            if (i2 >= right.length || (i1 < left.length && left[i1] < right[i2])) {
                a[i] = left[i1];
                i1++;
            } else {
                a[i] = right[i2];
                i2++;
            }
        }
        return a;
    }


    public static int[] mergeSort(int ...data){
        int merged[] = new int[data.length];

        if (data.length == 1){
            return data;
        }

        int middle_point = data.length/2;
        int first[] = mergeSort(Arrays.copyOfRange(data,
                0, middle_point));
        int second[] = mergeSort(Arrays.copyOfRange(data,
                middle_point, data.length));

        int idx_1 = 0, idx_2 = 0;
        for (int idx=0; idx<(first.length+second.length); idx++ ){
            int value1 = Integer.MAX_VALUE;
            int value2 = Integer.MAX_VALUE;

            if (first.length > idx_1){
                value1 = first[idx_1];
            }

            if (second.length > idx_2){
                value2 = second[idx_2];
            }

            int sorted = Math.min(value1, value2);

            if(sorted == value1){
                idx_1++;
            } else {
                idx_2++;
            }

            merged[idx] = sorted;
        }

        return merged;
    }

}

