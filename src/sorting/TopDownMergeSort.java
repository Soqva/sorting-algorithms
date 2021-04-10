package sorting;

public class TopDownMergeSort
{
    public static void sort(int[] array, int beginIndex, int endIndex)
    {
        if (beginIndex >= endIndex)
            return;

        int middleIndex = (beginIndex + endIndex) / 2;

        sort(array, beginIndex, middleIndex);
        sort(array, middleIndex + 1, endIndex);

        merge(array, beginIndex, endIndex, middleIndex + 1);
    }

    private static void merge(int[] array, int beginIndex, int endIndex, int middleIndex)
    {
        int[] tempArray = new int[endIndex - beginIndex + 1];
        int leftIndex = beginIndex;
        int rightIndex = middleIndex;
        int position = 0;

        while (leftIndex < middleIndex && rightIndex <= endIndex)
        {
            if (array[leftIndex] < array[rightIndex])
            {
                tempArray[position++] = array[leftIndex];
                leftIndex++;
            }
            else if (array[leftIndex] > array[rightIndex])
            {
                tempArray[position++] = array[rightIndex];
                rightIndex++;
            }
            else
            {
               tempArray[position++] = array[leftIndex];
               tempArray[position++] = array[rightIndex];
               leftIndex++;
               rightIndex++;
            }
        }

        while (leftIndex < middleIndex)
        {
            tempArray[position++] = array[leftIndex];
            leftIndex++;
        }

        while (rightIndex <= endIndex)
        {
            tempArray[position++] = array[rightIndex];
            rightIndex++;
        }

        for (int i = beginIndex; i < endIndex + 1; i++)
            array[i] = tempArray[i - beginIndex];
    }
}
