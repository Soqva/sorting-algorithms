package sorting;

public final class QuickSort
{
    public static void sort(int[] array, int beginIndex, int endIndex)
    {
        if (beginIndex >= endIndex)
            return;

        int middleIndex = (beginIndex + endIndex) / 2;
        int middleElement = array[middleIndex];
        int leftIndex = beginIndex;
        int rightIndex = endIndex;
        int temp;

        do
        {
            while (array[leftIndex] < middleElement)
                leftIndex++;

            while (array[rightIndex] > middleElement)
                rightIndex--;

            if (leftIndex <= rightIndex)
            {
                temp = array[leftIndex];
                array[leftIndex] = array[rightIndex];
                array[rightIndex] = temp;

                leftIndex++;
                rightIndex--;
            }
        } while (leftIndex < rightIndex);

        if (beginIndex < rightIndex)
            sort(array, beginIndex, rightIndex);

        if (leftIndex < endIndex)
            sort(array, leftIndex, endIndex);
    }
}
