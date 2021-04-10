package sorting;

public final class HeapSort
{
    public static void sort(int[] array)
    {
        int arraySize = array.length;
        int temp;

        for (int i = arraySize / 2 - 1; i >= 0; i--)
            createPyramid(array, arraySize, i);

        for (int i = arraySize - 1; i > 0; i--)
        {
            temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            createPyramid(array, i, 0);
        }
    }

    private static void createPyramid(int[] array, int arraySize, int parentIndex)
    {
        int leftChildIndex = 2*parentIndex + 1;
        int rightChildIndex = 2*parentIndex + 2;
        int maxChildIndex;
        int temp;

        if (rightChildIndex < arraySize && array[leftChildIndex] < array[rightChildIndex])
            maxChildIndex = rightChildIndex;
        else
            maxChildIndex = leftChildIndex;

        while (parentIndex < arraySize / 2 && array[parentIndex] < array[maxChildIndex])
        {
            temp = array[parentIndex];
            array[parentIndex] = array[maxChildIndex];
            array[maxChildIndex] = temp;

            parentIndex = maxChildIndex;
            leftChildIndex = 2*parentIndex + 1;
            rightChildIndex = 2*parentIndex + 2;

            if (rightChildIndex < arraySize && array[leftChildIndex] < array[rightChildIndex])
                maxChildIndex = rightChildIndex;
            else
                maxChildIndex = leftChildIndex;
        }
    }
}
