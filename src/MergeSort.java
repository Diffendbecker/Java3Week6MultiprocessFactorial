import java.util.Arrays;

public class MergeSort {

    public static int[] parallelMergeSort(int[] a) throws InterruptedException {

        int middle_point = a.length/2;
        int[] subArr1 = new int[middle_point];
        int[] subArr2 = new int[a.length - middle_point];
        System.arraycopy(a, 0, subArr1, 0, middle_point);
        System.arraycopy(a, middle_point, subArr2, 0, a.length - middle_point);

        Sorter runner1 = new Sorter(subArr1);
        Sorter runner2 = new Sorter(subArr2);
        runner1.start();
        runner2.start();
        runner1.join();
        runner2.join();
        return merge (runner1.getInternal(), runner2.getInternal());
    }

    public static int[] merge(int[] a, int[] b) {
        int[] result = new int[a.length + b.length];
        int i = 0;
        int j = 0;
        int r = 0;
        while (i < a.length && j < b.length) {
            if (a[i] <= b[j]) {
                result[r] = a[i];
                i++;
                r++;
            } else {
                result[r] = b[j];
                j++;
                r++;
            }
            if (i == a.length) {
                while (j < b.length) {
                    result[r] = b[j];
                    r++;
                    j++;
                }
            }
            if (j == b.length) {
                while (i < a.length) {
                    result[r] = a[i];
                    r++;
                    i++;
                }
            }
        }
        return result;
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

