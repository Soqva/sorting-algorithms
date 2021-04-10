import sorting.HeapSort;
import sorting.QuickSort;
import sorting.TopDownMergeSort;

import java.util.Arrays;
import java.util.Random;

public class SortingRunner
{
    public static void main(String[] args)
    {
        int arraySize = 1000000;

        for (int i = 0; i < 5; i++)
            compareSorting(arraySize);
    }

    private static void compareSorting(int arraySize)
    {
        int[] firstArray = createArray(arraySize);
        int[] secondArray = Arrays.copyOf(firstArray, arraySize);
        int[] thirdArray = Arrays.copyOf(firstArray, arraySize);
        long time;

        time = System.currentTimeMillis();
        QuickSort.sort(firstArray, 0, arraySize - 1);
        System.out.printf("QuickSort: %.3f seconds\n",
                (double) System.currentTimeMillis() / 1000. - time / 1000.);

        time = System.currentTimeMillis();
        HeapSort.sort(secondArray);
        System.out.printf("HeapSort: %.3f seconds\n",
                (double) System.currentTimeMillis() / 1000. - time / 1000.);

        time = System.currentTimeMillis();
        TopDownMergeSort.sort(thirdArray, 0, arraySize - 1);
        System.out.printf("TopDownMergeSort: %.3f seconds\n\n",
                (double) System.currentTimeMillis() / 1000. - time / 1000.);
    }

    private static int[] createArray(int arraySize)
    {
        Random random = new Random();
        int[] array = new int[arraySize];

        for (int i = 0; i < arraySize; i++)
            array[i] = random.nextInt(101) - random.nextInt(51);

        return array;
    }

    private static void printArrayElements(int[] array)
    {
        for (int element : array)
            System.out.printf("%4d", element);
    }
}
