import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.Random;

class MergeSortTest {
    @Test
    public void mergeSort(){
        //int values[] = {5,4,7,6};

        int values[] = GetLongArrayOfNumbers();
        long startTime = System.currentTimeMillis();
        int[] result = MergeSort.mergeSort(values);
        long totalTimeMs = System.currentTimeMillis() - startTime;
        String resultStr = Arrays.toString(result);
        System.out.println("Time ms: " + totalTimeMs + " Result: " + resultStr);
    }

    @Test
    public void parallelMergeSort() throws InterruptedException {
        //int values[] = {22,9,5,4,7,6};
        int values[] = GetLongArrayOfNumbers();
        long startTime = System.currentTimeMillis();
        int[] result = MergeSort.parallelMergeSort(values);
        long totalTimeMs = System.currentTimeMillis() - startTime;
        String resultStr = Arrays.toString(result);
        System.out.println("Time ms: " + totalTimeMs + " Result: " + resultStr);

    }

    private int[] GetLongArrayOfNumbers()
    {
        int numbersCount = 20000000;

        Random rand = new Random();
        int[] numbers = new int[numbersCount];
        for(int i =0; i<numbersCount; i++)
        {
            numbers[i] = rand.nextInt(100);
        }

        return numbers;
    }
}